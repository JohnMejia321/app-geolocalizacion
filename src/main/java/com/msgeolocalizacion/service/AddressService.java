package com.msgeolocalizacion.service;

import com.msgeolocalizacion.model.Office;
import com.msgeolocalizacion.repository.AddressRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private AddressRepository addressRepository;

    /*public String getCoordinates(String barrio, String ciudad, String estado, String pais) {
        String url = "https://nominatim.openstreetmap.org/search?q=" + barrio + ", " + ciudad + ", " + estado + ", " + pais + "&format=json&addressdetails=1&limit=1";
        return restTemplate.getForObject(url, String.class);
    }*/

    public String getCoordinates(String barrio, String ciudad, String estado, String pais) {
        String url = "https://nominatim.openstreetmap.org/search?q=" + barrio + ", " + ciudad + ", " + estado + ", " + pais + "&format=json&addressdetails=1&limit=1";
        String response = restTemplate.getForObject(url, String.class);

        // Convertir la respuesta JSON a un JSONArray
        JSONArray jsonArray = new JSONArray(response);

        // Obtener la latitud y longitud del primer objeto JSON en el array
        JSONObject firstObject = jsonArray.getJSONObject(0);
        String latitude = firstObject.getString("lat");
        String longitude = firstObject.getString("lon");

        // Formatear la respuesta solo con la latitud y longitud
        JSONObject coordinatesObject = new JSONObject();
        coordinatesObject.put("lat", latitude);
        coordinatesObject.put("lon", longitude);

        return coordinatesObject.toString();
    }

    public String findNearestOffice(String barrio, String ciudad, String estado, String pais) {
        // Obtener las coordenadas del usuario
        String userCoordinates = getCoordinates(barrio, ciudad, estado, pais);
        JSONObject userCoordinatesObj = new JSONObject(userCoordinates);
        // Obtener las coordenadas como doubles
        double userLat = userCoordinatesObj.getDouble("lat");
        double userLon = userCoordinatesObj.getDouble("lon");

        // Lista de oficinas con sus coordenadas
        /*ArrayList<Office> officesList = new ArrayList<>();
        officesList.add(new Office(9.330699, -82.250623, "Agencia de Bocas (Isla), Bocas del Toro, Panama", "Bocas del Toro", "Agencia de Bocas (Isla)"));
        officesList.add(new Office(9.440881, -82.516792, "Agencia de Bocas del Toro, Changuinola, Bocas del Toro, Panama", "Bocas del Toro", "Agencia de Changuinola"));
        officesList.add(new Office(8.781113, -82.431372, "Agencia Boquete, Chiriquí, Panama", "Chiriquí", "Agencia Boquete"));
        officesList.add(new Office(6.2006197, -75.5636832, "Agencia poblado, medellin, colombia", "poblado", "Agencia poblado"));*/

        ArrayList<Office> officesList = addressRepository.getAllOffices();

        // Inicializar variables para almacenar la oficina más cercana y la distancia más corta
        Office nearestOffice = null;
        double shortestDistance = Double.MAX_VALUE;

        // Iterar sobre cada oficina para calcular la distancia
        for (Office office : officesList) {
            double officeLat = office.getLat();
            double officeLon = office.getLon();

            // Calcular la distancia entre la oficina y la ubicación del usuario
            double distance = calculateDistance(userLat, userLon, officeLat, officeLon);

            // Actualizar la oficina más cercana y la distancia más corta si es necesario
            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearestOffice = office;
            }
        }

        // Crear el objeto JSON de la oficina más cercana
        JSONObject nearestOfficeObj = new JSONObject();
        nearestOfficeObj.put("lat", nearestOffice.getLat());
        nearestOfficeObj.put("lon", nearestOffice.getLon());
        nearestOfficeObj.put("display_name", nearestOffice.getDisplayName());
        nearestOfficeObj.put("provincia", nearestOffice.getProvincia());
        nearestOfficeObj.put("unidad_ejecutora", nearestOffice.getUnidadEjecutora());

        return nearestOfficeObj.toString();
    }
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra en kilómetros
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
