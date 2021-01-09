package com.freeit.cloudupload.controller;

import com.freeit.cloudupload.model.Picture;
import com.freeit.cloudupload.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class UploadBaseController {

    private final StorageService storageService;

    @Autowired
    public UploadBaseController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(Picture::getPublicUri)
                .collect(Collectors.toList()));
        return "uploadForm";
    }


}
