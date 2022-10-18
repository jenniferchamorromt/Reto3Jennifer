package com.g15.jpa.service;

import com.g15.jpa.entity.Reservation;
import com.g15.jpa.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desaextremo
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    //Metodo para consultar todos los registros (Capa de servicios)
    public List<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    //Metodo para insertar (Capa de servicios)
    public Reservation insertReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //Metodo para consultar una registo x su id (Capa de servicios)
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    //Metodo para eliminar (Capa de servicios)
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

}
