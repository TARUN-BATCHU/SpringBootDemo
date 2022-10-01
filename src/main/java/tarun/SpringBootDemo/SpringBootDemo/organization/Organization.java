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
//    @Column(name = "ORGANIZATION_ID")
    private Integer OrganizationId;

//    @Column(name = "ORGANIZATION_NAME")
    private String OrganizationName;

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<User> user;

    public Organization() {
    }
}
