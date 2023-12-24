package com.mappingbasics.basesmapping.model;

import io.swagger.models.auth.In;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "entityOne")
@Entity
public class Obj1 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Obj2> obj2;

    private String value;
}

