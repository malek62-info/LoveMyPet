package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.repository.TraitementRepository;
import com.nanterre.LoveMyPet.repository.VaccinationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;

@Service
public class EvenementAnimalServiceImpl implements EvenementAnimalService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private TraitementRepository traitementRepository;

    @Override
    public List<AnimalEvent> getTraitementsAnimauxPersonne(Integer idPersonne) {
        List<Object[]> traitementDetails = traitementRepository.findTraitementsDetailByIdPerson(idPersonne);
        List<AnimalEvent> traitementEvents = new ArrayList<>();

        for (Object[] traitementDetail : traitementDetails) {
            LocalDate dateDebut = ((Date) traitementDetail[0]).toLocalDate();
            LocalDate dateFin = ((Date) traitementDetail[1]).toLocalDate();
            LocalTime heure = ((Time) traitementDetail[7]).toLocalTime();
            String medicamentName = (String) traitementDetail[5];
            String animalName = (String) traitementDetail[6];

            // Vérifier si la date de début est inférieure à la date de fin
            if (dateDebut.isBefore(dateFin)) {
                LocalDate currentDate = dateDebut;
                int dayCount = 1;
                while (!currentDate.isAfter(dateFin)) {
                    AnimalEvent event = new AnimalEvent(currentDate, heure,"LoveMyPet " +
                            "Jour " + dayCount + " sur " + (ChronoUnit.DAYS.between(dateDebut, dateFin) + 1) + " - "
                                    + animalName + " - " + medicamentName);
                    traitementEvents.add(event);
                    currentDate = currentDate.plusDays(1);
                    dayCount++;
                }
            } else if (dateDebut.equals(dateFin)) {
                AnimalEvent event = new AnimalEvent(dateDebut, heure,
                        "Jour 1 sur 1 - " + animalName + " - " + medicamentName);
                traitementEvents.add(event);
            }
        }

        return traitementEvents;
    }

    @Override
    public List<AnimalEvent> getVaccinationsAnimauxPersonne(Integer idPersonne) {
        List<Object[]> vaccinationDetails = vaccinationRepository.findVaccinationDetailsByPersonId(idPersonne);
        List<AnimalEvent> vaccinationEvents = new ArrayList<>();

        for (Object[] vaccinationDetail : vaccinationDetails) {
            LocalDate date = ((Date) vaccinationDetail[0]).toLocalDate();
            LocalTime heure = ((Time) vaccinationDetail[1]).toLocalTime();
            String animalName = (String) vaccinationDetail[7];
            String vaccinName = (String) vaccinationDetail[6];

            // String medicamentName = (String) vaccinationDetail[5];
            // String animalName = (String) vaccinationDetail[7];

            AnimalEvent event = new AnimalEvent(date, heure,"LoveMyPet " + animalName + " - " + vaccinName);
            vaccinationEvents.add(event);
        }

        return vaccinationEvents;
    }

}
