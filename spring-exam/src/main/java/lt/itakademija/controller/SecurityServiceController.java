package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "event")
@RequestMapping(path = "webapi/events")
public class SecurityServiceController {

	@Autowired
    private final SecurityEventsRepository repository;

	public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Get events", notes = "Returns registered events.")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    	//throw new UnsupportedOperationException("not implemented");
    }
	
	@GetMapping(path = "{eventId}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Get event", notes = "Returns registered events. Custom method by Andrius Sareika")
    public RegisteredEvent getRegisteredEvent(@ApiParam(value = "RegisteredEvent ID", required = true)
												@PathVariable String id) {
		
        return repository.getEvent(new Long(id));
    	//throw new UnsupportedOperationException("not implemented");
    }

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Create event", notes = "Creates registered event.")
    public RegisteredEvent createEvent(@ApiParam(value = "EventRegistration - registration data", required = true)
    									@RequestBody EventRegistration registrationData) {
        return repository.create(registrationData);
    	//throw new UnsupportedOperationException("not implemented");
    }

	@DeleteMapping(path = "{eventId}")
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Delete event", notes = "Deletes registered event.")
    public RegisteredEvent deleteEvent(@ApiParam(value = "RegisteredEvent ID", required = true)
    									@PathVariable int id) {
        return repository.delete(new Long(id));
    	//throw new UnsupportedOperationException("not implemented");
    }

    @PutMapping(path = "{eventId}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Update event", notes = "Updates registered event.")
    public RegisteredEvent updateEvent(@ApiParam(value = "RegisteredEvent ID", required = true)
    									@PathVariable int id,
    									@ApiParam(value = "RegisteredEventUpdate - update data", required = true)
    									@RequestBody RegisteredEventUpdate updateData) {
        return repository.update(new Long(id), updateData);
    	//throw new UnsupportedOperationException("not implemented");
    }

}
