package lt.itakademija.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

@RestController
@RequestMapping(path="/webapi/events")
@Api(value = "event")
public class SecurityServiceController {

    private final SecurityEventsRepository repository;

    @Autowired
    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get registered event by ID")
    public RegisteredEvent getRegisteredEvent(
            @ApiParam(value = "ID of event to retrieve", required = true) 
            @PathVariable Long id) {
        return repository.getEvent(id);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get list of registered events", notes="Optionally you can pass params to filter events")
    public List<RegisteredEvent> getRegisteredEvents(
            @ApiParam(value = "Start date of date interval filter, pattern='yyyy-MM-dd'T'HH:mm:ss", required = false, example="2015-01-01T10:00:00")
            @RequestParam(required=false, name="dateFrom") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date dateFrom,
            @ApiParam(value = "End date of date interval filter, pattern='yyyy-MM-dd'T'HH:mm:ss", required = false, example="2016-01-01T10:00:00")
            @RequestParam(required=false, name="dateTill") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date dateTill,
            @ApiParam(value = "Fragment of event description, case insensitive", required = false)
            @RequestParam(required=false, name="description") String descriptionFragment,
            @ApiParam(value = "Fragment of event location, case insensitive", required = false)
            @RequestParam(required=false, name="location") String locationFragment) {
//            return repository.getEvents();
            return repository.getFilteredEvents(dateFrom, dateTill, descriptionFragment, locationFragment);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register new event")
    public RegisteredEvent createEvent(
            @ApiParam(value = "Event data", required = true)
            @Valid @RequestBody EventRegistration registrationData) {
        return repository.create(registrationData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete event by event ID")
    public RegisteredEvent deleteEvent(
            @ApiParam(value = "ID of event to delete", required = true)
            @PathVariable Long id) {
        return repository.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update existing event by ID", notes = "Given non-existing ID, will not create new event")
    public RegisteredEvent updateEvent(
            @ApiParam(value = "ID of event to update", required = true) 
            @PathVariable Long id, 
            @ApiParam(value = "Event update data", required = true) 
            @Valid @RequestBody RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    }

    
    
    
}
