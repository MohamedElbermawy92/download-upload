package com.downloadupload.service;

import com.downloadupload.model.Folder;
import com.downloadupload.repo.FolderRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FolderService {

    private final FolderRepo folderRepo;

    public Folder addFolder(Folder folder){
        return folderRepo.save(folder);
    }
}
