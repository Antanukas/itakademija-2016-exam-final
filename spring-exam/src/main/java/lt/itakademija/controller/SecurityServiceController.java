package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/webapi/events")
public class SecurityServiceController {

    @Autowired
    private final SecurityEventsRepository repository;

    @Autowired
    public SecurityServiceController(@RequestBody final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<RegisteredEvent> getRegisteredEvents(@RequestParam(value = "location", required = false) String location,
                                                     @RequestParam(value = "description", required = false) String description,
                                                     @RequestParam(value = "dateFrom", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date dateFrom,
                                                     @RequestParam(value = "dateTill", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date dateTill) {
        return repository.getEvents(location, description, dateFrom, dateTill);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredEvent createEvent(@RequestBody  @Valid EventRegistration registrationData) {
        return repository.create(registrationData);
    }

    @DeleteMapping("/{eventId}")
    public RegisteredEvent deleteEvent(@PathVariable Long eventId) {
        return repository.delete(eventId);
    }

    @PutMapping("/{eventId}")
    public RegisteredEvent updateEvent(@PathVariable Long eventId, @RequestBody  @Valid RegisteredEventUpdate updateData) {
        return repository.update(eventId, updateData);
    }

    @GetMapping("/{eventId}")
    public RegisteredEvent getById(@PathVariable Long eventId){
        return repository.findById(eventId);
    }


}
