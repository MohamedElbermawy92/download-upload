package com.downloadupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Folder")
@Data
@NoArgsConstructor
public class Folder extends Item{

    @ManyToOne
    @JoinColumn(name = "id")
    private Space parentSpace;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<Files> files = new ArrayList<>();

}