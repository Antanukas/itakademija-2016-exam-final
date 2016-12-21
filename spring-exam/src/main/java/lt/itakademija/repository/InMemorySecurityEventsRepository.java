package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Component
//@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

	@Autowired
    private final SequenceNumberGenerator sequenceGenerator;

	@Autowired
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
    @Transactional
    public RegisteredEvent create(EventRegistration eventRegistration) {
        RegisteredEvent re = new RegisteredEvent(this.sequenceGenerator.getNext(),
        						this.dateProvider.getCurrentDate(),
        						eventRegistration.getSeverityLevel(),
        						eventRegistration.getLocation(),
        						eventRegistration.getDescription());
    	regEvents.add(re);
    	return re;
    	//throw new UnsupportedOperationException("not implemented");
    }

    
    @Override
    @Transactional(readOnly = true)
    public List<RegisteredEvent> getEvents() {
        return Collections.unmodifiableList(regEvents);
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    @Transactional
    public RegisteredEvent delete(Long id) {
        RegisteredEvent re = this.find(id);
        regEvents.remove(re);
        return re;
    	//throw new UnsupportedOperationException("not implemented");
    }

    @Override
    @Transactional
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
    

    /*
     *  author - Andrius Sareika
     *  
     */
	@Override
	public RegisteredEvent getEvent(Long id) {
		return this.find(id);
	}

	
    /*
     *  Helper method
     *  author - Andrius Sareika
     *  
     */
	@Transient
	private RegisteredEvent find(Long id) {
		return regEvents.stream()
				.filter(reg -> reg.getId().equals(id))
				.findFirst().get();
	}
}
