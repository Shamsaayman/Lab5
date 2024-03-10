package org.example.lab5q2.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTracker {
    private String id;
    private String title;
    private String description;
    private String status;
    private String companyName;

}
