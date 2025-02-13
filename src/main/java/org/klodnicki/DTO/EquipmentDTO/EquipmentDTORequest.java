package org.klodnicki.DTO.EquipmentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.model.entity.ConferenceRoom;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTORequest {

    private String name;
    private int amount;
    private ConferenceRoom conferenceRoom;//TODO change to DTO
    private boolean available;
}
