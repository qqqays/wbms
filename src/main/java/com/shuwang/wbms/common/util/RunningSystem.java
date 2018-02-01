package com.shuwang.wbms.common.util;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 02-01-2018 9:11
 */
public class RunningSystem {

    public static String getTypeOfOS() {
        return System.getProperties().getProperty("os.name");
    }


    public static boolean isLinux(){
        if (getTypeOfOS().equals("Linux")) {
            return true;
        }
        return false;
    }

    public static boolean isWin10(){
        if (getTypeOfOS().equals("Windows 10")) {
            return true;
        }
        return false;
    }

}
