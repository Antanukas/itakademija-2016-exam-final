package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    private final SequenceNumberGenerator sequenceGenerator;

    private final DateProvider dateProvider;
    
    private final List<RegisteredEvent> regEvents = new ArrayList<RegisteredEvent>();

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
        RegisteredEvent re = new RegisteredEvent(this.sequenceGenerator.getNext(),
        						this.dateProvider.getCurrentDate(),
        						eventRegistration.getSeverityLevel(),
        						eventRegistration.getLocation(),
        						eventRegistration.getLocation());
    	regEvents.add(re);
    	return re;
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return Collections.unmodifiableList(regEvents);
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public RegisteredEvent delete(Long id) {
        RegisteredEvent re = this.find(id);
        regEvents.remove(re);
        return re;
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
    	RegisteredEvent re = null;
    	for (int j = 0; j < regEvents.size(); j++) {
    		re = regEvents.get(j); 
			if (re.getId().equals(id)) {
				re.setSeverityLevel(registeredEventUpdate.getSeverityLevel());
				regEvents.add(j, re);
				break;
			}
		}
    	return re;
    	//throw new UnsupportedOperationException("not implemented");
    }
    
    private RegisteredEvent find(Long id) {
    	return regEvents.stream()
						.filter(reg -> reg.getId().equals(id))
						.findFirst().get();
    }

}
