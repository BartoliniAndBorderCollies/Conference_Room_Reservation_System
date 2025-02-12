package org.klodnicki.DTO.ConferenceRoomDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.model.Equipment;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoomDTORequest {

    private String name;
    private int personLimit;
    private List<Equipment> equipmentList;
}
