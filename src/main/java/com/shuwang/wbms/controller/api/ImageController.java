package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.controller.ProController;
import com.shuwang.wbms.common.enums.WinFilePathEnum;
import com.shuwang.wbms.entity.ImageEntity;
import com.shuwang.wbms.service.ImageService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-19-2017 8:42
 */
@RestController
@RequestMapping("/api/images")
public class ImageController extends ProController{

    @Autowired
    private ImageService imageService;

    public String addImg(String relationPath, String absolutionPath, String alt, String title, String class1, MultipartFile file) {

        String originName = file.getOriginalFilename();
        String imgRelationPath = relationPath + originName;
        String imgAbsolutionPath = absolutionPath + originName;

        ImageEntity ie = new ImageEntity();

        ie.setOriginName(originName);
        ie.setRelativePath(relationPath);
        ie.setAbsolutePath(absolutionPath);
        ie.setAlt(alt);
        ie.setTitle(title);
        ie.setClass1(class1);
        ie.setUrl(imgRelationPath);

        try {
            file.transferTo(new File(imgAbsolutionPath));
            imageService.insert(ie);
            return imgRelationPath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "insert error";
    }

    @PostMapping("/{content}")
    public String addImage(@RequestParam(defaultValue = "") String alt, @RequestParam(defaultValue = "") String title, @PathVariable String content, @RequestParam MultipartFile[] files) {

        String relationPath = WinFilePathEnum.relationPath.getCustomPath(content);
        String absolutionPath = WinFilePathEnum.absolutionPath.getCustomPath(content);

        System.out.println(absolutionPath);
        System.out.println(relationPath);

        JSONArray jsonArray = new JSONArray();

        try {
            if (files != null)
                if (files.length > 0) {
                    for (MultipartFile file : files) {
                        jsonArray.put(addImg(relationPath, absolutionPath, alt, title, content, file));
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray.toString();
    }

    @PostMapping("/ckEditor")
    public String ckEditor(HttpServletRequest request, HttpServletResponse response) {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (multipartResolver.isMultipart(request)) {

            String relationPath = WinFilePathEnum.relationPath.getCustomPath("ckEditor");
            String absolutionPath = WinFilePathEnum.absolutionPath.getCustomPath("ckEditor");

            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multiRequest.getFileNames();

            try {
                while (it.hasNext()) {
                    MultipartFile file = multiRequest.getFile(it.next());

                    if (file != null) {

                        addImg(relationPath, absolutionPath, "", "", "ckEditor", file);

                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
                        out.println("<script type=\"text/javascript\">");
                        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + relationPath + file.getOriginalFilename() + "','')");
                        out.println("</script>");

                        out.flush();
                        out.close();

//                        return rePath + name;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "upload error";
            }
        }
        return "upload success";
    }

    @GetMapping("/{content}")
    public String acquireImg(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "") String search, @PathVariable String content) {
        String[] searchColumn = {"originName", "alt", "title", "class1"};
        return new JSONObject(datagram(imageService, pageNumber, pageSize, search, "originName", searchColumn, content)).toString();
    }

}
