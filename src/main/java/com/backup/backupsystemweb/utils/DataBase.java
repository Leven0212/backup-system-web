package com.backup.backupsystemweb.utils;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DataBase
 * @ClassName DataBase
 * @Description TODO
 * @Author leven
 * @Date 2022/11/2
 */

public class DataBase {
    @Resource
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "files";

    public Object insert(String name, boolean use, String passwd) {
        // 设置用户信息
        FileInfo file = new FileInfo()
                .setName(name)
                .setUsepasswd(use)
                .setPasswd(passwd);
        // 插入一条用户数据，如果文档信息已经存在就抛出异常
        FileInfo newFileInfo = mongoTemplate.insert(file, COLLECTION_NAME);
        // 输出存储结果
        return newFileInfo;
    }

    public Object findAll() {
        // 执行查询集合中全部文档信息
        List<FileInfo> documentList = mongoTemplate.findAll(FileInfo.class, COLLECTION_NAME);
        // 输出结果
        return documentList;
    }

    public Object findOne(String name) {
        // 设置查询条件参数
        String filename = name;
        // 创建条件对象
        Criteria criteria = Criteria.where("name").is(filename);
        // 创建查询对象，然后将条件对象添加到其中
        Query query = new Query(criteria);
        // 查询一条文档，如果查询结果中有多条文档，那么就取第一条
        FileInfo fileInfo = mongoTemplate.findOne(query, FileInfo.class, COLLECTION_NAME);
        // 输出结果
        return fileInfo;
    }
}
