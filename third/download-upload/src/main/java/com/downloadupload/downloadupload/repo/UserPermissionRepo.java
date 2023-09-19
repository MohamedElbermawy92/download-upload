package com.downloadupload.downloadupload.repo;

import com.downloadupload.downloadupload.model.Permissiongroups;
import com.downloadupload.downloadupload.model.UserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepo extends JpaRepository<UserPermissions,Integer> {

    UserPermissions findByUsername(String userName);

    boolean existsByUserEmailAndPermissionLevelAndGroup(String userEmail, String permission, Permissiongroups permissiongroups);

}
