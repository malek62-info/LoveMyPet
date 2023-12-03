package com.nanterre.LoveMyPet.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/veterinaries")
public class VeterinaryController {

    @GetMapping
    public List<Veterinary> getVeterinaries(@RequestParam double latitude, @RequestParam double longitude) {
        // Simulation de données de vétérinaires
        return Arrays.asList(
                new Veterinary(latitude + 0.01, longitude + 0.01, "Vétérinaire 1"),
                new Veterinary(latitude - 0.01, longitude - 0.01, "Vétérinaire 2")
        );
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
