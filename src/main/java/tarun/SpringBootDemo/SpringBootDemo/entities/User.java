package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private LocalDate dateOfBirth;

    // one student will study in one organization (user is a student)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="organizationId")
    private Organization organization;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinTable(name= "course_users",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "courseId", nullable = false,updatable = false)})
    private Set<Course> course = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "hallTicket_fk")
    private HallTicket hallTicket;


}
