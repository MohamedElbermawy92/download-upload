package com.downloadupload.downloadupload.controller;

import com.downloadupload.downloadupload.model.Permissiongroups;
import com.downloadupload.downloadupload.model.Space;
import com.downloadupload.downloadupload.service.SpaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/space")
@AllArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @ApiOperation("add space")
    @PostMapping("/add")
    public ResponseEntity<String> createSpace() {

        Space space = spaceService.createSpace("stc-assessments");

        Permissiongroups adminGroup = spaceService.createPermissionGroup("admin group");

        spaceService.addPermission(adminGroup, "admin@example.com", "VIEW");
        spaceService.addPermission(adminGroup, "admin@example.com", "EDIT");
        spaceService.addPermission(adminGroup, "editor@example.com", "VIEW");
        spaceService.addPermission(adminGroup, "editor@example.com", "EDIT");

        space.setPermissionGroup(adminGroup);
        spaceService.saveSpace(space);

        return ResponseEntity.ok("Space created successfully.");
    }
}
