//package com.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//public class UploadController {
//
//    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
//    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
//
//    @GetMapping("/uploadimage")
//    public String displayUploadForm() {
//        return "imageupload/index";
//    }
//
//    @PostMapping("/upload")
//    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) {
//        StringBuilder fileNames = new StringBuilder();
//        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
//        fileNames.append(file.getOriginalFilename());
//        try {
//            // Confirm if the directory exists before writing the file
//            Files.createDirectories(fileNameAndPath.getParent());
//            Files.write(fileNameAndPath, file.getBytes());
//            model.addAttribute("msg", "Uploaded image: " + file.getOriginalFilename());
//        } catch (IOException e) {
//            model.addAttribute("error", "Failed to upload the image: " + file.getOriginalFilename());
//            logger.error("Error while uploading image: {}", e.getMessage(), e);
//        }
//        return "imageupload/index";
//    }
//}
