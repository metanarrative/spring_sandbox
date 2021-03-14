package xyz.metanarrative.spring_sandbox.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Album {

   @Id
   @GeneratedValue
   private int id;
   private String name;
   private int year;
   private String band;

}
