package com.downloadupload.downloadupload.service;

import com.downloadupload.downloadupload.model.Folder;
import com.downloadupload.downloadupload.repo.FolderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FolderService {
    private final FolderRepo folderRepo;

    public Folder addFolder(Folder folder){
        return folderRepo.save(folder);
    }

}
