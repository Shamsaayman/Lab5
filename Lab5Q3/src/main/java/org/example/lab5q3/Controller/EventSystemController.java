package org.example.lab5q3.Controller;
import org.example.lab5q3.Api.ApiResponse;
import org.example.lab5q3.Model.EventSystem;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventSystemController {
    ArrayList<EventSystem>events= new ArrayList<>();

    @GetMapping("/display")
    public ArrayList<EventSystem> getEvents(){
        return events;
    }
    @PostMapping("/create")
    public ApiResponse createEvent(@RequestBody EventSystem event){
        events.add(event);
        return new ApiResponse("Event Created");
    }
    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody EventSystem event){
        events.set(index, event);
        return new ApiResponse("Event Updated");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponse("Event Deleted");
    }
    @PutMapping("/capacity/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index , @PathVariable String capacity){
        events.get(index).setCapacity("10");
        return new ApiResponse("Capacity changed");
    }
    @GetMapping("/search/{id}")
    public ArrayList<EventSystem> searchEvent(@PathVariable String id){
        ArrayList<EventSystem>search= new ArrayList<>();
        for(EventSystem event: events){
            if(event.getId().contains(id)){
                search.add(event);
            }
        }
        return search;
    }


}
