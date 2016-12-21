package lt.itakademija.repository;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * In-memory security events repository. Internally, it uses {@link SequenceNumberGenerator} and {@link DateProvider}.
 *
 * Created by mariusg on 2016.12.19.
 */
@Repository
public final class InMemorySecurityEventsRepository implements SecurityEventsRepository {

    @Autowired
    private final SequenceNumberGenerator sequenceGenerator;

    @Autowired
    private final DateProvider dateProvider;

    private List<RegisteredEvent> events = new ArrayList<RegisteredEvent>();

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
        RegisteredEvent event = new RegisteredEvent(
                this.sequenceGenerator.getNext(),
                this.dateProvider.getCurrentDate(),
                eventRegistration.getSeverityLevel(),
                eventRegistration.getLocation(),
                eventRegistration.getDescription());
        events.add(event);
        return event;
    }

    @Override
    public List<RegisteredEvent> getEvents() {
        return events;
    }

    @Override
    public RegisteredEvent delete(Long id) {
        for (RegisteredEvent event : events) {
            if (event.getId() == id) {
                events.remove(event);
                return event;
            }
        }
        return null;
    }

    @Override
    public RegisteredEvent update(Long id, RegisteredEventUpdate registeredEventUpdate) {
        for (RegisteredEvent event : events) {
            if (id.equals(event.getId())){
                return new RegisteredEvent(
                        id,
                        this.dateProvider.getCurrentDate(),
                        registeredEventUpdate.getSeverityLevel(),
                        event.getLocation(),
                        event.getDescription());
            }
        }
        return null;
    }

    @Override
    public RegisteredEvent getBy(Long id) {
        for (RegisteredEvent event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    @Override
    public List<RegisteredEvent> getEventListBy(String dateFrom, String dateTill, String location, String description) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.GERMANY);
        Date dateFromD = null;
        Date dateTillD = null;
        try {
            dateFromD = format.parse(dateFrom);
            dateTillD = format.parse(dateTill);
            final Date df = dateFromD;
            final Date dt = dateTillD;
            events.stream().forEach(event -> System.out.println("DATE FROM - " + df  +
                    "DARE TILL" + dt +
                    "DATE IS " + event.getRegistrationDate()));
        return events.stream()
                .filter(event -> event.getRegistrationDate().after(df) &&
                        event.getRegistrationDate().before(dt))
                .filter(event -> event.getLocation().equals(location))
                .filter(event -> event.getDescription().contains(description))
                .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
