package com.freeit.cloudupload.controller;

import com.freeit.cloudupload.model.Picture;
import com.freeit.cloudupload.service.StorageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
public class UploadController {

    private final StorageService storageService;

    @Autowired
    public UploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/api/upload/multi")
    public ResponseEntity<?> uploadFileToCloudinary(@RequestParam("file") MultipartFile file) {
        if(StringUtils.isEmpty(file.getOriginalFilename()) || file.isEmpty()) {
            return new ResponseEntity("uploaded file should not be empty", HttpStatus.BAD_REQUEST);
        }
        try {
            storageService.store(file);
        } catch (IOException e) {
            return new ResponseEntity<>("file upload exception", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().build();
    }

}
