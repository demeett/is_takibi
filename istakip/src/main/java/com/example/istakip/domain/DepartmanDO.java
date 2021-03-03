package com.example.istakip.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departman")
public class DepartmanDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departmanadi;
}
