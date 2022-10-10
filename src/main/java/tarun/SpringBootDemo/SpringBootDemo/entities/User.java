package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Users")
@NoArgsConstructor
public @Data class User {

    @Id
    @GeneratedValue
    private Integer userId;

    private String userName;

    private LocalDate dateOfBirth;

    // one student will study in one organization (user is a student)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="organizationId")
    private Organization organization;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name= "Course_Users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> course;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "user")
    private HallTicket hallTicket;


}
