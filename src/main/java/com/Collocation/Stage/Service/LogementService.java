package com.Collocation.Stage.Service;

import com.Collocation.Stage.Repository.LogementRepository;
import com.Collocation.Stage.Service.interfaces.LogementInteface;
import com.Collocation.Stage.entities.Logement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogementService implements LogementInteface {

    private final LogementRepository logementRepository;

    @Autowired
    public LogementService(LogementRepository logementRepository) {
        this.logementRepository = logementRepository;
    }

    public List<Logement> getAllLogements() {
        return logementRepository.findAll();
    }

    public Logement getLogementById(Integer id) {
        return logementRepository.findById(id).orElse(null);
    }

    public Logement saveLogement(Logement logement) {
        return logementRepository.save(logement);
    }

    public Logement updateLogement(Integer id, Logement updatedLogement) {
        Logement logement = logementRepository.findById(id).orElse(null);
        if (logement != null) {
            // Update logement fields with the values from updatedLogement
            logement.setPays(updatedLogement.getPays());
            logement.setAdresse(updatedLogement.getAdresse());
            logement.setPrix(updatedLogement.getPrix());
            logement.setNb_Piece(updatedLogement.getNb_Piece());
            logement.setNb_Personne(updatedLogement.getNb_Personne());
            logement.setSurface(updatedLogement.getSurface());
            logement.setDescription(updatedLogement.getDescription());

            return logementRepository.save(logement);
        }
        return null;
    }

    public void deleteLogement(Integer id) {
        logementRepository.deleteById(id);
    }
}
