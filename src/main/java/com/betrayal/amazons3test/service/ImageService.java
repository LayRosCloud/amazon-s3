package com.betrayal.amazons3test.service;

import com.betrayal.amazons3test.exception.CloudUnavailableException;
import org.apache.coyote.BadRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String saveImage(MultipartFile image) throws IOException, CloudUnavailableException;
    void deleteImage(String imageName);
}
