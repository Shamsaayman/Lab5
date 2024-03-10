package org.example.lab5q3.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@JsonFormat

public class EventSystem {
    private String id;
    private String description;
    private String capacity;
    private LocalDate startData;
    private LocalDate endData;

}
