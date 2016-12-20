package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@ApiOperation(value = "Get events", notes = "Returns registered events.")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    	//throw new UnsupportedOperationException("not implemented");
    }

	@PostMapping
	@ApiOperation(value = "Create event", notes = "Creates registered event.")
    public RegisteredEvent createEvent(@ApiParam(value = "EventRegistration - registration data", required = true)
    									EventRegistration registrationData) {
        return repository.create(registrationData);
    	//throw new UnsupportedOperationException("not implemented");
    }

	@DeleteMapping
	@ApiOperation(value = "Delete event", notes = "Deletes registered event.")
    public RegisteredEvent deleteEvent(@ApiParam(value = "RegisteredEvent ID", required = true)
    									Long id) {
        return repository.delete(id);
    	//throw new UnsupportedOperationException("not implemented");
    }

    @PutMapping
    @ApiOperation(value = "Update event", notes = "Updates registered event.")
    public RegisteredEvent updateEvent(@ApiParam(value = "RegisteredEvent ID", required = true)
    									Long id,
    									@ApiParam(value = "RegisteredEventUpdate - update data", required = true)
    									RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    	//throw new UnsupportedOperationException("not implemented");
    }

}
