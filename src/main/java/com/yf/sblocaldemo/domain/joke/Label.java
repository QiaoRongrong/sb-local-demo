package com.yf.sblocaldemo.domain.joke;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "label")
public class Label implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "rawName")
    private String rawName;

    @Column(name = "names")
    private String names;

    @Column(name = "status")
    private Integer status; //0 - normal; 1 - forbidden

}
