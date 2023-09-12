package com.downloadupload.controller;
import com.downloadupload.model.Files;
import com.downloadupload.service.FileService;
import com.downloadupload.service.SpaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FileController {

   private final FileService fileService;

    @ApiOperation("upload file")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") Files file) throws IOException {
        return fileService.uploadFile(file);
    }

    private final SpaceService spaceService;

    @ApiOperation("download file")
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(
            @PathVariable int fileId,
            @RequestParam String userEmail
    ) {
        Optional<Files> file = fileService.findById(fileId);

        if (!spaceService.hasAccess(file.get().getFolder().getParentSpace(),"VIEW", userEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        byte[] fileData = file.get().getBinaryData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.get().getName()).build());

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }
}
