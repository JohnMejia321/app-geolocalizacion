package com.msgeolocalizacion.repository;

import com.msgeolocalizacion.model.Office;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AddressRepository {

    private ArrayList<Office> officesList;

    public AddressRepository() {
        officesList = new ArrayList<>();
       /* officesList.add(new Office(9.330699, -82.250623, "Agencia de Bocas (Isla), Bocas del Toro, Panama", "Bocas del Toro", "Agencia de Bocas (Isla)"));
        officesList.add(new Office(9.440881, -82.516792, "Agencia de Bocas del Toro, Changuinola, Bocas del Toro, Panama", "Bocas del Toro", "Agencia de Changuinola"));
        officesList.add(new Office(8.781113, -82.431372, "Agencia Boquete, Chiriquí, Panama", "Chiriquí", "Agencia Boquete"));*/
        officesList.add(new Office(6.2006197, -75.5636832, "Agencia poblado, medellin, colombia", "poblado", "Agencia poblado"));
        officesList.add(new Office(9.330699, -82.250623, "Agencia de Bocas (Isla), Bocas del Toro, Panama", "Bocas del Toro", "Agencia de Bocas (Isla)"));
        officesList.add(new Office(9.440881, -82.516792, "Agencia de Bocas del Toro, Changuinola, Bocas del Toro, Panama", "Bocas del Toro", "Agencia de Changuinola"));
        officesList.add(new Office(8.781113, -82.431372, "Agencia Boquete, Chiriquí, Panama", "Chiriquí", "Agencia Boquete"));
        officesList.add(new Office(8.598976, -82.618582, "Agencia Bugaba, Chiriquí, Panama", "Chiriquí", "Agencia Bugaba"));
        officesList.add(new Office(8.428186, -82.430847, "Agencia David, Chiriquí, Panama", "Chiriquí", "Agencia David"));
        officesList.add(new Office(8.280618, -82.870196, "Agencia Puerto Armuelles, Chiriquí, Panama", "Chiriquí", "Agencia Puerto Armuelles"));
        officesList.add(new Office(8.784177, -82.636779, "Agencia Volcán, Chiriquí, Panama", "Chiriquí", "Agencia Volcán"));
        officesList.add(new Office(8.096756, -80.965862, "Agencia Santiago, Veraguas, Panama", "Veraguas", "Agencia Santiago"));
        officesList.add(new Office(8.020449, -81.183614, "Agencia Soná, Veraguas, Panama", "Veraguas", "Agencia Soná"));
        officesList.add(new Office(7.962812, -80.433695, "Agencia de Chitré, Herrera, Panama", "Herrera", "Agencia de Chitré"));
        officesList.add(new Office(7.767208, -80.301191, "Agencia de Las Tablas, Los Santos, Panama", "Los Santos", "Agencia de Las Tablas"));
        officesList.add(new Office(7.934536, -80.426427, "Agencia de Los Santos, Los Santos, Panama", "Los Santos", "Agencia de Los Santos"));
        officesList.add(new Office(9.360671, -79.900744, "Agencia de Colón, Colón, Panama", "Colón", "Agencia de Colón"));
        officesList.add(new Office(8.250109, -80.554894, "Agencia de Aguadulce, Coclé, Panama", "Coclé", "Agencia de Aguadulce"));
        officesList.add(new Office(8.336562, -80.515964, "Agencia de Natá, Coclé, Panama", "Coclé", "Agencia de Natá"));
        officesList.add(new Office(8.521371, -80.362053, "Agencia de Penonomé, Coclé, Panama", "Coclé", "Agencia de Penonomé"));
        officesList.add(new Office(8.982237, -79.525365, "Edificio Bolívar, Panamá, Panama", "Panamá Metro", "Oficina Administrativa"));
        officesList.add(new Office(8.975254, -79.520201, "Agencia de Parque Lefevre, Panamá Metro, Panama", "Panamá Metro", "Agencia de Parque Lefevre"));
        officesList.add(new Office(8.982874, -79.521871, "Agencia de San Francisco, Panamá Metro, Panama", "Panamá Metro", "Agencia de San Francisco"));
        officesList.add(new Office(9.005246, -79.457839, "Agencia de Juan Díaz, Panamá Metro, Panama", "Panamá Metro", "Agencia de Juan Díaz"));
        officesList.add(new Office(9.020509, -79.495319, "Agencia de El Dorado, Panamá Metro, Panama", "Panamá Metro", "Agencia de El Dorado"));
        officesList.add(new Office(9.050779, -79.483528, "Agencia de San Miguelito, Panamá Metro, Panama", "Panamá Metro", "Agencia de San Miguelito"));
        officesList.add(new Office(9.004044, -79.503949, "Agencia de Vía España, Panamá Metro, Panama", "Panamá Metro", "Agencia de Vía España"));
        officesList.add(new Office(8.873711, -79.782745, "Agencia de La Chorrera, Panamá Oeste, Panama", "Panamá Oeste", "Agencia de La Chorrera"));
        officesList.add(new Office(8.933667, -79.651446, "Agencia de Arraiján, Panamá Oeste, Panama", "Panamá Oeste", "Agencia de Arraiján"));
        officesList.add(new Office(8.516041, -79.964926, "Agencia de San Carlos, Panamá Oeste, Panama", "Panamá Oeste", "Agencia de San Carlos"));
        officesList.add(new Office(8.917211, -79.613773, "Agencia de Panamá Pacífico, Panamá Oeste, Panama", "Panamá Oeste", "Agencia de Panamá Pacífico"));
        officesList.add(new Office(9.168329, -79.097291, "Agencia de Chepo, Panamá Este, Panama", "Panamá Este", "Agencia de Chepo"));
        officesList.add(new Office(9.096772, -79.165221, "Agencia de 24 de Diciembre, Panamá Este, Panama", "Panamá Este", "Agencia de 24 de Diciembre"));
        officesList.add(new Office(7.978172, -77.845257, "Sub Agencia de Darién, Darién, Panama", "Darién", "Sub Agencia de Darién"));


    }

    public ArrayList<Office> getAllOffices() {
        return officesList;
    }

}
