package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Course")
@NoArgsConstructor
public @Data class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CourseId;

    private String CourseName;

    @ManyToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
