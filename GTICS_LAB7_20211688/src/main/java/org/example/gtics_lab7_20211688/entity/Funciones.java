package org.example.gtics_lab7_20211688.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "funciones")
public class Funciones {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="obraId")
    private Obras obraId;

    @ManyToOne
    @JoinColumn(name="roomId")
    private Rooms roomId;

    @Column(name = "funcionDate")
    private LocalDateTime  funcionDate;

    @Column(name = "availableSeats")
    private Integer availableSeats;





}
