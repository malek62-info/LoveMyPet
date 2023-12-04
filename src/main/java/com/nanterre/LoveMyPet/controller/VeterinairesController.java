package com.nanterre.LoveMyPet.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/api/veterinaires")
public class VeterinairesController {

    @GetMapping
    public String getVeterinaires(@RequestParam double latitude, @RequestParam double longitude) {
        // Construisez l'URL de l'API Overpass en utilisant les paramètres latitude et longitude
        String overpassApiUrl = "https://overpass-api.de/api/interpreter?data=[out:json];(node[\"amenity\"=\"veterinary\"](around:3000," + latitude + "," + longitude + "););out;";

        // Utilisez RestTemplate pour faire la requête vers l'API Overpass
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(overpassApiUrl, String.class);

        return result;
    }


    private static class Veterinary {
        double lat;
        double lon;
        String name;

        Veterinary(double lat, double lon, String name) {
            this.lat = lat;
            this.lon = lon;
            this.name = name;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }

        public String getName() {
            return name;
        }
    }
}
