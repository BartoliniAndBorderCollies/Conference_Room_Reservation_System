package org.klodnicki.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int personLimit;
    @OneToMany(mappedBy = "conferenceRoom")
    private List<Equipment> equipmentList;
    @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval = true) //orhpan removal -> jak usunę rezerwację z listy to zostanie ona usunieta również z bazy danych
    private List<Reservation> reservations;
}