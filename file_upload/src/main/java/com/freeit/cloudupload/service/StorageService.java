package com.freeit.cloudupload.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.freeit.cloudupload.model.Picture;
import com.freeit.cloudupload.repository.PictureRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Service
public class StorageService {

    private final Cloudinary cloudinary;
    private final PictureRepository repository;

    @Autowired
    public StorageService(PictureRepository repository) {
        this.repository = repository;
        this.cloudinary = initCloudinary();
    }

    public void store(MultipartFile file) throws IOException {
        storeToCloudinary(file);
    }

    private void storeToCloudinary(MultipartFile file) throws IOException {
        if (cloudinary == null) {
            initCloudinary();
        }
        File fileToUpLoad = new File(file.getOriginalFilename());
        FileUtils.writeByteArrayToFile(fileToUpLoad, file.getBytes());

        cloudinary.uploader().upload(fileToUpLoad, ObjectUtils.asMap("public_id", "falafelka"));

        String generatedUri = cloudinary.url().generate("falafelka.jpg");

        Picture p = new Picture();
        p.setPublicUri(generatedUri);

        System.out.println(repository.save(p));
        System.out.println(generatedUri);
    }

    public Stream<Picture> loadAll() {
        return repository.findAll().stream();
    }

    private Cloudinary initCloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dqaqlgsyc",
                "api_key", "586116457173445",
                "api_secret", "unQ4y3zjAXtKMD9h1wf0z-kxLII"));
    }
}
