package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.InMemorySecurityEventsRepository;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Component("SecurityServiceController")
@RestController
public class SecurityServiceController {

	 @Autowired private final SecurityEventsRepository repository;
    private List<RegisteredEvent> eventList;

    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
        this.eventList = new ArrayList<RegisteredEvent>();
    }
   
    
@RequestMapping("/spring-exam/webapi/events")
    public List<RegisteredEvent> getRegisteredEvents() {
    	return this.repository.getEvents();
        
    }
@RequestMapping("/spring-exam/webapi/events/create")
    public RegisteredEvent createEvent(@RequestParam(value="registrationData")EventRegistration registrationData) {
    	
    	return this.repository.create(registrationData);
    }
@RequestMapping("/spring-exam/webapi/events/delete")
    public RegisteredEvent deleteEvent(@RequestParam(value="id")Long id) {
        return this.repository.delete(id);
    }
@RequestMapping("/spring-exam/webapi/events/update")
    public RegisteredEvent updateEvent(@RequestParam(value="id")Long id, RegisteredEventUpdate updateData) {
        return this.repository.update(id, updateData);
    }

}
