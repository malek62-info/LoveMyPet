package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;
import java.util.List;

public interface MesCandidatureService {
    List<String> getCandidatureLinksByPersonId(Integer IdPerson);
    Candidature getCandidatureDetailsById (Integer idCandidature);
}

