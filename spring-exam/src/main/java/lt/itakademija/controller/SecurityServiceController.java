package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "event")
@RequestMapping(value = "/webapi/events")
public class SecurityServiceController {

	
    private final SecurityEventsRepository repository;

    @Autowired
    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get events")
    public List<RegisteredEvent> getRegisteredEvents() {
    	return repository.getEvents();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create event", notes = "Creates event.")
    public RegisteredEvent createEvent(@Valid @RequestBody final EventRegistration registrationData) {
    	return repository.create(registrationData);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete event", notes = "Deletes event.")
    public RegisteredEvent deleteEvent(@ApiParam(value = "User ID", required = true) @PathVariable Long id) {
    	return repository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Update event", notes = "Updates event.")
    public RegisteredEvent updateEvent(@ApiParam(value = "User ID, required = true") @PathVariable Long id, @RequestBody RegisteredEventUpdate eventUpdate) {
        return repository.update(id, eventUpdate);
    }

}
