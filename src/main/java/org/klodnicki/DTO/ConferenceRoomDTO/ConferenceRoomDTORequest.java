package org.klodnicki.DTO.ConferenceRoomDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.DTO.EquipmentDTO.EquipmentDTORequest;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoomDTORequest {

    private String name;
    private int personLimit;
    private List<EquipmentDTORequest> equipmentList;
}
