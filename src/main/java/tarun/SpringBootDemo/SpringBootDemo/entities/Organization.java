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

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<User> user;

}
