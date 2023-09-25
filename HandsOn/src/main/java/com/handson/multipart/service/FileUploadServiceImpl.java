package com.handson.multipart.service;

import com.handson.multipart.model.UploadedFile;
import com.handson.multipart.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private String uploadFolderPath = "/home/christon/Downloads/uploaded_";

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
    public void uploadToLocal(MultipartFile multipartFile) {

        try {
            byte[] data = multipartFile.getBytes();
            Path path = Paths.get(uploadFolderPath + multipartFile.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UploadedFile uploadToDb(MultipartFile multipartFile) {

        UploadedFile uploadedFile = new UploadedFile();

        try {
            uploadedFile.setFileData(multipartFile.getBytes());
            uploadedFile.setFileType(multipartFile.getContentType());
            uploadedFile.setFileName(multipartFile.getOriginalFilename());

            UploadedFile uploadedFileToRet = fileUploadRepository.save(uploadedFile);

            return uploadedFileToRet;

        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public UploadedFile downloadFile(String fileId) {
        UploadedFile uploadedFileToRep = fileUploadRepository.getReferenceById(fileId);
        return  uploadedFileToRep;
    }
}
