//package com.xzsd.app.image.controller;
//
//import com.neusoft.core.restful.AppResponse;
//import com.xzsd.app.image.service.ImageService;
//import com.xzsd.app.register.controller.RegisterController;
//import com.xzsd.app.register.service.RegisterService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.awt.*;
//
//@RestController
//@RequestMapping("/image")
//public class ImageController {
//    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
//
//    @Resource
//    private ImageService imageService;
//
//    /**
//     * demo 图片上传
//     * @return AppResponse
//     * @author 杨明镇
//     * @Date 2020-04-10
//     */
//    @PostMapping("uploadImage")
//    public AppResponse uploadImage(){
//        try{
//            AppResponse appResponse = imageService.main();
//            return appResponse;
//        } catch (Exception e){
//            logger.error("图片上传失败",e);
//            System.out.println(e.toString());
//            throw e;
//        }
//    }
//}
