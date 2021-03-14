package xyz.metanarrative.spring_sandbox.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "bandid", nullable = false)
    @JsonIgnore
    Band band;

    @Override
    public boolean equals(Object o){
        if(o.getClass().equals(Member.class)){
        Member inputMember = (Member) o;
        return inputMember.getId() == this.id;
        }
        else return false;
    }

    @Override
    public int hashCode(){
        return id*37;
    }

    public String toString(){
        return "Member name"+name;
    }

}
