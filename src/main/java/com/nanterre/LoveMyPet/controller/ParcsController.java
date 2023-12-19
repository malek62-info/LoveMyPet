package com.nanterre.LoveMyPet.controller;

        import com.fasterxml.jackson.databind.JsonNode;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.client.RestTemplate;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

@RestController
public class ParcsController {

    @GetMapping("/api/parcs")
    public List<Veterinary> getVeterinaires(
            @RequestParam String city,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(required = false, defaultValue = "3000") double radius
    ) {
        String overpassApiUrl = "https://overpass-api.de/api/interpreter?data=[out:json];(node[\"amenity\"=\"animal_training\"](around:" + radius + "," + latitude + "," + longitude + "););out;";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(overpassApiUrl, String.class);

        return parseOverpassResult(result);
    }

    private List<Veterinary> parseOverpassResult(String result) {
        List<Veterinary> veterinaries = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(result);

            for (JsonNode node : rootNode.path("elements")) {
                double lat = node.path("lat").asDouble();
                double lon = node.path("lon").asDouble();
                String name = node.path("tags").path("name").asText("Vétérinaire");

                veterinaries.add(new Veterinary(lat, lon, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return veterinaries;
    }

    private static class Veterinary {
        private final double lat;
        private final double lon;
        private final String name;

        public Veterinary(double lat, double lon, String name) {
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

