package lt.itakademija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

@RestController
public class SecurityServiceController {

    private final SecurityEventsRepository repository;

    @Autowired
    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("webapi/events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RegisteredEvent getRegisteredEvent(@PathVariable Long id) {
        return repository.getEvent(id);
    }
    
    @GetMapping("webapi/events")
    @ResponseStatus(HttpStatus.OK)
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    }

    @PostMapping("webapi/events")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredEvent createEvent(@RequestBody EventRegistration registrationData) {
        return repository.create(registrationData);
    }

    @DeleteMapping("webapi/events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RegisteredEvent deleteEvent(@PathVariable Long id) {
        return repository.delete(id);
    }

    @PutMapping("webapi/events/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RegisteredEvent updateEvent(@PathVariable Long id, RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    }

}
