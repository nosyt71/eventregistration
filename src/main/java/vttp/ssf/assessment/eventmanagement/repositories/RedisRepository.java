package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	public List<Event> getAllEvents() {
		List<String> keys = (List<String>) redisTemplate.keys("event:*");
		System.out.println(keys);
		return keys != null ?
			keys
			.stream()
			.map(key -> (Event) redisTemplate.opsForValue().get(key)).collect(Collectors.toList()) : null;
	}

	public Event getEvent(Integer index) {
		String keyPattern = "event:*";
        List<String> keys = (List<String>) redisTemplate.keys(keyPattern);
		System.out.println(keys);
        if (keys != null && index >= 0 && index < keys.size()) {
            String selectedKey = keys.get(index);
            return (Event) redisTemplate.opsForValue().get(selectedKey);
        }

        return null;

	}
}