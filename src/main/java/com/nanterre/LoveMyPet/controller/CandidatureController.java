package com.nanterre.LoveMyPet.controller;
import jakarta.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nanterre.LoveMyPet.model.Candidature;
import com.nanterre.LoveMyPet.service.CandidatureServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/candidature")
public class CandidatureController {
	@Autowired
    private CandidatureServiceImpl candidatureService;
    
    @GetMapping("person/{idPerson}")
    public List<String> getCandidatureReferenceByPersonId(@PathVariable Integer idPerson) {
    	return candidatureService.getCandidatureLinksByPersonId(idPerson);
    }
    @GetMapping("/{idCandidature}")
    public Candidature getCandidatureDetailsById(@PathVariable Integer idCandidature) {
        return candidatureService.getCandidatureDetailsById(idCandidature);
    }
}





