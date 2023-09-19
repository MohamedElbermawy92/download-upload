package com.downloadupload.downloadupload.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "UserPermissions")
@Data
@AllArgsConstructor
@Builder
public class UserPermissions {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    @Column
    String user_email;

    @Column
    String permission_level;

    @ManyToOne
    @JoinColumn(name = "permission_group_id")
    Permissiongroups permissiongroup;
}
