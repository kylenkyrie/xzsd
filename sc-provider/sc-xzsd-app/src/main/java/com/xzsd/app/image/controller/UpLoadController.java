
package com.xzsd.app.image.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.image.service.UpLoadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/image")
public class UpLoadController {
    @Resource
    private UpLoadService upLoadService;

    /**
     * 图片上传
     * @param imageFile
     * @return
     */
    @RequestMapping(value = "uploadImage")
    AppResponse uploadImage(MultipartFile imageFile){
        return upLoadService.upLoadImage(imageFile);
    }
}
