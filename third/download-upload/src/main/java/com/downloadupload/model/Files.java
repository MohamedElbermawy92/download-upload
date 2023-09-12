package com.downloadupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Files extends Item{

    @Lob
    @Column(name = "binary_data")
    private byte[] binaryData;

    @ManyToOne
    @JoinColumn(name = "id")
    private Folder folder;

}
