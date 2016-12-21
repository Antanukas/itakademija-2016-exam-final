package lt.itakademija.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

@RestController
@Api(value = "user")
@RequestMapping("/spring-exam")
public class SecurityServiceController {
	
    private final SecurityEventsRepository repository;
    
    @Autowired
    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/webapi/events")
    @ApiOperation(value = "Get events", notes = "Returns  list of all events")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    }
    
    @PostMapping("/webapi/events")
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Post event", notes = "Adds new event to data base")
    public RegisteredEvent createEvent(@Valid EventRegistration registrationData) {
        return repository.create(registrationData);
    }
    
    @DeleteMapping(value = "/webapi/events/{id}", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete event", notes = "Deletes event by id")
    public RegisteredEvent deleteEvent(@PathVariable Long id) {
        return repository.delete(id);
    }
    
    @PutMapping(value = "/webapi/events/{id}", params = {"id"})
    @ApiOperation(value = "Put event", notes = "Updates event by id")
    public RegisteredEvent updateEvent(@PathVariable Long id, @Valid RegisteredEventUpdate updateData) {
        return updateEvent(id, updateData);
    }

}
