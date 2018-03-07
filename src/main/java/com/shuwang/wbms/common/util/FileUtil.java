package com.shuwang.wbms.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author Qays
 * @createTime 2017/11/24 9:43
 */
public class FileUtil {
    public static String getSuffix(MultipartFile file){

        if (file == null)
            return "";

        String name = file.getOriginalFilename();
        int index = name.lastIndexOf(".");
        return index > 0 ? name.substring(index) : "";
    }

    public static String uuidName(MultipartFile file){

        if(file == null)
            return "";

        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid + getSuffix(file);
    }

    public static boolean checkDir(String path){
        File file = new File(path);

         if(file.exists() && file.isDirectory()) {
             return true;
         }else {
             return file.mkdir();
         }
    }

    public synchronized static String getBackPath(){
        String path = "/home";
        if(RunningSystem.isWin10())
            path = CustomizedPropertyConfigurer.getContextProperty("backup.path.win10");
        if(RunningSystem.isLinux())
            path = CustomizedPropertyConfigurer.getContextProperty("backup.path.linux");

        return path;
    }

    public synchronized static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
}
