package vttp.ssf.assessment.eventmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner {
	
	@Autowired
	DatabaseService databaseSvc;	
    private String fileName = "events.json";

    @Autowired
    private RedisRepository redisRepo;

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	// TODO: Task 1
	@Override
	public void run(String... args) throws Exception {
		List<Event> events = databaseSvc.readFile(fileName);
		
		events.forEach(redisRepo::saveRecord);

		events.forEach(System.out::println);

		redisRepo.getNumberOfEvents();

		// redisRepo.getAllEvents();
    }
	}
