package vttp.ssf.assessment.eventmanagement.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	// TODO: Task 2
	@Autowired
	@Qualifier("redis")
	RedisTemplate<String, String> template;

	public void save(Event event) {

		ValueOperations<String, String> vOps = template.opsForValue();

		JsonObject eventList = Json.createObjectBuilder()
			.add("eventId", event.getEventId())
			.add("name", event.getEventName())
			.add("eventSize", event.getEventSize())
			.add("eventDate", event.getEventDate())
			.add("participants", event.getParticipants())
			.build();
		
		vOps.set("eventList",eventList.toString());
	}


	// TODO: Task 3

	public void getNumberOfEvents() {
	}


	// TODO: Task 4

	public void getEvent(Integer index) {

	}
}
