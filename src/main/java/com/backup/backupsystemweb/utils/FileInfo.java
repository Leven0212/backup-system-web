package com.backup.backupsystemweb.utils;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * @ClassName File
 * @Description TODO
 * @Author leven
 * @Date 2022/11/2
 */

@Data
@Document("files")
public class FileInfo {
    private String name;
    private boolean usepasswd;
    private String passwd;
}
