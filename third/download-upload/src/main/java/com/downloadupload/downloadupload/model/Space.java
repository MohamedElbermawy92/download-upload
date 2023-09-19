package com.downloadupload.downloadupload.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="space")
@Data
@EqualsAndHashCode(callSuper=false)
public class Space extends Item{

    @OneToMany(mappedBy = "parentSpace", cascade = CascadeType.ALL)
    private List<Folder> folders = new ArrayList<>();
}
