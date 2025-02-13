package org.klodnicki.rest.controller;

import lombok.AllArgsConstructor;
import org.klodnicki.DTO.ConferenceRoomDTO.ConferenceRoomDTORequest;
import org.klodnicki.DTO.ConferenceRoomDTO.ConferenceRoomDTOResponse;
import org.klodnicki.exception.NotFoundInDatabaseException;
import org.klodnicki.service.ConferenceRoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conference-room")
@AllArgsConstructor
public class ConferenceRoomController extends ApiController{

    private final ConferenceRoomService conferenceRoomService;

    @PostMapping
    ConferenceRoomDTOResponse create(@RequestBody ConferenceRoomDTORequest conferenceRoomDTORequest) {
        return conferenceRoomService.create(conferenceRoomDTORequest);
    }

    @GetMapping("/{id}")
    ConferenceRoomDTOResponse findById(@PathVariable Long id) throws NotFoundInDatabaseException {
        return conferenceRoomService.findById(id);
    }
}
