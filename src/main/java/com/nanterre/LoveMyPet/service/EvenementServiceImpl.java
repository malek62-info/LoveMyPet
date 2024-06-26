package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Evenement;
import com.nanterre.LoveMyPet.model.Inscription;
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.repository.EvenementRepository;
import com.nanterre.LoveMyPet.repository.InscriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Override
    public List<Evenement> getAllEvenements() {
        return (List<Evenement>) evenementRepository.findAll();
    }

    @Override
    public Evenement getEvenementById(Integer id) {
        return evenementRepository.findById(id).orElse(null);
    }

    @Override
    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }



    @Override
    public List<Evenement> findNonExpiredEvents(LocalDate date) {
        return evenementRepository.findByDateAfter(date);
    }
    // Autres méthodes selon les besoins




    @Override
    public List<Evenement> getUserEvents(Integer idPerson) {
        // Implémentez votre logique pour récupérer les événements de l'utilisateur
        // en utilisant l'id de la personne connectée
        Person createur = new Person();
        createur.setIdPerson(idPerson);
        return evenementRepository.findByCreateur(createur);
    }

    @Override
    public void deleteEvenementAndInscriptions(Integer idEvenement) {
        Evenement evenement = evenementRepository.findById(idEvenement).orElse(null);
        if (evenement != null) {
            // Supprimer les inscriptions associées à l'événement
            inscriptionRepository.deleteByEvenement(evenement);

            // Supprimer l'événement lui-même
            evenementRepository.delete(evenement);
        }
    }
    @Override
    public void deleteEvenement(Integer evenementId) {
        // Vérifiez si l'événement existe
        Evenement evenement = evenementRepository.findById(evenementId).orElse(null);

        if (evenement != null) {
            // Supprimez l'événement
            evenementRepository.delete(evenement);
        }
    }

}