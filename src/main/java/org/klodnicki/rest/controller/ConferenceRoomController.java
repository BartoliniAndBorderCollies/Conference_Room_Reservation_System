package org.klodnicki.rest.controller;

import lombok.AllArgsConstructor;
import org.klodnicki.DTO.ConferenceRoomDTO.ConferenceRoomDTOResponse;
import org.klodnicki.exception.NotFoundInDatabaseException;
import org.klodnicki.service.ConferenceRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conference-room")
@AllArgsConstructor
public class ConferenceRoomController extends ApiController{

    private final ConferenceRoomService conferenceRoomService;

    @GetMapping("/{id}")
    ConferenceRoomDTOResponse findById(@PathVariable Long id) throws NotFoundInDatabaseException {
        return conferenceRoomService.findById(id);
    }
}
