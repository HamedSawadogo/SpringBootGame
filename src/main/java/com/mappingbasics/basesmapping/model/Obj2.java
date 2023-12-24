package com.mappingbasics.basesmapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "entityTwo")
@Entity
public class Obj2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Obj1 obj1;

    private String value;
}
