package xyz.metanarrative.spring_sandbox.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Band {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "band")
    Set<Member> members;

    @ManyToMany(mappedBy = "bands")
    @JsonIgnore
    List<Festival> festivals;

    public String toString(){
        return "band name "+name;
    }
}
