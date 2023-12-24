package com.mappingbasics.basesmapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor @AllArgsConstructor
public class Bag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bagName;
}
