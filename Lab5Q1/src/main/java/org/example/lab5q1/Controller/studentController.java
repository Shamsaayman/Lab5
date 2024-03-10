package org.example.lab5q1.Controller;
import org.example.lab5q1.Api.ApiResponse;
import org.example.lab5q1.Model.student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {
    ArrayList<student> students= new ArrayList<>();
    @GetMapping("/students")
    public ArrayList<student> getToDos(){
        return students;
    }

    @GetMapping("/name")
    public String getName (){
        return "Shamsa";
    }

    @GetMapping("/age")
    public String getAge(){
        return "22";
    }

    @GetMapping("/degree")
    public String getDegree(){
        return "Bachelors";
    }

    @GetMapping("/status")
    public boolean getStatus (){
        return true;
    }

    @PostMapping("/add")
    public ApiResponse addName(@RequestBody student name) {
        students.add(name);
        return new ApiResponse("Customer added");
    }

    @PutMapping("/update/{index}")
    public ApiResponse update(@PathVariable int index, @RequestBody student update) {
        students.set(index, update);
        return new ApiResponse("Updated");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index, @RequestBody student delete){
        students.remove(index);
        return new ApiResponse("Deleted");
    }
}
