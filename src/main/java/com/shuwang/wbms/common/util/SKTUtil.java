package com.shuwang.wbms.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Small kit util.
 * <p>
 * I think skt util is a good name :)
 * <p>
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-08-2018 17:31
 */
public interface SKTUtil {

    /**
     * @param request
     * @param response
     * @param url      Image relation path in servers.
     * @param close closed current window
     */
    default void imgUrl4CK(HttpServletRequest request, HttpServletResponse response, String url, boolean close) {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
            out.println("<script type=\"text/javascript\">");

            if(close){
                out.println("window.opener.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'"
                        + url + "','')");
                out.println("window.close();");
            }else{
                out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'"
                        + url + "','')");
            }

            out.println("</script>");

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
