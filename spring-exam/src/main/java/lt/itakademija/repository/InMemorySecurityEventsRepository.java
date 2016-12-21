package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */

@Component
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	@Autowired
    private final SequenceNumberGenerator sequenceGenerator;
    
    private final List<RegisteredEvent> eventList = new ArrayList<RegisteredEvent>();

    @Autowired
    private final DateProvider dateProvider;

    public InMemorySecurityEventsRepository(SequenceNumberGenerator sequenceGenerator, DateProvider dateProvider) {
        this.sequenceGenerator = sequenceGenerator;
        this.dateProvider = dateProvider;
    }

    /*
     *  Notes for implementation:
     *  
     *  This method must use SequenceNumberGenerator#getNext() for generating ID;
     *  This method must use DateProvider#getCurrentDate() for getting dates;
     */
    @Override
    public RegisteredEvent create(EventRegistration eventRegistration) {
       // throw new UnsupportedOperationException("not implemented");
    	 RegisteredEvent registeredEvent = new RegisteredEvent(this.sequenceGenerator.getNext(),
					this.dateProvider.getCurrentDate(),
					eventRegistration.getSeverityLevel(),
					eventRegistration.getLocation(),
					eventRegistration.getDescription());
    	 			eventList.add(registeredEvent);
    	 			return registeredEvent;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        //throw new UnsupportedOperationException("not implemented");
    	return this.eventList;
        
    }
    
	private RegisteredEvent find(Long id) {
		return eventList.stream()
				.filter(val -> val.getId().equals(id))
				.findFirst().get();
	}

    @Override
    public RegisteredEvent delete(Long id) {
        //throw new UnsupportedOperationException("not implemented");
        RegisteredEvent registeredEvent = this.find(id);
        eventList.remove(registeredEvent);
        return registeredEvent;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        throw new UnsupportedOperationException("not implemented");
    }

}
