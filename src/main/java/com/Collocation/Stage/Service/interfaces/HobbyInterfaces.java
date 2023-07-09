package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.Hobby;

import java.util.List;

public interface HobbyInterfaces{
    List<Hobby> getAllHobbies();

    Hobby getHobbyById(Integer id);

    Hobby saveHobby(Hobby hobby);

    Hobby updateHobby(Integer id, Hobby updatedHobby);

    void deleteHobby(Integer id);
}
