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
    public String getName (@PathVariable int index){
        return students.get(index).getName();
    }

    @GetMapping("/age")
    public String getAge(@PathVariable int index){
        return students.get(index).getAge();
    }

    @GetMapping("/degree")
    public String getDegree(@PathVariable int index){
        return students.get(index).getDegree();
    }

    @GetMapping("/status")
    public boolean getStatus (@PathVariable int index){
        return students.get(index).isStatus();
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
    public ApiResponse delete(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Deleted");
    }
}
