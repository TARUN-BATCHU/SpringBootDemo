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
    private Integer userId;

    private String userName;

    private LocalDate dateOfBirth;

    @JsonIgnore
    @OneToOne
    private Organization organization;

}
