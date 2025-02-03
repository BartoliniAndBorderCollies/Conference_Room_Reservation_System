package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private ConferenceRoom conferenceRoom;
    private EventType eventType;
    private boolean isCyclic;

}
