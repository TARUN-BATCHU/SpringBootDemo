package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "User_Details")
@NoArgsConstructor
public @Data class User {

    @Id
    @GeneratedValue
    private Integer UserId;

    private String UserName;

    private LocalDate DateOfBirth;

    @JsonIgnore
    @OneToOne
    private Organization organization;

}
