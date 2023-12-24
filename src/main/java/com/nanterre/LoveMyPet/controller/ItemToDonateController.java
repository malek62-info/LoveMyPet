package com.nanterre.LoveMyPet.controller;

import com.nanterre.LoveMyPet.model.ItemToDonate; // Modification du nom de l'entité
import com.nanterre.LoveMyPet.model.Person;
import com.nanterre.LoveMyPet.service.ItemToDonateServiceImpl; // Modification du nom du service
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items-to-donate")
public class ItemToDonateController {

    @Autowired
    private ItemToDonateServiceImpl itemToDonateService;

    @PostMapping("/add")
    public ResponseEntity<String> addItemToDonate(
            @RequestParam(name = "itemName") String itemName,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "photo", required = false) MultipartFile photo,
            @RequestParam(name = "idPerson") Integer idPerson) {
    
        try {
            // Imprimez les valeurs pour vérification dans la console
            System.out.println("Item Name: " + itemName);
            System.out.println("Description: " + description);
            System.out.println("ID Person: " + idPerson);
    
            // Enregistrez le fichier image et récupérez son URL
            String imageUrl = saveImage(photo);
    
            // Imprimez l'URL de l'image pour vérification dans la console
            System.out.println("Image URL: " + imageUrl);
    
            // Créez un nouvel objet à donner
            ItemToDonate itemToDonate = new ItemToDonate();
            itemToDonate.setItemName(itemName);
            itemToDonate.setDescription(description);
            itemToDonate.setImageUrl(imageUrl); // Assurez-vous que imageUrl est correctement défini
            Person donatingPerson = new Person();
            donatingPerson.setIdPerson(idPerson);

            // Définissez la relation entre ItemToDonate et Person
            itemToDonate.setDonatingPerson(donatingPerson);
    
            // Imprimez l'objet pour vérification dans la console
            System.out.println("Item to Donate: " + itemToDonate);
    
            // Enregistrez l'objet à donner dans la base de données
            itemToDonateService.saveItemToDonate(itemToDonate);
    
            return new ResponseEntity<>("Objet à donner ajouté avec succès", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erreur lors de l'ajout de l'objet à donner", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    private String saveImage(MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            // Spécifiez le chemin de votre dossier d'images dans les ressources
            String imagesDirectory = "src/main/resources/static/images/items-to-donate";
            String fileName = imageFile.getOriginalFilename();
    
            // Vérifiez si fileName est nul avant de remplacer les espaces
            if (fileName != null) {
                fileName = fileName.replaceAll("\\s", "-");
            }
    
            Path filePath = Paths.get(imagesDirectory, fileName);
    
            // Écrivez le fichier image dans le dossier spécifié
            Files.write(filePath, imageFile.getBytes());
    
            // Retournez l'URL relative de l'image
            return fileName;
        }
        return null;
    }
    
    





    
    // Ajoutez d'autres méthodes de contrôleur selon les besoins
    @GetMapping("/")
    public List<String> getAllItemReferences() {
        List<ItemToDonate> items = itemToDonateService.getAllItems();
        return items.stream()
                .map(item -> "/item/" + item.getId())
                .collect(Collectors.toList());
    }
    @GetMapping("/item/{id}")
    public ItemToDonate getItemDetailsById(@PathVariable Integer id) {
        return itemToDonateService.getItemById(id);
    }

    //les objets d'une personne
    @GetMapping("person/{personId}")
    public ResponseEntity<List<String>> getItemReferencesByPersonId(@PathVariable Integer personId) {
        List<ItemToDonate> items = itemToDonateService.getItemsByPersonId(personId);

        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<String> itemReferences = items.stream()
                .map(item -> "/item/" + item.getId())
                .collect(Collectors.toList());

        return ResponseEntity.ok(itemReferences);
    }


}
