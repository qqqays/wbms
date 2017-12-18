package com.shuwang.wbms.common.enums;

public enum WinFilePathEnum {

    absolutionPath("E:/src/java/wbms/out/artifacts/wbms_Web_exploded/upload-files/"),
    relationPath("/upload-file/"),
    sysImg("/images/system/");

    private String path;

    WinFilePathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getRelationPath() {
        return relationPath.getPath() + this.path;
    }

    public String getAbsolutionPath(){
        return absolutionPath.getPath() + this.path;
    }

    public static void main(String[] args) {
        System.out.println(WinFilePathEnum.sysImg.getAbsolutionPath());
        System.out.println(WinFilePathEnum.sysImg.getRelationPath());
    }
}