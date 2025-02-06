package org.klodnicki.DTO.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.klodnicki.model.entity.Reservation;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTOResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Reservation> reservations;
}
