package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="")
public class EventController {

	//TODO: Task 5
	@GetMapping
	public String displayEvents(Model model) {
		return "view0";
	}


}
