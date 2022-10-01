package tarun.SpringBootDemo.SpringBootDemo.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tarun.SpringBootDemo.SpringBootDemo.users.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Organization_details")
public @Data class Organization {

    @Id
    @GeneratedValue
    private Integer OrganizationId;

    private String OrganizationName;

    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<User> user;

    public Organization() {
    }
}
