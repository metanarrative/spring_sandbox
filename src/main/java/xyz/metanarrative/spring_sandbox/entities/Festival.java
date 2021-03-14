package xyz.metanarrative.spring_sandbox.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Festival implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "festivalbands",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id")
    )
    List<Band> bands;


    public String toString(){
        return "festname "+name;
    }

}
