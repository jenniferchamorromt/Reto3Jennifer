package com.g15.jpa.controller;

import com.g15.jpa.entity.Reservation;
import com.g15.jpa.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    //Metodo para consultar todos los registros (Capa de controlador)
    @GetMapping("/all")
    public List<Reservation> getReservation() {
        return reservationService.getReservation();
    }

    @PostMapping("/save")
    //Metodo para insertar (Capa de controlador)
    public ResponseEntity insertReservation(@RequestBody Reservation reservation) {
        reservationService.insertReservation(reservation);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") Long id) {
        return reservationService.getReservationById(id);
    }
    
    //Metodo para eliminar (Capa de controlador)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable("id") Long id){
       reservationService.deleteReservation(id);
       return ResponseEntity.status(204).build();
    }
}
