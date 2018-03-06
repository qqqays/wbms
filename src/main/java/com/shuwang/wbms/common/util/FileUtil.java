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
}
