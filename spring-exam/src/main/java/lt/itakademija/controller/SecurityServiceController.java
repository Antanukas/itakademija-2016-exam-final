package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

public class SecurityServiceController {

    private final SecurityEventsRepository repository;

    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    public List<RegisteredEvent> getRegisteredEvents() {
        throw new UnsupportedOperationException("not implemented");
    }

    public RegisteredEvent createEvent(EventRegistration registrationData) {
        throw new UnsupportedOperationException("not implemented");
    }

    public RegisteredEvent deleteEvent(Long id) {
        throw new UnsupportedOperationException("not implemented");
    }

    public RegisteredEvent updateEvent(Long id, RegisteredEventUpdate updateData) {
        throw new UnsupportedOperationException("not implemented");
    }

}
