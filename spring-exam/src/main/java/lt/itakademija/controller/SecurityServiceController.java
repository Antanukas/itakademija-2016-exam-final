package lt.itakademija.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping(value = "webapi/events")
@Api(value = "Security Service Controller")
public class SecurityServiceController {

    @Autowired
    private final SecurityEventsRepository repository;

    public SecurityServiceController(@Valid @RequestBody final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get registered events", notes = "Returns registered events.")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    }

    /**
     * Papildoma užduotis, ieškoti paga ID
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ApiOperation(value = "Get event by ID", notes = "Returns event with path ID.")
    public RegisteredEvent getById(@PathVariable final Long id) {
        return repository.getBy(id);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    @ApiOperation(value = "Get events by Location, Time, Description", notes = "Returns filtered events.")
    public List<RegisteredEvent> getByLocationTimeDescription(
            @RequestParam("dateFrom") String dateFrom,
            @RequestParam("dateTill") String dateTill,
            @RequestParam("location") String location,
            @RequestParam("description") String description
    ) {
        return repository.getEventListBy(dateFrom,dateTill,location,description);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates Event", notes = "Returns created event users.")
    public RegisteredEvent createEvent(@Valid @RequestBody EventRegistration registrationData) {
        return repository.create(registrationData);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete event", notes = "Returns deleted event.")
    public RegisteredEvent deleteEvent(@PathVariable final Long id
    ) {
        return repository.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ApiOperation(value = "Update user", notes = "Returns updated event.")
    @ResponseStatus(HttpStatus.OK)
    public RegisteredEvent updateEvent(@PathVariable final Long id,@Valid @RequestBody RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    }
}
