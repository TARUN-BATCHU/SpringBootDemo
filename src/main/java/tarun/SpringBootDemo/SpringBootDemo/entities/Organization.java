package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity(name = "Organization_details")
@NoArgsConstructor
public @Data class Organization {

    @Id
    @GeneratedValue
    private Integer organizationId;

    private String organizationName;

    // one organization has many students (user is a student)
    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<User> user;

    // one organization will have one state head
    //@OneToOne
    //private User user;

    // many students visit many organizations before joining
    //@ManyToMany
    //private List<User> user;

    //one principle for one school
    //@OneToOne
    //private User user;

}
