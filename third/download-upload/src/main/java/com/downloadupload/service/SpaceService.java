package com.downloadupload.service;

import com.downloadupload.model.Permissiongroups;
import com.downloadupload.model.Space;
import com.downloadupload.model.UserPermissions;
import com.downloadupload.repo.PermissionGroupRepo;
import com.downloadupload.repo.SpaceRepo;
import com.downloadupload.repo.UserPermissionRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SpaceService {

    private final SpaceRepo spaceRepo;
    private final PermissionGroupRepo permissionGroup;
    private final UserPermissionRepo userPermissionRepo;

    public Space createSpace(String spaceName) {
        Space space = new Space();
        space.setName(spaceName);
        return spaceRepo.save(space);
    }

    public Permissiongroups createPermissionGroup(String group){
       return permissionGroup.save(Permissiongroups.builder().group_name(group).build());
    }

    public ResponseEntity<String> saveSpace(Space space){
        spaceRepo.save(space);
        return new ResponseEntity<>("Space added successfully", HttpStatus.CREATED);
    }

    public void addPermission(Permissiongroups permissiongroups, String email, String permission){

        UserPermissions user = UserPermissions.builder().permission_level(permission)
                .permissiongroup(permissiongroups).user_email(email).build();
        userPermissionRepo.save(user);

    }

    public Optional<Space> getSpaceById(int spaceId){
        return spaceRepo.findById(spaceId);
    }

    public boolean hasAccess(Space entity,String permission, String userEmail) {
        Permissiongroups permissionGroup = entity.getPermissionGroup();
        return userPermissionRepo.existsByUserEmailAndPermissionLevelAndGroup(userEmail, permission, permissionGroup);
    }
}
