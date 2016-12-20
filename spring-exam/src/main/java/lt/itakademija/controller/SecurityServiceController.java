package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityServiceController {

	@Autowired
    private final SecurityEventsRepository repository;

	public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
    	//throw new UnsupportedOperationException("not implemented");
    }

    public RegisteredEvent createEvent(EventRegistration registrationData) {
        return repository.create(registrationData);
    	//throw new UnsupportedOperationException("not implemented");
    }

    public RegisteredEvent deleteEvent(Long id) {
        return repository.delete(id);
    	//throw new UnsupportedOperationException("not implemented");
    }

    public RegisteredEvent updateEvent(Long id, RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    	//throw new UnsupportedOperationException("not implemented");
    }

}
