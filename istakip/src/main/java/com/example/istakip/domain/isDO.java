package com.example.istakip.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "isler")
public class isDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String isadi;

    @OneToOne
    @JoinColumn(name = "personel_id")
    private PersonelDO personel;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="personel_id" ,nullable = false)
    //private PersonelDO personelid;




}




