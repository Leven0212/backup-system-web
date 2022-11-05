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

    /**
     * 判断当前待恢复文件是否有被加密备份的文件
     * @param file  文件名
     * @return      有则返回true，否则返回false
     */
    public static boolean HavePasswd(String file) {
        FileInfo fileInfo = (FileInfo) DataBase.findOne(file);
        if(fileInfo == null | !fileInfo.isUsepasswd()) return false;
        else return true;
    }

    public static boolean checkPasswd(String file, String passwd) {
        FileInfo fileInfo = (FileInfo) DataBase.findOne(file);
        if(!fileInfo.getPasswd().equals(passwd)) return false;
        else return true;
    }
}
