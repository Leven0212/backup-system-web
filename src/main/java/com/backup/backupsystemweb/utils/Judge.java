package com.backup.backupsystemweb.utils;

/**
 * @ClassName Judge
 * @Description TODO
 * @Author leven
 * @Date 2022/11/2
 */

public class Judge {
    /**
     * 判断是否需要密码
     * @param file      文件名
     * @param method    备份或加密类型
     * @return          需要密码则返回true，否则返回false；
     */
    public static boolean UsePasswd(String file, String method) {
        if(method.equals("jiami") | method.equals("jiemi")) {
            return true;
        }
        return false;
    }
}
