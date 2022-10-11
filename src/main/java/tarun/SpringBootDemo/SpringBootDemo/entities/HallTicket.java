package tarun.SpringBootDemo.SpringBootDemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "hallticket")
@NoArgsConstructor
public @Data class HallTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hallTicketNumber;

    private Integer roomNumber;


}
