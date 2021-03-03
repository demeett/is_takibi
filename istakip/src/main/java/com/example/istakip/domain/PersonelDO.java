package com.example.istakip.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="personels")

public class PersonelDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departman_id")
    private DepartmanDO departman;


    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personelid")
    //private Set<PersonelDO> isler= new HashSet<>();

}
