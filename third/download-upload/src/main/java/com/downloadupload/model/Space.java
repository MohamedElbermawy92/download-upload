package com.downloadupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="space")
@Data
@EqualsAndHashCode(callSuper=false)
public class Space extends Item{

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private List<Folder> folders = new ArrayList<>();
}
