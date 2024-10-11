package org.example.gtics_lab7_20211688.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roomseats")
public class RoomSeats {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="roomId")
    private Rooms roomId;

    @Column(name = "seatnumber")
    private String seatnumber;

    @Column(name = "rowNumber")
    private String rowNumber;

    @Column(name = "isAvailable")
    private Integer isAvailable;


}
