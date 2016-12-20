package lt.itakademija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

@RestController
@Api(value = "Security controller")
@RequestMapping("spring-exam/webapi/events/")
public class SecurityServiceController {

	@Autowired
    private final SecurityEventsRepository repository;

    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    @RequestMapping(method = RequestMethod.GET)// 3rd task's addition
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all registered events", notes = "Returns a list of all rgistered events with their information.")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    	//throw new UnsupportedOperationException("not implemented");
    }
    
    @PostMapping
    @RequestMapping(method = RequestMethod.POST)// 3rd task's addition
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adds a new event", notes = "Adds a new event to the current event list.")
    public RegisteredEvent createEvent(@ApiParam(value = "Data of new event", required = true) EventRegistration registrationData) {
    	return repository.create(registrationData);
    	//throw new UnsupportedOperationException("not implemented");
    }
    
    @DeleteMapping
    @RequestMapping(method = RequestMethod.DELETE)// 3rd task's addition
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletes a specific event", notes = "Deletes an avent from database based on the supplied event id.")
    public RegisteredEvent deleteEvent(@ApiParam(value = "Event id", required = true) Long id) {
        return repository.delete(id);
        //throw new UnsupportedOperationException("not implemented");
    }
    
    @PutMapping
    @RequestMapping(method = RequestMethod.PUT)// 3rd task's addition
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Updates an event", notes = "Updates and event that already exists in the database.")
    public RegisteredEvent updateEvent(@ApiParam(value = "Event id", required = true) Long id, @ApiParam(value = "Data of event to bu updated", required = true) RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    	//throw new UnsupportedOperationException("not implemented");
    }

}
