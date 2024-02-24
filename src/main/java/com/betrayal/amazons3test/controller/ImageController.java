package com.betrayal.amazons3test.controller;

import com.betrayal.amazons3test.exception.CloudUnavailableException;
import com.betrayal.amazons3test.service.ImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("v1/images")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageController {
    ImageService service;

    @PostMapping
    public String upload(MultipartFile image) throws CloudUnavailableException, IOException {
        return service.saveImage(image);
    }

    @DeleteMapping("{imageName}")
    public void delete(@PathVariable String imageName){
        service.deleteImage(imageName);
    }
}
