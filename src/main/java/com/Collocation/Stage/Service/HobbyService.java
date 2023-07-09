package com.Collocation.Stage.Service;


import com.Collocation.Stage.Repository.HobbyRepository;
import com.Collocation.Stage.Service.interfaces.HobbyInterfaces;
import com.Collocation.Stage.entities.Hobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService implements HobbyInterfaces {

    private final HobbyRepository hobbyRepository;

    @Autowired
    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }

    public Hobby getHobbyById(Integer id) {
        return hobbyRepository.findById(id).orElse(null);
    }

    public Hobby saveHobby(Hobby hobby) {
        return hobbyRepository.save(hobby);
    }

    public Hobby updateHobby(Integer id, Hobby updatedHobby) {
        Hobby hobby = hobbyRepository.findById(id).orElse(null);
        if (hobby != null) {
            // Update hobby fields with the values from updatedHobby
            hobby.setNom_Hobby(updatedHobby.getNom_Hobby());
            hobby.setDescription((updatedHobby.getDescription()));
            hobby.setUsers(updatedHobby.getUsers());

            // Update other fields as needed
            // Save the updated hobby
            return hobbyRepository.save(hobby);
        }
        return null;
    }

    public void deleteHobby(Integer id) {
        hobbyRepository.deleteById(id);
    }
}

