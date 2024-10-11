package org.example.gtics_lab7_20211688.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservations {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private Users userId;

    @ManyToOne
    @JoinColumn(name="funcionId")
    private Funciones funcionId;

    @ManyToOne
    @JoinColumn(name="roomSeatId")
    private RoomSeats roomSeatId;

    @Column(name = "startDateTime")
    private LocalDateTime startDateTime;


    @Column(name = "endDatetime")
    private LocalDateTime endDatetime;

}
