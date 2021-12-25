package com.wenan.elasticstd;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 描述：    ElTest
 */
public class ElTest {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    public static final ElTest EL_TEST = new ElTest();

    public static void main(String[] args) throws IOException {
        // 1 执行创建引索
        ElTest elTest = ElTest.EL_TEST;
        elTest.creatIndex();
    }

    /**
     * 创建一个引索客户端
     */
    public void creatIndex() throws IOException {
        //1.创建一个索引客户端
        IndicesClient indicesClient = restHighLevelClient.indices();
        //2.创建一个creat索引请求
        CreateIndexRequest request=new CreateIndexRequest("api_index");
        //3.传递request和默认选项进行调用，并得到response响应
        CreateIndexResponse createIndexResponse = indicesClient.create(request, RequestOptions.DEFAULT);
        //4.判断是否创建成功createIndexResponse.isAcknowledged()被确认
        System.out.println(createIndexResponse.isAcknowledged());
    }
}
