package com.downloadupload.downloadupload.repo;

import com.downloadupload.downloadupload.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepo extends JpaRepository<Space,Integer> {
}
