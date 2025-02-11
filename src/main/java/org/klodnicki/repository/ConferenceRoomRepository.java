package org.klodnicki.repository;

import org.klodnicki.model.entity.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoom, Long> {
}
