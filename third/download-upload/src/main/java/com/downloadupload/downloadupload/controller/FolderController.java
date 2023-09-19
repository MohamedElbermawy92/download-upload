package com.downloadupload.downloadupload.controller;

import com.downloadupload.downloadupload.model.Folder;
import com.downloadupload.downloadupload.model.Space;
import com.downloadupload.downloadupload.service.FolderService;
import com.downloadupload.downloadupload.service.SpaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FolderController {

    private final FolderService folderService;

    private final SpaceService spaceService;

    @ApiOperation("add folder")
    @PostMapping("/folder")
    public ResponseEntity<String> createFolder(
            @PathVariable int spaceId,
            @RequestParam String folderName,
            @RequestParam String userEmail
    ) {
        Optional<Space> space = spaceService.getSpaceById(spaceId);

        if (!spaceService.hasAccess(space.get(),"EDIT", userEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to create folders in this space.");
        }
        Folder folder= new Folder();
        folder.setName(folderName);
        folder.setParentSpace(space.get());
        folder = folderService.addFolder(folder);
        spaceService.addPermission(folder.getPermissionGroup(), userEmail, "EDIT");
        space.get().getFolders().add(folder);
        spaceService.saveSpace(space.get());
        return ResponseEntity.ok("Folder created successfully.");
    }
}
