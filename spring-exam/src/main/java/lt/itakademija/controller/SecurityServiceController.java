package lt.itakademija.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(value = "event")
@RequestMapping(value = "/webapi/events")
public class SecurityServiceController {

    @Autowired
    private final SecurityEventsRepository repository;

    @Autowired
    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get events", notes = "Returns registered events.")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    }

    @RequestMapping(path = "/{eventId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get event by ID", notes = "Returns registered event by ID.")
    public RegisteredEvent getRegisteredEventById(
            @ApiParam(value = "Event ID", required = true) @Valid @PathVariable Long eventId) {
        return repository.getEventById(eventId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create event", notes = "Creates event")
    public RegisteredEvent createEvent(@Valid @RequestBody final EventRegistration registrationData) {
        return repository.create(registrationData);
    }

    @RequestMapping(path = "/{eventId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete event", notes = "Deletes event.")
    public RegisteredEvent deleteEvent(
            @ApiParam(value = "Event ID", required = true) @PathVariable final Long eventId) {
        return repository.delete(eventId);
    }

    @RequestMapping(path = "/{eventId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update event", notes = "Updates event.")
    public RegisteredEvent updateEvent(@ApiParam(value = "Event ID", required = true) @PathVariable final Long eventId,
            @ApiParam(value = "Registered event severity update", required = true) @Valid @RequestBody final RegisteredEventUpdate updateData) {
        return repository.update(eventId, updateData);
    }

}
