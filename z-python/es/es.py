import json
import time
import uuid
from multiprocessing import Process

from elasticsearch import Elasticsearch
from elasticsearch.helpers import bulk

# 多线程插入es数据py脚本: 仅适用于linux

# 连接到目标Elasticsearch实例
es = Elasticsearch('http://10.7.201.159:9201')

json_str = '{"took":3202,"timed_out":false,"_shards":{"total":5,"successful":5,"skipped":0,"failed":0},"hits":{"total":{"value":10000,"relation":"gte"},"max_score":1,"hits":[{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"Z-mk_YgBo500QUIe-UV9","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549067868427855816","FOUND_TIME":"2023-06-28 00:15:36","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"55916","TOTAL_LENGTH":"289","D_IP":["218.17.85.2"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:15:36","PRODUCER_ID":"12608","SESS_ID":"27189680634727","D_MAC":"f4:79:60:72:7d:e3","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:15:36","OUT_PKTS":"12","ADDR_LIST":"17851-443-223.104.69.244-218.17.85.2","IP_TTL":"50","END_TIME":"2023-06-28 00:15:36","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"8032","S_IP":["223.104.69.244"],"IN_PKTS":"16","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189680634727","TIME":"2023-06-28 00:15:36","S_PORT":[17851],"D_PORT":[443],"IN_BYTES":"2160","S_MAC":"00:00:00:10:40:30"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"bSWk_YgBM5fHxbL--a9n","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3548997499672309111","FOUND_TIME":"2023-06-28 00:14:46","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"19474","TOTAL_LENGTH":"290","D_IP":["119.29.29.29"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:14:46","PRODUCER_ID":"12608","SESS_ID":"27189679560877","D_MAC":"00:00:00:10:40:30","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:14:46","OUT_PKTS":"2","ADDR_LIST":"51793-53-61.144.225.185-119.29.29.29","IP_TTL":"122","END_TIME":"2023-06-28 00:15:41","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_UDP","OUT_BYTES":"368","S_IP":["61.144.225.185"],"IN_PKTS":"2","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189679560877","TIME":"2023-06-28 00:14:46","S_PORT":[51793],"D_PORT":[53],"IN_BYTES":"126","S_MAC":"f4:79:60:72:7d:e3"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"TLak_YgBceeiAbif-XR0","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549067868427867658","FOUND_TIME":"2023-06-28 00:15:13","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"45351","TOTAL_LENGTH":"293","D_IP":["202.104.121.61"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"341","DEVICE_ID":"2","START_TIME":"2023-06-28 00:15:13","PRODUCER_ID":"12608","SESS_ID":"27189680152712","D_MAC":"ac:75:1d:66:48:0d","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:15:13","OUT_PKTS":"56","ADDR_LIST":"48438-80-113.88.90.32-202.104.121.61","IP_TTL":"53","END_TIME":"2023-06-28 00:15:38","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"66928","S_IP":["113.88.90.32"],"IN_PKTS":"49","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"636","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189680152712","TIME":"2023-06-28 00:15:13","S_PORT":[48438],"D_PORT":[80],"IN_BYTES":"3974","S_MAC":"f4:79:60:72:7d:e3"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"VLak_YgBceeiAbif-XR0","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549067868427867673","FOUND_TIME":"2023-06-28 00:16:38","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"7862","TOTAL_LENGTH":"287","D_IP":["10.253.118.67"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:16:38","PRODUCER_ID":"12608","SESS_ID":"27189681952643","D_MAC":"00:00:5e:00:01:c9","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:16:38","OUT_PKTS":"4","ADDR_LIST":"10076-80-10.253.0.166-10.253.118.67","IP_TTL":"58","END_TIME":"2023-06-28 00:16:38","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"2723","S_IP":["10.253.0.166"],"IN_PKTS":"6","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"1","FLOW_ID":"27189681952643","TIME":"2023-06-28 00:16:38","S_PORT":[10076],"D_PORT":[80],"IN_BYTES":"325","S_MAC":"ac:75:1d:66:48:01"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"fOmk_YgBo500QUIe-UV9","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549032683920575533","FOUND_TIME":"2023-06-28 00:08:45","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"31704","TOTAL_LENGTH":"294","D_IP":["218.17.86.140"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:08:45","PRODUCER_ID":"12608","SESS_ID":"27189671928724","D_MAC":"f4:79:60:72:7d:e3","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:08:45","OUT_PKTS":"4","ADDR_LIST":"52394-4500-218.18.110.202-218.17.86.140","IP_TTL":"122","END_TIME":"2023-06-28 00:08:45","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"0","S_IP":["218.18.110.202"],"IN_PKTS":"10","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189671928724","TIME":"2023-06-28 00:08:45","S_PORT":[52394],"D_PORT":[4500],"IN_BYTES":"204","S_MAC":"00:00:00:10:40:30"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"fumk_YgBo500QUIe-UV9","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549032683920575536","FOUND_TIME":"2023-06-28 00:08:10","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"22620","TOTAL_LENGTH":"290","D_IP":["202.96.164.8"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:08:10","PRODUCER_ID":"12608","SESS_ID":"27189671169193","D_MAC":"ac:75:1d:66:48:0d","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:08:10","OUT_PKTS":"14","ADDR_LIST":"20526-443-113.88.89.142-202.96.164.8","IP_TTL":"57","END_TIME":"2023-06-28 00:08:46","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"2171","S_IP":["113.88.89.142"],"IN_PKTS":"25","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189671169193","TIME":"2023-06-28 00:08:10","S_PORT":[20526],"D_PORT":[443],"IN_BYTES":"9774","S_MAC":"f4:79:60:72:7d:e3"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"humk_YgBo500QUIe-UV9","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549032683920575542","FOUND_TIME":"2023-06-28 00:08:45","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"31032","TOTAL_LENGTH":"294","D_IP":["218.17.86.140"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:08:45","PRODUCER_ID":"12608","SESS_ID":"27189671929225","D_MAC":"f4:79:60:72:7d:e3","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:08:45","OUT_PKTS":"6","ADDR_LIST":"10814-4500-202.105.144.30-218.17.86.140","IP_TTL":"121","END_TIME":"2023-06-28 00:08:45","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"0","S_IP":["202.105.144.30"],"IN_PKTS":"8","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189671929225","TIME":"2023-06-28 00:08:45","S_PORT":[10814],"D_PORT":[4500],"IN_BYTES":"110","S_MAC":"00:00:00:10:40:30"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"ryWk_YgBM5fHxbL--a9n","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3549067868299230198","FOUND_TIME":"2023-06-28 00:08:52","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"46305","TOTAL_LENGTH":"293","D_IP":["10.253.103.211"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:08:52","PRODUCER_ID":"12608","SESS_ID":"27189672085723","D_MAC":"ac:75:1d:66:48:0d","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:08:52","OUT_PKTS":"4","ADDR_LIST":"42944-80-61.144.225.188-10.253.103.211","IP_TTL":"59","END_TIME":"2023-06-28 00:08:52","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"156","S_IP":["61.144.225.188"],"IN_PKTS":"5","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189672085723","TIME":"2023-06-28 00:08:52","S_PORT":[42944],"D_PORT":[80],"IN_BYTES":"58","S_MAC":"f4:79:60:72:7d:e3"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"p7ak_YgBceeiAbif-XR0","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3548927130816887356","FOUND_TIME":"2023-06-28 00:08:47","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"16806","TOTAL_LENGTH":"294","D_IP":["218.17.86.140"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:08:47","PRODUCER_ID":"12608","SESS_ID":"27189671963556","D_MAC":"f4:79:60:72:7d:e3","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:08:47","OUT_PKTS":"7","ADDR_LIST":"27191-4500-119.136.20.152-218.17.86.140","IP_TTL":"123","END_TIME":"2023-06-28 00:08:47","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"0","S_IP":["119.136.20.152"],"IN_PKTS":"8","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189671963556","TIME":"2023-06-28 00:08:47","S_PORT":[27191],"D_PORT":[4500],"IN_BYTES":"204","S_MAC":"00:00:00:10:40:30"}},{"_index":"llhj_netflow_log_2023-10-08","_type":"llhj_netflow_log","_id":"tiWk_YgBM5fHxbL--a9n","_score":1,"_source":{"DATA_SUBTYPE":"5638","DATA_ID":"3548997499672309287","FOUND_TIME":"2023-06-28 00:15:00","TAG_VERSION":"1.0","APP_LABEL":"9","IP_ID":"51500","TOTAL_LENGTH":"289","D_IP":["10.253.103.211"],"TAG_SCHEMA_ID":"75","S2C_TCP_LOSTLEN":"0","DEVICE_ID":"2","START_TIME":"2023-06-28 00:15:00","PRODUCER_ID":"12608","SESS_ID":"27189682005459","D_MAC":"ac:75:1d:66:48:0d","DVC_T":"数据总线流量汇接子系统/数据总线流量汇接子系统/数据总线流量汇接子系统","ADDR_TYPE":"4","PRO_A":"BASE","RECV_TIME":"2023-06-28 00:15:00","OUT_PKTS":"4","ADDR_LIST":"47890-80-192.168.95.8-10.253.103.211","IP_TTL":"57","END_TIME":"2023-06-28 00:16:41","DVC_A":"172.19.12.161","DATA_TYPE":"1","CFG_ID":"0","PRO_T":"IPv4_TCP","OUT_BYTES":"156","S_IP":["192.168.95.8"],"IN_PKTS":"5","TAG_LENGTH":"30","C2S_TCP_LOSTLEN":"0","DATA_SOURCE":"6","TAG_DATA_TYPE":"1","CAP_IP":"172.19.3.2","DATA_SCHEMA_ID":"43","STREAM_DIR":"3","FLOW_ID":"27189682005459","TIME":"2023-06-28 00:15:00","S_PORT":[47890],"D_PORT":[80],"IN_BYTES":"58","S_MAC":"f4:79:60:72:7d:e3"}}]}}'
# 将JSON字符串转换为JSON对象
json_data = json.loads(json_str)

# 单次请求,发送data的批次
batch = 15
# 循环次数
max_forTime = 99999999
# 自定义进程数量
max_processes = 15
total = max_forTime * max_processes * batch * 10


# 定义处理文件的函数
def process_file():
    for i in range(1, max_forTime):
        # 批量插入数据列表
        bulk_data = []

        for j in range(1, batch):

            # 从文件中读取JSON数据
            # 遍历hits中的文档数据
            for hit in json_data['hits']['hits']:
                # 提取要导入的文档数据
                doc = hit['_source']

                # 导入到新的Elasticsearch中
                index_name = hit['_index']
                # 生成UUID作为新的doc_id
                doc_id = str(uuid.uuid4())

                # 创建插入操作字典
                action = {
                    '_index': index_name,
                    '_id': doc_id,
                    '_source': doc
                }

                # 将插入操作添加到批量数据列表
                bulk_data.append(action)

        # 使用批量插入API执行批量插入操作
        bulk(es, bulk_data)


# 统计运行时间
start_time = time.time()

# 读取esdata文件夹下的所有文件
processes = []

for i in range(1, max_processes):
    # 创建进程并启动
    process = Process(target=process_file, args=())
    process.start()
    processes.append(process)

# 等待所有进程完成
for process in processes:
    process.join()

# 计算运行时间
end_time = time.time()
total_time = end_time - start_time
avg = total / total_time
print(f"总运行时间：{total_time}秒,共发送:{total},平均每秒:{avg}")
