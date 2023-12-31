package com.downloadupload.downloadupload.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Folder")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Folder extends Item{

    @ManyToOne
    @JoinColumn(name = "space_id")
    private Space parentSpace;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Files> files = new ArrayList<>();

}
