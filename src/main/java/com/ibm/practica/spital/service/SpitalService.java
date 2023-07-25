package com.ibm.practica.spital.service;

import com.ibm.practica.spital.DTO.AddPacientDTO;
import com.ibm.practica.spital.DTO.AddReservation;
import com.ibm.practica.spital.DTO.PacientDTO;
import com.ibm.practica.spital.DTO.Reservation;
import com.ibm.practica.spital.entity.Pacient;
import com.ibm.practica.spital.repository.PacientRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SpitalService {

 @Autowired
 PacientRepository pacientRepository;

 ModelMapper mapper = new ModelMapper();

 public List<PacientDTO> getAllPacients(){
  log.info("SpitalService.getAllPacients() retrieving all pacients...");

// alternativa clasica
//  List<Pacient> list = pacientRepository.findAll();
//  List<PacientDTO> result = new ArrayList<>();
//  for (Pacient pacient: list) {
//// alternativa la model mapper
////   PacientDTO dto = new PacientDTO(pacient.getFirstName(), pacient.getLastName(), pacient.getAge(),pacient.getIssue());
//   PacientDTO dto = mapper.map(pacient,PacientDTO.class);
//   result.add(dto);
//  }

  return pacientRepository.findAll().stream()
      .map(pacient -> mapper.map(pacient,PacientDTO.class))
      .collect(Collectors.toList());
 }

 public List<Reservation> getReservations(){
  log.info("SpitalService.getReservations() retrieving all reservations...");
  Reservation p = new Reservation();
  p.setId("12");
  p.setPacientID("12313");
  Reservation p1 = new Reservation();
  p1.setPacientID("12314");
  p1.setId("123");
  return List.of(p,p1);
 }

 public Reservation getReservation(){
  log.info("SpitalService.getReservation() retrieving all reservations...");
  Reservation p = new Reservation();
  p.setId("12");
  p.setPacientID("12313");
  return p;
 }

 public List<Reservation> getReservationForPacient(String pacientID){
  log.info("SpitalService.getReservations() retrieving all reservations...");
  Reservation p = new Reservation();
  p.setId("12");
  p.setPacientID("12313");
  Reservation p1 = new Reservation();
  p1.setPacientID("12314");
  p1.setId("123");
  List<Reservation> list = new ArrayList<>();
  list.add(p);
  list.add(p1);

  return list.stream().filter(r -> r.getPacientID().equals(pacientID)).collect(Collectors.toList());
 }

 public boolean addReservation(AddReservation reservation){
  return true;
 }

 public boolean deleteReservation(String reservationID){
  return false;
 }

 public boolean addPacient(AddPacientDTO pacientDTO){
  Pacient pacient = mapper.map(pacientDTO,Pacient.class);
  String id = UUID.randomUUID().toString();
  log.info("id is: " + id);
  pacient.setPacientID(id.replace("-",""));
  Pacient p = pacientRepository.save(pacient);
  log.info("saved pacient id is: " + p.getPacientID());
  return ObjectUtils.isNotEmpty(p);
 }

 public boolean deletePacient(String pacientID){
  return false;
 }

 public boolean editPacient(PacientDTO pacientDTO){
  return true;
 }
}
