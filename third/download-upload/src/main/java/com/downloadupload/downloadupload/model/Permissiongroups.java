package com.downloadupload.downloadupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Permission_Group")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Permissiongroups {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @Column(nullable = false, unique = true)
    String group_name;
}
