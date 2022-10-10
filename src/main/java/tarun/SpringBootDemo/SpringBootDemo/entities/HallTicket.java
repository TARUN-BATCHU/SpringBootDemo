package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Hallticket")
@NoArgsConstructor
public @Data class HallTicket {

    @Id
    @GeneratedValue
    private Integer HallTicketNumber;

    private Integer RoomNumber;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
