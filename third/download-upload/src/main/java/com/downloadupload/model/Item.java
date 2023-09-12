package com.downloadupload.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @Column
    String type;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "id")
    Permissiongroups permissionGroup;
}
