package com.Collocation.Stage.Service.interfaces;

import com.Collocation.Stage.entities.Logement;

import java.util.List;

public interface LogementInteface {
    List<Logement> getAllLogements();

    Logement getLogementById(Integer id);

    Logement saveLogement(Logement logement);

    Logement updateLogement(Integer id, Logement updatedLogement);

    void deleteLogement(Integer id);}
