package com.downloadupload.downloadupload.repo;

import com.downloadupload.downloadupload.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FolderRepo extends JpaRepository<Folder,Integer> {
}
