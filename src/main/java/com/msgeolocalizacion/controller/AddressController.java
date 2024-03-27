package com.msgeolocalizacion.controller;


import com.msgeolocalizacion.model.CoordinatesRequest;
import com.msgeolocalizacion.service.AddressService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/coordenadas")
    public ResponseEntity<String> getCoordinates(@RequestBody CoordinatesRequest request) {
        String geoJson = addressService.getCoordinates(request.getBarrio(), request.getCiudad(), request.getEstado(), request.getPais());
        return ResponseEntity.ok(geoJson);
    }

    @PostMapping("/oficina-cerca")
    public String findNearestOffice(@RequestBody CoordinatesRequest request) {
        String geoJson = addressService.findNearestOffice(request.getBarrio(), request.getCiudad(), request.getEstado(), request.getPais());
        return geoJson;
    }
}
