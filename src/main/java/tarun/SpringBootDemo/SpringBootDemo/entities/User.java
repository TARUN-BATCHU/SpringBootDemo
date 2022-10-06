package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "User_Details")
@NoArgsConstructor
public @Data class User {

    @Id
    @GeneratedValue
    private Integer userId;

    private String userName;

    private LocalDate dateOfBirth;

    // one student will study in one organization (user is a student)
    @OneToOne
    private Organization organization;

    // state organization head will take of all organizations in that state
    //@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    //private List<Organization> organization;

    // many students vist organization expo
    //@ManyToMany(mappedBy = "user",cascade = CascadeType.ALL)
    //private List<Organization> organization;

    //one principle for one school
    //@OneToOne
    //private Organization organization;
}
