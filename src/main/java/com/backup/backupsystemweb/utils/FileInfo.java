package com.backup.backupsystemweb.utils;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @ClassName File
 * @Description TODO
 * @Author leven
 * @Date 2022/11/2
 */

@Data
@ToString
@Accessors(chain = true)
public class FileInfo {
    private String name;
    private boolean usepasswd;
    private String passwd;
}
