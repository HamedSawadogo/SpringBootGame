package com.mappingbasics.basesmapping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mappingbasics.basesmapping.enums.ArmeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Arme {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String armName;

    @Enumerated(EnumType.STRING)
    private ArmeType typeArme;

    private int dammageArme;

    @ManyToMany(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Player>players=new ArrayList<>();

    @Override
    public String toString() {
        return "Arme{" +
                "id=" + id +
                ", armName='" + armName + '\'' +
                ", typeArme=" + typeArme +
                ", dammageArme=" + dammageArme +
                ", player=" + players.toString() +
                '}';
    }
}
