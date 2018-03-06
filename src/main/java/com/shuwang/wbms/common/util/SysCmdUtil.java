package com.shuwang.wbms.common.util;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-06-2018 9:20
 */
public class SysCmdUtil {

    public final static String error_code = "Can not find or create directory!\n";

    public static String exec(String cmd) {

        String[] arr = null;

        if (RunningSystem.isWin10()) {
            arr = new String[]{"cmd", "/c", cmd};
        }

        if (RunningSystem.isLinux()) {
            arr = new String[]{"sh", "-c", cmd};
        }

        try {
            return exec(arr);
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }

    public synchronized static String exec(String[] cmd) throws IOException, InterruptedException {

        Process p = Runtime.getRuntime().exec(cmd);

        try (InputStream is = p.getInputStream()) {

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            p.waitFor();

            if (p.exitValue() != 0) {
                return "Executed command error";
            }

            StringBuilder sb = new StringBuilder();

            String s;

            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }

            sb.append("------------------<Executed success!>------------------\n");

            return sb.toString();
        }
    }

    public static String backupDatabase(String username, String password, String database, String path, String filename) {
        return exec("mysqldump" + " " + "-u" + username + " "
                + "-p" + password + " --default-character-set=utf8 " + database + " > " + path + "/" + filename);
    }

    public static String recoveryDatabase(String username, String password, String database, String path, String filename) {
        return exec("mysql " + " -u" + username + " -p" + password
                + " --default-character-set=utf8 " + database + " < " + path + "/" + filename);
    }

    public static String backupDatabase(String filename) {

        String path = FileUtil.getBackPath();

        if(!FileUtil.checkDir(path))
            return error_code;

        return backupDatabase(CustomizedPropertyConfigurer.getContextProperty("jdbc.username"),
                CustomizedPropertyConfigurer.getContextProperty("jdbc.password"),
                CustomizedPropertyConfigurer.getContextProperty("database.name"), path, filename);
    }

    public static String recoverDatabase(String filename) {

        String path = FileUtil.getBackPath();

        return recoveryDatabase(CustomizedPropertyConfigurer.getContextProperty("jdbc.username"),
                CustomizedPropertyConfigurer.getContextProperty("jdbc.password"),
                CustomizedPropertyConfigurer.getContextProperty("database.name"),
                path, filename);
    }

    public static String lookupDB() {
        if (RunningSystem.isWin10())
            return exec("cd /d " + CustomizedPropertyConfigurer.getContextProperty("backup.path.win10") + " && dir");
        if (RunningSystem.isLinux())
            return exec("cd " + CustomizedPropertyConfigurer.getContextProperty("backup.path.Linux") + " && ls -g");

        return error_code;
    }

    public static void main(String[] args) {
        try {

//            System.out.println(exec("dir"));
            if (FileUtil.checkDir("e:/abc")) {
                System.out.println(exec("mysqldump -uroot -pQays1234- --default-character-set=utf8 swsun > e:/abc/swsun.sql\n"));
//                System.out.println(backupDatabase("root", "Qays1234-", "shuanglv", "e:/abc", "shuanglv.sql"));
//                System.out.println(exec(new String[]{"cmd", "/c", "mysqldump -uroot -p shuanglv > e:/abc/shuanglv.sql", "cmd","/c","Qays1234-"}));
//                System.out.println("Qays1234-\n");
//                System.out.println(exec("(mysqldump -uroot -p shuanglv > e:/abc/shuanglv.sql) < Qays1234-"));
//                System.out.println(exec("d: && cd Git && dir"));
//                System.out.println(lookupDB());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
