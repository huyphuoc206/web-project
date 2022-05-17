package com.jestify.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Podcasts extends BaseEntity{
    private String name;
    private String thumbnail;
    private String description;
    private String link;
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artists artists;
    private boolean active;
}
