package com.ibm.practica.spital.controller;

import com.ibm.practica.spital.DTO.AddPacientDTO;
import com.ibm.practica.spital.DTO.AddReservation;
import com.ibm.practica.spital.DTO.PacientDTO;
import com.ibm.practica.spital.DTO.Reservation;
import com.ibm.practica.spital.service.SpitalService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/spital")
public class SpitalController {

    @Autowired
    private SpitalService service;

    @GetMapping("/getAllPacients")
    public List<PacientDTO> getAllPacients(){
        log.info("SpitalController.getAllPacients() has started...");
        List<PacientDTO> result = service.getAllPacients();

        log.info("SpitalController.getAllPacients() has finished.");
        return result;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){
        return service.getReservations();
    }

    @GetMapping("/reservation")
    public Reservation getReservation(String reservationID){
        return service.getReservation();
    }
    @GetMapping("/getPacientReservation")
    public ResponseEntity<List<Reservation>> getReservationForPacient(String pacientID){

        if(service.getReservationForPacient(pacientID).isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.of(Optional.ofNullable(service.getReservationForPacient(pacientID)));
    }

    @PostMapping("/addReservation")
    public ResponseEntity addReservation(@RequestBody  AddReservation reservation){

        return service.addReservation(reservation) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @PostMapping("/addPacient")
    public ResponseEntity addPacient(@RequestBody @Valid AddPacientDTO pacient){
        log.info("addPacient() started for : " + pacient);
        return service.addPacient(pacient) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/deleteReservation")
    public ResponseEntity deleteReservation(String reservationID){

        return service.deleteReservation(reservationID) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletePacient/{reservationID}")
    public ResponseEntity deletePacient(@RequestParam String pacientID){
        return service.deletePacient(pacientID) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/editPacient")
    public ResponseEntity editPacient(@RequestBody PacientDTO pacientDTO){
        return service.editPacient(pacientDTO) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
