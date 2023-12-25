package com.mappingbasics.basesmapping.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@DynamicUpdate
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String playerName;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int vie;

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private List<Role>roles=new ArrayList<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    mappedBy = "players")

   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Arme>armes=new ArrayList<>();
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Bag>bags=new ArrayList<>();

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", vie=" + vie +
                ", armes=" + armes.toString() +
                '}';
    }
}
