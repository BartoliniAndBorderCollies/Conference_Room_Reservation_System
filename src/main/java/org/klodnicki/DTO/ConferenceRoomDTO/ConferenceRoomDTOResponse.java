package org.klodnicki.DTO.ConferenceRoomDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.DTO.EquipmentDTO.EquipmentDTOResponse;
import org.klodnicki.DTO.ReservationDTO.ReservationDTOResponse;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoomDTOResponse {

    private Long id;
    private int personLimit;
    private List<EquipmentDTOResponse> equipmentList;
    private List<ReservationDTOResponse> reservations;
}
