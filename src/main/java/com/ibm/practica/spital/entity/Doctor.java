package com.ibm.practica.spital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @NotNull
    @Column(name="doctor_id")
    private String doctorID;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="qualification")
    private String qualification;

    @NotNull
    @Column(name="specialization")
    private String specialization;

    @NotNull
    @Column(name="schedule")
    private String schedule;

    @NotNull
    @Column(name="phone_number")
    private String phoneNumber;
}
