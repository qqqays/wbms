package com.shuwang.wbms.controller.api;

import com.shuwang.wbms.common.controller.PageController;
import com.shuwang.wbms.common.enums.WinFilePathEnum;
import com.shuwang.wbms.entity.ImageEntity;
import com.shuwang.wbms.service.ImageService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-19-2017 8:42
 */
@RestController
@RequestMapping("/api/images")
public class ImageController extends PageController{

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

    @PostMapping
    public String addImage(@RequestParam String alt, @RequestParam String title, @RequestParam String class1, @RequestParam MultipartFile[] files) {

        String relationPath = WinFilePathEnum.relationPath.getCustomPath(class1);
        String absolutionPath = WinFilePathEnum.absolutionPath.getCustomPath(class1);

        System.out.println(absolutionPath);
        System.out.println(relationPath);

        JSONArray jsonArray = new JSONArray();

        try {
            if (files != null)
                if (files.length > 0) {
                    for (MultipartFile file : files) {
                        jsonArray.put(addImg(relationPath, absolutionPath, alt, title, class1, file));
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray.toString();
    }

    @GetMapping
    public String acquireImg(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "") String search, @RequestParam String class1) {
        String[] searchColumn = {"originName", "alt", "title", "class1"};
        return new JSONObject(datagram(imageService, pageNumber, pageSize, search, "originName", searchColumn, class1)).toString();
    }

}
