package com.backup.backupsystemweb.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @ClassName Algorithm
 * @Description TODO
 * @Author leven
 * @Date 2022/11/5
 */

public class Algorithm {
    private static String pathname = "/home/ubuntu/backup-system";

    public static String deal(List<String> str) {
        if(str.get(0).equals("backup")) {
            str.remove(0);
            return backup(str);
        } else if (str.get(0).equals("recover")) {
            str.remove(0);
            return recover(str);
        } else {
            str.remove(0);
            return check(str);
        }
    }

    private static String backup(List<String> str) {
        try {
            Process p = null;
            String line = null;
            ProcessBuilder pb = null;
            BufferedReader stdout = null;

            if(str.get(str.size()-1) == null) {
                str.remove(str.size()-1);
            }
//            添加备份参数
            str.add(1, "0");
            if(str.get(2).equals("jichu")) {
                str.set(2, "0");
            } else if (str.get(2).equals("yasuo")) {
                str.set(2, "1");
            } else {
                str.set(2, "2");
            }
            str.add(0, "./build/code/backup");
            pb = new ProcessBuilder(str);
            pb.directory(new File(pathname));
            p = pb.start();
            stdout = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }
            int ret = p.waitFor();
            System.out.println("return code is " + ret);
            stdout.close();
            String ans = analyze(ret);
            return ans;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String recover(List<String> str) {
        return "";
    }

    private static String check(List<String> str) {
        return "";
    }

    private static String analyze(int code) {
        if(code == 0)
            return "成功";
        else return "失败";
    }
}
