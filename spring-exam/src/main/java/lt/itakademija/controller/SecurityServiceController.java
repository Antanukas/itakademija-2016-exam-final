package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Repository
@Api(value = "event")
@RequestMapping(value = "/spring-exam/webapi/events")
public class SecurityServiceController {

    private final SecurityEventsRepository repository;

    @Autowired
    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get events", notes = "Returs registered events")
    public List<RegisteredEvent> getRegisteredEvents() {
    	return repository.getEvents();
        //throw new UnsupportedOperationException("not implemented");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create event", notes = "Creates event.")
    public RegisteredEvent createEvent(EventRegistration registrationData) {
//    	RegisteredEvent event = new RegisteredEvent();
//		return repository.createEvent(event);
    	
    	
        throw new UnsupportedOperationException("not implemented");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public RegisteredEvent deleteEvent(Long id) {
    	return repository.delete(id);
        //throw new UnsupportedOperationException("not implemented");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredEvent updateEvent(Long id, RegisteredEventUpdate updateData) {
    	
        throw new UnsupportedOperationException("not implemented");
    }

}
