package org.klodnicki.DTO.ReservationDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.model.EventType;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTORequest {

    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private EventType eventType;
    private boolean cyclic;
}
