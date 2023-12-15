package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	// TODO: Task 2
	@Autowired
	@Qualifier("redis")
    RedisTemplate<String, Object> redisTemplate;

    public void saveRecord(Event event) {
        String key = "event:" + event.getEventId().toString();
        redisTemplate.opsForValue().set(key, event);
		System.out.println(key);
		System.out.println(redisTemplate);
    }

	// TODO: Task 3

	public long getNumberOfEvents() {
        Set<String> keys = redisTemplate.keys("event:*");
		Integer numberOfEvents = keys.size(); 
		System.out.println(numberOfEvents);
        return numberOfEvents;
    }


	// TODO: Task 4

	// public Event getEvent(Integer index) {
		
	// }
}
