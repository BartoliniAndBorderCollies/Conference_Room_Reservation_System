package org.klodnicki.DTO.ConferenceRoomDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.DTO.ReservationDTO.ReservationDTOResponse;
import org.klodnicki.model.Equipment;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoomDTOResponse {

    private Long id;
    private int personLimit;
    private List<Equipment> equipmentList;
    private List<ReservationDTOResponse> reservations;
}
