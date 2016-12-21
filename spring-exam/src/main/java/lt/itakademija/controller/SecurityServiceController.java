package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SecurityServiceController {

    private final SecurityEventsRepository repository;

    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    public List<RegisteredEvent> getRegisteredEvents() {
    	List<RegisteredEvent> list = new ArrayList();
    	for (RegisteredEvent dum : list) {
    		return list;
    		   }
        return list;
    }

    public RegisteredEvent createEvent(EventRegistration registrationData) {
        return null;
    }

    public RegisteredEvent deleteEvent(Long id) {
    	List<RegisteredEvent> list = new LinkedList<>();
    	list.remove(id);
		return null;
    }

    public RegisteredEvent updateEvent(Long id, RegisteredEventUpdate updateData) {
        return null;
    }

}
