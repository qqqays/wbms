package com.shuwang.wbms.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-06-2018 17:35
 */
public class DBUtil {

    public final static String error_code = "Can not find or create directory!\n";

    public static String backupDatabase(String username, String password, String database, String path, String filename) {

        return backupDatabase(username, password, database, path + "/" + filename);
    }

    public static String backupDatabase(String username, String password, String database, String absolutePath){
        return SysCmdUtil.exec("mysqldump" + " " + "-u" + username + " "
                + "-p" + password + " --default-character-set=utf8 " + database + " > " + absolutePath);
    }

    public static String backupDatabase(String filename) {

        String path = FileUtil.getBackPath();

        if(!FileUtil.checkDir(path))
            return error_code;

        return backupDatabase(CustomizedPropertyConfigurer.getContextProperty("jdbc.username"),
                CustomizedPropertyConfigurer.getContextProperty("jdbc.password"),
                CustomizedPropertyConfigurer.getContextProperty("database.name"), path, filename);
    }

    public static String recoveryDatabase(String username, String password, String database, String path, String filename) {
        return recoveryDatabase(username, password, database, path + "/" + filename);
    }

    public static String recoveryDatabase(String username, String password, String database, String absolutePath){
        return SysCmdUtil.exec("mysql " + " -u" + username + " -p" + password
                + " --default-character-set=utf8 " + database + " < " + absolutePath);
    }

    public static String recoverDatabase(String filename) {

        String path = FileUtil.getBackPath();

        return recoveryDatabase(CustomizedPropertyConfigurer.getContextProperty("jdbc.username"),
                CustomizedPropertyConfigurer.getContextProperty("jdbc.password"),
                CustomizedPropertyConfigurer.getContextProperty("database.name"),
                path, filename);
    }

    public static String recoverDatabaseByAbsolute(String absolutePath){
        return recoveryDatabase(CustomizedPropertyConfigurer.getContextProperty("jdbc.username"),
                CustomizedPropertyConfigurer.getContextProperty("jdbc.password"),
                CustomizedPropertyConfigurer.getContextProperty("database.name"),
                absolutePath);
    }

    public static String lookupDBFile() {
        if (RunningSystem.isWin10())
            return SysCmdUtil.exec("cd /d " + CustomizedPropertyConfigurer.getContextProperty("backup.path.win10") + " && dir");
        if (RunningSystem.isLinux())
            return SysCmdUtil.exec("cd " + CustomizedPropertyConfigurer.getContextProperty("backup.path.linux") + " && ls -g");

        return error_code;
    }

    public static List<String> dbFileList(){
        String path = FileUtil.getBackPath();
//        String path = "e:/abc";

        File dir = new File(path);
        List<String> list = new ArrayList<>();


        if (dir.exists()) {
            for(File file:dir.listFiles()){
                if (file.isFile()) {
                    list.add(file.toString());
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        dbFileList();
    }
}
