package org.example.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Equipment;

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
    @ElementCollection
    @CollectionTable(name = "conference_room_equipment", joinColumns = @JoinColumn(name = "conference_room_id"))
    @Column(name = "equipment")
    @Enumerated(EnumType.STRING)
    private List<Equipment> equipmentList;
    @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
}
