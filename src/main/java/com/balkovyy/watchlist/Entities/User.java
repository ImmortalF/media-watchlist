package com.balkovyy.watchlist.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    @Column(name = "pasword")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Status> statuses;

}
