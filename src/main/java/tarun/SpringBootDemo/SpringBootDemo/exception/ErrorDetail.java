package tarun.SpringBootDemo.SpringBootDemo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class ErrorDetail {
    private String errorMessage;
    private String errorCode;
    private Date timeStamp;

    public ErrorDetail(String errorMessage, String errorCode, Date timeStamp) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.timeStamp = timeStamp;
    }
}
