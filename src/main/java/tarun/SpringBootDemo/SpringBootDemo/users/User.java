package tarun.SpringBootDemo.SpringBootDemo.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tarun.SpringBootDemo.SpringBootDemo.organization.Organization;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "User_Details")
public @Data class User {

    @Id
    @GeneratedValue
    private Integer UserId;

    private String UserName;

    private LocalDate DateOfBirth;

    @JsonIgnore
    @OneToOne
    private Organization organization;

    public User() {
    }
}
