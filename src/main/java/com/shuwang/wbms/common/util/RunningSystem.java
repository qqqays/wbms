package com.shuwang.wbms.common.util;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 02-01-2018 9:11
 */
public class RunningSystem {

    private static String getTypeOfOS() {
        return System.getProperties().getProperty("os.name");
    }

    public static boolean isLinux() {
        return getTypeOfOS().equals("Linux");
    }

    public static boolean isWin10() {
        return getTypeOfOS().equals("Windows 10");
    }

}
