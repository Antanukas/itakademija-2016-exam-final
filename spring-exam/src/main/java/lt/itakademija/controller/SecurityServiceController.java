package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

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
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents(); 
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredEvent createEvent(@PathVariable  EventRegistration registrationData) {
        return repository.create(registrationData);
    }
    
    @DeleteMapping("/{eventId}")
  
    public RegisteredEvent deleteEvent(@PathVariable Long id) {
        return repository.delete(id);
    }
    
    @PutMapping("/{eventId}")
    public RegisteredEvent updateEvent(@RequestBody Long id, @RequestBody RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    }
   /* @DateTimeFormat("MMddyyyy")
    @GetMapping(value = "/spring-exam/webapi/events", params={fromDate}, params={toDate}, params)
    @ResponseBody
    public List<RegisteredEvent> getRegisteredEventsByDate() {
        return repository.getEvents(); 
    }*/
}
