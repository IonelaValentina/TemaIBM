package com.ibm.practica.spital.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {

    private String id;
    private String firstName;
    private String lastName;
    private String qualification;
    private String specialization;
    private String schedule;
    private String phoneNumber;
}
