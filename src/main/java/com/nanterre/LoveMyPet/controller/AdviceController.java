package com.nanterre.LoveMyPet.controller;


import com.nanterre.LoveMyPet.model.Advice;
import com.nanterre.LoveMyPet.model.Comment;
import com.nanterre.LoveMyPet.model.HistoriqueWeight;
import com.nanterre.LoveMyPet.model.Person;

import com.nanterre.LoveMyPet.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/advices")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    
    //liste de toutes les advices
    @GetMapping
    public List<String> getAllAdviceReferences() {
        return adviceService.getAllAdviceReferences();
    }
    //récupérer une advice a parir de id
    @GetMapping("advice/{adviceId}")
    public Map<String, Object> getAdviceDetails(@PathVariable Integer adviceId) {
        return adviceService.getAdviceDetails(adviceId);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addAdvice(@RequestPart("imageFile") MultipartFile imageFile, @RequestParam String textAdvice, @RequestParam Integer idPerson) {
        try {
            Advice advice = new Advice();
            advice.setTextAdvice(textAdvice);

            // Créer un objet Person avec l'ID fourni
            Person author = new Person();
            author.setIdPerson(idPerson);
            advice.setAuthor(author);

            if (imageFile != null && !imageFile.isEmpty()) {
                // Spécifiez le chemin de votre dossier d'images dans les ressources
                String imageFolderPath = "src/main/resources/static/images/advices";
                String fileName = imageFile.getOriginalFilename();
                Path filePath = Paths.get(imageFolderPath, fileName);

                // Écrivez le fichier image dans le dossier spécifié
                Files.write(filePath, imageFile.getBytes());

                // Set the image URL in the advice object
                advice.setImageUrl(fileName);
            }

            // Save the advice in the database
            adviceService.addAdvice(advice);

            return ResponseEntity.ok("Advice added successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error handling the image");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding advice");
        }

    }
    @PostMapping("/addComment/{adviceId}")
    public ResponseEntity<String> addCommentToAdvice(@PathVariable Integer adviceId, @RequestBody String commentText, @RequestParam Integer idPerson) {
        try {
            adviceService.addCommentToAdvice(adviceId, commentText, idPerson);
            return ResponseEntity.ok("Comment added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding comment");
        }
    }
    @GetMapping("/adviceComments/{adviceId}")
    public List<String> getCommentLinksByAdviceId(@PathVariable Integer adviceId) {
        return adviceService.getCommentLinksByAdviceId(adviceId);
    }
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<Comment> getCommentDetailsById(@PathVariable Integer commentId) {
        Comment comment = adviceService.getCommentDetailsById(commentId);

        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/Commentdata/{adviceId}")
    public ResponseEntity<List<Comment>> getCommentsByAdviceId(@PathVariable Integer adviceId) {
        List<Comment> comments = adviceService.getCommentsByAdviceId(adviceId);

        if (!comments.isEmpty()) {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    
}
