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
@Table(name = "media")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @OneToMany(mappedBy = "media")
    private List<Status> statuses;

}
