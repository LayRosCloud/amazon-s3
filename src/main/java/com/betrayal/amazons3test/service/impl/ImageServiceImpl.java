package com.betrayal.amazons3test.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.betrayal.amazons3test.exception.CloudUnavailableException;
import com.betrayal.amazons3test.service.ImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageServiceImpl implements ImageService {

    AmazonS3 storage;
    private static final String BUCKET_NAME = "cloud-image-betrayal";
    @Override
    public String saveImage(MultipartFile image) throws IOException, CloudUnavailableException {
        if (image == null) {
            throw new BadRequestException("Bad request! Image is null");
        }
        byte[] imageBytes = image.getBytes();

        String imageName = UUID.randomUUID().toString() + ".jpg";

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(imageBytes.length);

        ByteArrayInputStream stream = new ByteArrayInputStream(imageBytes);
        try{
            storage.putObject(BUCKET_NAME, imageName, stream, metadata);

            return storage.getUrl(BUCKET_NAME, imageName).toExternalForm();
        } catch (Exception ex){
            throw new CloudUnavailableException(ex.getMessage());
        }
    }

    @Override
    public void deleteImage(String imageName) {
        storage.deleteObject(BUCKET_NAME, imageName);
    }
}
