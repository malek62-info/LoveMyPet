package com.nanterre.LoveMyPet.service;

import com.nanterre.LoveMyPet.model.Candidature;


import java.util.List;

public interface CandidatureService {
    List<String> getCandidatureLinksByPersonId(Integer idPerson);
    Candidature getCandidatureDetailsById (Integer idCandidature);
}

