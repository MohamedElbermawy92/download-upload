package com.downloadupload.service;

import com.downloadupload.model.Files;
import com.downloadupload.repo.FileRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FileService {

    private final FileRepo fileRepo;

    public ResponseEntity<String> uploadFile(Files file){
        fileRepo.save(file);
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }

    public Optional<Files> findById(int id){
        return fileRepo.findById(id);
    }
}
