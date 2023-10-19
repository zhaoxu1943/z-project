package com.z.learn.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

import java.nio.file.Paths;


/**
 * lucene中的对象
 *
 * 被索引的文档用 Document 对象表示
 * IndexWriter 通过函数 addDocument 将文档添加到索引中， 将文档添加到索引中，实现创建索引的过程 实现创建索引的过程 实现创建反向索引的过程。
 *
 * IndexSearcher 通过函数 search 搜索 Lucene Index。
 * IndexSearcher 计算 term weight 和 score 并且将结果返回给用户。 并且将结果返回给
 *
 * 返回给用户的文档集合用 TopDocsCollector 表示。
 * @author zhaoxu
 */
public class Zlucene {




    public static void createIndexANDSearchIndex() throws Exception{
        Analyzer analyzer = new StandardAnalyzer();//标准分词器
        //RAMDirectory内存字典存储索引
        Directory directory = new RAMDirectory();
        //Directory directory = FSDirectory.open("/tmp/testindex");磁盘存储索引

        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(directory,config);
        Document document = new Document();
        String text = "hello world main test";
        document.add(new Field("filetest",text, TextField.TYPE_STORED)); //将域field添加到document中
        writer.addDocument(document);
        writer.close();



        DirectoryReader directoryReader = DirectoryReader.open(directory);
        IndexSearcher isearch = new IndexSearcher(directoryReader);
        QueryParser parser = new QueryParser("filetest",new StandardAnalyzer());
        Query query = parser.parse("main");//查询main关键词
        ScoreDoc [] hits = isearch.search(query,1000).scoreDocs;
        for (int i = 0; i <hits.length ; i++) {
            Document hitdoc =isearch.doc(hits[i].doc);
            System.out.print("命中的文件内容："+hitdoc.get("filetest"));
        }
        directoryReader.close();
        directory.close();
    }
    public static void main(String[] args) {
        try {
            createIndexANDSearchIndex();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }













//    public static void main(String[] args) {
//        try {
//
//
//
//            // 创建文档并添加到索引中
//            Document doc1 = new Document();
//            //Indexed, tokenized, stored.
//            doc1.add(new Field("title", "Lucene in Action", TextField.TYPE_STORED));
//            doc1.add(new Field("content", "Lucene is a powerful search library.", TextField.TYPE_STORED));
//            //Indexed, tokenized, stored.
//            Document doc2 = new Document();
//            doc2.add(new Field("title", "Java Programming", TextField.TYPE_STORED));
//            doc2.add(new Field("content", "Java is a widely used programming language.", TextField.TYPE_STORED));
//
//            IndexWriter writer = new IndexWriter(FSDirectory.open(Paths.get("D:\\lucene")), new IndexWriterConfig(new StandardAnalyzer())));
//
//
//            writer.addDocument(doc1);
//            writer.addDocument(doc2);
//
//            // 提交写入器并关闭
//            writer.commit();
//            writer.close();
//
//
//
//
//            // 创建索引搜索器
//            IndexSearcher searcher = new IndexSearcher("D:\\lucene"));
//
//            // 创建查询解析器
//            QueryParser parser = new QueryParser("content", new StandardAnalyzer());
//
//            // 构建查询
//            Query query = parser.parse("search library");
//
//            // 执行搜索
//            TopDocs topDocs = searcher.search(query, 10);
//
//            // 处理搜索结果
//            ScoreDoc[] hits = topDocs.scoreDocs;
//            for (ScoreDoc hit : hits) {
//                Document document = searcher.doc(hit.doc);
//                System.out.println("Title: " + document.get("title"));
//                System.out.println("Content: " + document.get("content"));
//                System.out.println("Score: " + hit.score);
//                System.out.println("--------------------------");
//            }
//
//            // 关闭搜索器和索引目录
//            searcher.getIndexReader().close();
//            directory.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}