package org.example.lab5q2.Controller;
import org.example.lab5q2.Api.ApiResponse;
import org.example.lab5q2.Model.ProjectTracker;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectTrackerController {
    ArrayList<ProjectTracker> projects = new ArrayList<>();
@GetMapping("/display")
public ArrayList<ProjectTracker> displayProject(){
    return projects;
}
@PostMapping("/create")
public ApiResponse createProject(@RequestBody ProjectTracker project){
    projects.add(project);
    return new ApiResponse("Project Added");
}
@PutMapping("/update/{index}")
public ApiResponse updateProject(@PathVariable  int index , @RequestBody ProjectTracker project){
    projects.set(index,project);
    return new ApiResponse("Project Updated");
}
@DeleteMapping("/delete/{index}")
public ApiResponse deleteProject(@PathVariable int index ){
    projects.remove(index);
    return new ApiResponse("Project Deleted");
}
@PutMapping("/status/{index}")
public ApiResponse changeStatus(@PathVariable int index){
  if(projects.get(index).getStatus().equals("not done")){
     projects.get(index).setStatus("done");
     return new ApiResponse("Status changed");
        }
  else{
     return new ApiResponse("Status is done");
        }
    }

@GetMapping("/search/title/{title}")
public ArrayList<ProjectTracker> searchProjectTitle(@PathVariable String title){
        ArrayList<ProjectTracker>search= new ArrayList<>();
        for(ProjectTracker project: projects){
            if(project.getTitle().contains(title)){
                search.add(project);
            }
        }
        return search;
    }

@GetMapping("/search/company/{companyName}")
public ArrayList<ProjectTracker> searchProjectCompany(@PathVariable String companyName){
        ArrayList<ProjectTracker>search= new ArrayList<>();
        for(ProjectTracker project: projects){
            if(project.getCompanyName().contains(companyName)){
                search.add(project);
            }
        }
        return search;
    }
}
