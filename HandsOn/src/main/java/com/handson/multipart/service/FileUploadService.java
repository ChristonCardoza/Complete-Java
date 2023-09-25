package com.handson.multipart.service;

import com.handson.multipart.model.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public void uploadToLocal(MultipartFile multipartFile);

    public UploadedFile uploadToDb(MultipartFile multipartFile);

    public UploadedFile downloadFile(String fileId);
}
