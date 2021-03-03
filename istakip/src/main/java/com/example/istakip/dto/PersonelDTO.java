package com.example.istakip.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
@Data
public class PersonelDTO implements Serializable {
    @JsonIgnore
    private String name;
    private String surname;
}
