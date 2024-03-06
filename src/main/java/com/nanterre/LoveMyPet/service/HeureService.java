package com.nanterre.LoveMyPet.service;
import com.nanterre.LoveMyPet.model.Heure;
import com.nanterre.LoveMyPet.model.Traitement;

import java.util.Date;
import java.util.List;

public interface HeureService {
    void ajouterHeure(Integer idTraitement, Date heure);

    List<Heure> getHeuresByTraitementId(Integer idTraitement);

    void updateHeure(Integer idHeure, Date newHeure);
}
