package com.downloadupload.repo;

import com.downloadupload.model.Permissiongroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionGroupRepo extends JpaRepository<Permissiongroups,Integer> {
}
