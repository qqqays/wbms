package com.shuwang.wbms.controller;

import com.shuwang.wbms.common.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.UUID;

/**
 * @author Qays
 * @createTime 2017/11/23 16:28
 */

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/file-test")
    @ResponseBody
    public String file(HttpServletRequest request) {

        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> it = multiRequest.getFileNames();
//        String relativePath = "files\\";
        String absolutePath = request.getSession().getServletContext().getRealPath("/files/");

        int i = 0;
        try {
            while (it.hasNext()) {
                MultipartFile file = multiRequest.getFile(it.next());

                if (!file.isEmpty()) {

                    file.transferTo(new File(absolutePath + FileUtil.uuidName(file)));
                    i++;
                }
            }
        } catch (Exception ie) {
            ie.printStackTrace();
            return " error";
        }
        return i + " success";
    }
}
