# coding: UTF-8
import time
import torch
import numpy as np
from train_eval import train, init_network
from train_eval_pause_retrain import train,train_from_checkpoint,init_network,predict
from flask import Flask, request,jsonify
from importlib import import_module
import logging
import argparse
import pandas as pd
import datetime
import traceback
app = Flask(__name__)
#，注意这是配置
logging.basicConfig(level=logging.ERROR, filename='THUCNews\log\log_error_predict.log', filemode='a+',format="%(asctime)s %(levelname)s %(message)s",datefmt="%Y-%m-%d %H:%M:%S")



def load_checkpoint(filename):
    checkpoint = torch.load(filename)
    epoch = checkpoint['epoch']
    loss=checkpoint['loss']
    model.load_state_dict(checkpoint['state_dict'])
    ##这个能不能也加载断点的
    optimizer = torch.optim.Adam(model.parameters(), lr=config.learning_rate)
    optimizer.load_state_dict(checkpoint['optimizer'])
    return loss,epoch,optimizer

def predict_txtdata(model,embedding_mode,word_m1,word_m2):

    dataset = 'THUCNews'  # 数据集
    predict_eng_file_name = 'predict_english_0718.txt'
    predict_file_name = 'predict_0718.txt'
    resume_from_checkpoint = r'C:\ucbd\分级分类\code\Chinese-Text-Classification-Pytorch-master\THUCNews\saved_dict\TextCNN.pth.tar'
    # resume_from_checkpoint=False
    # 搜狗新闻:embedding_SougouNews.npz, 腾讯:embedding_Tencent.npz, 随机初始化:random
    embedding = 'embedding_chin_word_1200.pt'
    embedding_eng = 'embedding_eng_abbr_word_1000.pt'
    if embedding_mode == 'random':
        embedding = 'random'
        embedding_eng='random'
    model_name = model  # 'TextRCNN'  # TextCNN, TextRNN, FastText, TextRCNN, TextRNN_Att, DPCNN, Transformer
    if model_name == 'FastText':
        from utils_fasttext import build_dataset, build_iterator, get_time_dif
        embedding = 'random'
    else:
        from utils_own import build_dataset, build_eng_dataset, build_iterator, get_time_dif
    x = import_module('models.' + model_name)

    config = x.Config(dataset, embedding, embedding_eng, predict_file_name, predict_eng_file_name)
    np.random.seed(1)
    torch.manual_seed(1)
    torch.cuda.manual_seed_all(1)
    torch.backends.cudnn.deterministic = True  # 保证每次结果一样

    start_time = time.time()
    print("Loading data...")
    ##注意虽然是predict，也要带个label，可以是自己造的
    predict_data = build_dataset(config, word_m1, mode='predict')
    predict_data_eng = build_eng_dataset(config, word_m2, mode='predict')
    predict_data_full = [[predict_data[i], predict_data_eng[i]] for i in range(len(predict_data))]

    predict_iter = build_iterator(predict_data_full, config)
    time_dif = get_time_dif(start_time)
    print("Time usage:", time_dif)

    # train
    # config.n_vocab = len(vocab)
    model = x.Model(config).to(config.device)
    predict_all = predict(config, model, predict_iter)
    label_dict = {}
    for label_int, label in enumerate(config.class_list):
        label_dict[label_int] = label
    predict_label=[label_dict[i] for i in predict_all]
    return predict_label
##处理json数据
@app.route('/json_predict', methods=['POST'])
def process_data_predict():
    logging.info("process_data_predict called")
    try:
        print(request.headers)
        # print(type(request.json))
        # print(request.json)
        ##数据保存到csv
        json_list = request.get_json()
        # print(type(json_list), type(json_list[0]))
        ver_name = datetime.datetime.strftime(datetime.datetime.now(),'%Y%m%d')+'_'+str(int(time.time()))
        df = pd.DataFrame(json_list[:-1], columns=["id", "field", "des"])
        print(df.head())
        df.to_csv('THUCNews/data/predict_{ver_name}.csv'.format(ver_name=ver_name),index=False)
        json_list = request.get_json()
        print(type(json_list),type(json_list[0]),json_list)
        obj_file = 'THUCNews/data/predict_english_0718.txt'
        with open(obj_file, 'w', encoding='UTF-8') as file:
            for i in range(len(json_list)):
                field_string=json_list[i]['field']
                field_string=field_string.replace('\n',' ')
                field_string=field_string.replace('_',' ')
                file.write(field_string + '\t' + '0' + '\n')
        obj_file = 'THUCNews/data/predict_0718.txt'
        with open(obj_file, 'w', encoding='UTF-8') as file:
            for i in range(len(json_list)):
                des_string=json_list[i]['des']
                des_string=des_string.replace('\n',' ')
                if des_string=='null' or json_list[i]['des']=='':
                    file.write('空白' + '\t' + '0' + '\n')
                else:
                    file.write(des_string + '\t' + '0' + '\n')
        # field_str = request.json['field']
        # desc_str = request.json['des']
        model='TextCNN_SelfDefine'
        embedding_mode = 'pre_trained'
        word_m1 = False
        word_m2=True

        predict_all=predict_txtdata(model,embedding_mode,word_m1,word_m2)
        id_list=[i['id'] for i in json_list]
        # print("len",len(id_list),len(predict_all))
        predict_list = []
        for i, j in list(zip(id_list, predict_all)):
            predict_list.append({"id": int(i), "label": str(j)})
        print("predict_list", predict_list)
        return jsonify(data=predict_list)

        # raise ValueError("This is a sample exception.")
    except Exception as e:
        # 将异常信息输出到日志
        logging.exception("An error occurred")
        return jsonify({"message": "An error occurred."}), 500



if __name__ == '__main__':
    # try:
    app.run(host='0.0.0.0',port=5000, debug=True)


    # except Exception as e:
    #
    #     logging.error(f"An error occurred: {str(e)}")
    #     logging.error(traceback.format_exc())  # 输出异常的traceback信息
    #     traceback.print_exc(file=open('THUCNews\log\log_error_predict.log','a+'))
    #     # raise
    #
    #
    #
    # # if resume_from_checkpoint:
    # #     # start_loss,start_epoch,start_optimizer = load_checkpoint(resume_from_checkpoint)
    # #     train_from_checkpoint(config, model, train_iter, dev_iter, test_iter)
    # # else:
    # # train(config, model, train_iter, dev_iter, test_iter)
