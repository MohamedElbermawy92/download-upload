package com.downloadupload.downloadupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "files")
public class Files extends Item{

    @Lob
    @Column(name = "binary_data")
    private byte[] binaryData;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

}
