package org.example.lab5q3.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor


public class EventSystem {
    private String id;
    private String description;
    private String capacity;
    @JsonFormat(pattern="yyyy-mm-dd")
    private LocalDate startData;
    @JsonFormat(pattern="yyyy-mm-dd")
    private LocalDate endData;

}
