package com.Collocation.Stage.Controller;

import com.Collocation.Stage.Service.HobbyService;
import com.Collocation.Stage.entities.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hobbies")
public class HobbyController {

    private final HobbyService hobbyService;

    @Autowired
    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping
    public List<Hobby> getAllHobbies() {
        return hobbyService.getAllHobbies();
    }

    @GetMapping("/{id}")
    public Hobby getHobbyById(@PathVariable Integer id) {
        return hobbyService.getHobbyById(id);
    }

    @PostMapping
    public Hobby createHobby(@RequestBody Hobby hobby) {
        return hobbyService.saveHobby(hobby);
    }

    @PutMapping("/{id}")
    public Hobby updateHobby(@PathVariable Integer id, @RequestBody Hobby updatedHobby) {
        return hobbyService.updateHobby(id, updatedHobby);
    }

    @DeleteMapping("/{id}")
    public void deleteHobby(@PathVariable Integer id) {
        hobbyService.deleteHobby(id);
    }
}
