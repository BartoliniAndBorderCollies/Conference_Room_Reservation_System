package org.klodnicki.service;

import lombok.AllArgsConstructor;
import org.klodnicki.DTO.ConferenceRoomDTO.ConferenceRoomDTORequest;
import org.klodnicki.DTO.ConferenceRoomDTO.ConferenceRoomDTOResponse;
import org.klodnicki.exception.NotFoundInDatabaseException;
import org.klodnicki.model.entity.ConferenceRoom;
import org.klodnicki.repository.ConferenceRoomRepository;
import org.klodnicki.service.generic.GenericBasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConferenceRoomService implements GenericBasicCrudOperations<ConferenceRoomDTOResponse, ConferenceRoomDTORequest, Long> {
    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ModelMapper modelMapper;

    @Override
    public ConferenceRoomDTOResponse create(ConferenceRoomDTORequest object) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) throws NotFoundInDatabaseException {

    }

    @Override
    public ConferenceRoomDTOResponse findById(Long id) throws NotFoundInDatabaseException {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(id).orElseThrow(() ->
                new NotFoundInDatabaseException(ConferenceRoom.class));

        return modelMapper.map(conferenceRoom, ConferenceRoomDTOResponse.class);
    }
}
