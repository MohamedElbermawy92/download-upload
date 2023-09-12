package com.downloadupload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserPermissions")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserPermissions {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @Column
    String user_email;

    @Column
    String permission_level;

    @ManyToOne
    @JoinColumn(name = "id")
    Permissiongroups permissiongroup;
}
