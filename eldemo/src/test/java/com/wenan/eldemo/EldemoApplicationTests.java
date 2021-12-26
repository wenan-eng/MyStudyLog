package com.wenan.eldemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wenan.eldemo.model.User;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.swing.text.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class EldemoApplicationTests {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testES() {
        System.out.println(restHighLevelClient);
    }

    @Test
    public void testIndex() throws IOException {
        //1.创建一个索引客户端
        IndicesClient indicesClient = restHighLevelClient.indices();
        //2.创建一个creat索引请求
        CreateIndexRequest request=new CreateIndexRequest("api_index");
        //3.传递request和默认选项进行调用，并得到response响应
        CreateIndexResponse createIndexResponse = indicesClient.create(request, RequestOptions.DEFAULT);
        //4.判断是否创建成功createIndexResponse.isAcknowledged()被确认
        System.out.println(createIndexResponse.isAcknowledged());
    }

    @Test
    public void testIndexData() throws IOException {
        //1.创建一个索引客户端
        IndicesClient indicesClient = restHighLevelClient.indices();
        //2.创建一个creat索引请求
        CreateIndexRequest request=new CreateIndexRequest("api_index");
        //3.传递request和默认选项进行调用，并得到response响应
        CreateIndexResponse createIndexResponse = indicesClient.create(request, RequestOptions.DEFAULT);
        //4.判断是否创建成功createIndexResponse.isAcknowledged()被确认
        System.out.println(createIndexResponse.isAcknowledged());
    }

    @Test
    void getIndex() throws IOException {
        //1.创建一个索引客户端
        IndicesClient indicesClient = restHighLevelClient.indices();
        //2.创建一个get索引请求
        GetIndexRequest getIndexRequest = new GetIndexRequest("api_index");
        //3.判断索引是否存在
        System.out.println(indicesClient.exists(getIndexRequest, RequestOptions.DEFAULT));
    }

    /**
     * 删除索引
     */
    @Test
    void deleteIndex() throws IOException {
        //1.创建索引客户端
        IndicesClient indicesClient = restHighLevelClient.indices();
        //2.创建一个delete索引请求
        DeleteIndexRequest deleteIndexRequest=new DeleteIndexRequest("api_index");
        //3.执行删除请求，得到AcknowledgedResponse响应
        AcknowledgedResponse response = indicesClient.delete(deleteIndexRequest, RequestOptions.DEFAULT);
        //4.判断是否删除成功response.isAcknowledged()被确认
        System.out.println(response.isAcknowledged());
    }

    /**
     * 添加文档操作
     */
    @Test
    void addDocument() throws IOException {
        // 1. 创建实体类
        User user = new User("wenan", 19);
        // 2. 获取请求（连接入数据库）
        IndexRequest indexRequest = new IndexRequest("api_index");
        //3.规则：PUT /api_index/_doc/1
        indexRequest.id("1")
                .timeout("1s")
                .source(JSON.toJSONString(user), XContentType.JSON);
        // 4 直接调用
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());
    }

    /**
     * 根据id判断文档是否存在
     * @throws IOException
     */
    @Test
    void isExistDocument() throws IOException {
        //1.指定索引和id
        GetRequest request = new GetRequest("api_index", "1");
        //2.查询是否存在此id的文档
        System.out.println(restHighLevelClient.exists(request, RequestOptions.DEFAULT));
    }

    /**
     * 根据id获取文档信息
     * @throws IOException
     */
    @Test
    void getDocument() throws IOException {
        //1.指定索引和id
        GetRequest getRequest=new GetRequest("api_index","1");
        //2.传入getRequest获得响应
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        //3.查看文档全部信息
        System.out.println(getResponse.toString());
        //4.得到具体信息
        //索引库
        System.out.println("getResponse.getIndex() = "+getResponse.getIndex());
        //文档id
        System.out.println("getResponse.getId() = "+getResponse.getId());
        //json格式的String形式实体类信息
        System.out.println("getResponse.getSourceAsString() = "+getResponse.getSourceAsString());
        //Map形式实体类信息
        Map<String, Object> source = getResponse.getSource();
        for (String s : source.keySet()) {
            System.out.println(s+" : "+source.get(s));
        }
    }

    /**
     * 根据id删除文档
     * @throws IOException
     */
    @Test
    void deleteDocument() throws IOException {
        //1.获取deleteRequest
        DeleteRequest request = new DeleteRequest("api_index", "1");
        //2.传入restHighLevelClient客户端
        DeleteResponse delete = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        //3.查看响应结果
        System.out.println(delete.status());

    }

    /**
     * 批量处理数据（本质上还是循环）
     */
    @Test
    void batchInsertDocument() throws IOException {
        //1.创建BulkRequest
        BulkRequest bulkRequest=new BulkRequest();
        bulkRequest.timeout("10s");
        //2.创建大量数据List
        List<User> userList=new ArrayList<>();
        for(int i=0;i<5;i++){
            userList.add(new User(""+i,i*10));
        }
        //3.循环add进入bulkRequest
        for(int i=0;i<5;i++){
            bulkRequest.add(
                    new IndexRequest("api_index")
                            .id(""+i)
                            .source(JSON.toJSONString(userList.get(i)),XContentType.JSON));
        }
        //4.提交一次（可能就不需要循环提交了，效率就高一点点了）
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        //5.查看状态和是否失败
        System.out.println(bulkResponse.status()+"-"+bulkResponse.hasFailures());
    }
}
