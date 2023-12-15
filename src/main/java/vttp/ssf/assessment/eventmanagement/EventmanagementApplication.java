package vttp.ssf.assessment.eventmanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner {
	
	@Autowired
	DatabaseService databaseSvc;	

    private String fileName = "events.json";

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	// TODO: Task 1
	@Override
	public void run(String... args) throws Exception {
		List<Event> events = readFile(fileName);
		// Display events on the console
		events.forEach(System.out::println);
    }
	}

	//