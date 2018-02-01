package com.shuwang.wbms.common.enums;

import com.shuwang.wbms.common.exception.MatchSystemException;
import com.shuwang.wbms.common.util.RunningSystem;
import org.omg.SendingContext.RunTime;

public enum FilePathEnum {
    winAbsolutionPath("E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files/"),
    linuxAbsolutionPath("/home/tomcat/upload-resources/upload-files/"),
    relationPath("/upload-files/"),
    imagesPath("images/"),
    sysImg("images/system/");

    private String path;

    FilePathEnum(){

    }

    FilePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

//    public String getRelationPath() {
//        return relationPath.getPath() + this.path;
//    }

//    public String getAbsolutionPath() {
//        if (RunningSystem.isWin10())
//            return winAbsolutionPath.getPath() + this.path;
//        else if(RunningSystem.isLinux())
//            return linuxAbsolutionPath.getPath() + this.path;
//        else
//            throw new MatchSystemException();
//    }

//    public String getCustomPath(String path) {
//        return this.path + imagesPath.getPath() + path + "/";
//    }

    public String getRelationPath(String path) {
        return relationPath.getPath() + this.path + path + "/";
    }

    public String getAbsolutionPath(String path){
        if (RunningSystem.isWin10())
            return winAbsolutionPath.getPath() + this.path + path + "/";
        else if(RunningSystem.isLinux())
            return linuxAbsolutionPath.getPath() + this.path + path + "/";
        else
            throw new MatchSystemException();
    }

    public static void main(String[] args) {
//        System.out.println(FilePathEnum.sysImg.getAbsolutionPath());
//        System.out.println(FilePathEnum.sysImg.getRelationPath());
//        System.out.println(FilePathEnum.relationPath.getCustomPath("system"));
        System.out.println(FilePathEnum.imagesPath.getAbsolutionPath("system"));

    }
}
