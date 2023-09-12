package com.downloadupload.repo;

import com.downloadupload.model.Files;
import com.downloadupload.model.Permissiongroups;
import com.downloadupload.model.UserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepo extends JpaRepository<UserPermissions,Integer> {

    UserPermissions findByUsername(String userName);

    boolean existsByUserEmailAndPermissionLevelAndGroup(String userEmail, String permission, Permissiongroups permissiongroups);
}
