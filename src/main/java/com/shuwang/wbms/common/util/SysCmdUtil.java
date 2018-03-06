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

    public static void main(String[] args) {
        try {

            System.out.println(exec("dir"));
            if (FileUtil.checkDir("e:/abc")) {
                System.out.println(exec("mysqldump -uroot -pQays1234- swsun > e:/abc/swsun.sql\n"));
                System.out.println(exec(new String[]{"cmd", "/c", "mysqldump -uroot -pQays1234- shuanglv > e:/abc/shuanglv.sql\n","Qays1234-"}));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
