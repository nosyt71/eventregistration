package vttp.ssf.assessment.eventmanagement.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping(path={"/events"})
public class EventController {

	@Autowired
	private RedisRepository redisRepo;

	//TODO: Task 5
	@GetMapping(path="/listing")
	public String displayEvents(Model model) {
		// List<Event> events = redisRepo.getAllEvents();

		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// events.forEach(event -> event.setEventDateFormatted(dateFormat.format(event.getEventDate())));

		// model.addAttribute("events", events);
		return "view0";
	}


}
