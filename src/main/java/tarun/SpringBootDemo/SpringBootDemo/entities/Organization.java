package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Organization_details")
public @Data class Organization {

    @Id
    @GeneratedValue
    private Integer OrganizationId;

    private String OrganizationName;

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<User> user;

    public Organization() {
    }
}
