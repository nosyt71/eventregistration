package vttp.ssf.assessment.eventmanagement.services;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.JsonReader;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {
    
    // TODO: Task 1
    public List<Event> readFile(String fileName) {
        List<Event> events = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new FileReader(fileName))) {
            JsonArray jsonArray = reader.readArray();

            for (JsonValue jsonValue : jsonArray) {
                JsonObject jsonEvent = (JsonObject) jsonValue;
                Event event = new Event();
                event.setEventId(jsonEvent.getInt("eventId", 0));
                event.setEventName(jsonEvent.getString("eventName", ""));
                event.setEventSize(jsonEvent.getInt("eventSize", 0));
                // event.setEventDate( (Integer) jsonEvent.getLong("eventDate", 0));
                event.setParticipants(jsonEvent.getInt("participants", 0));

                events.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
}
}