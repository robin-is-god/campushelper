package edu.cuit.robin.campushelper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:52 2019/5/4
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/upload")
public class ImageWxController {

    @Value("${filePath}")
    private String filePath;

    @RequestMapping(value = "/uploadImage", method = { RequestMethod.POST})
    public Map<String,Object> uploadImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("------------图片上传----------------");
        Map<String,Object> map = new HashMap<>();
        String name="";
        MultipartHttpServletRequest req =(MultipartHttpServletRequest)request;
        MultipartFile multipartFile =  req.getFile("file");
        String realPath = "F:/image";
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            name = multipartFile.getOriginalFilename().substring(48);
            File file  =  new File(realPath,name);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        map.put("url",filePath + name);
        return map;
    }
}