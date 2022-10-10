package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "Course")
@NoArgsConstructor
public @Data class Course {

    @Id
    @GeneratedValue
    private Integer Course_Id;

    private String Course_Name;


    @ManyToMany(mappedBy = "course")
    @JsonIgnore
    private Set<User> users;
}
