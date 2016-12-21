package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(value = "Security controller")
@RequestMapping("spring-exam/webapi/events")
public class SecurityServiceController {
	@Autowired
    private final SecurityEventsRepository repository;

    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }
    @RequestMapping()
    @ApiOperation(value = "")
    public List<RegisteredEvent> getRegisteredEvents() {
        throw new UnsupportedOperationException("not implemented");
    }
    @RequestMapping()
    @ApiOperation(value = "")
    public RegisteredEvent createEvent(EventRegistration registrationData) {
        throw new UnsupportedOperationException("not implemented");
    }
    @RequestMapping()
    @ApiOperation(value = "")
    public RegisteredEvent deleteEvent(Long id) {
        throw new UnsupportedOperationException("not implemented");
    }
    @RequestMapping()
    @ApiOperation(value = "")
    public RegisteredEvent updateEvent(Long id, RegisteredEventUpdate updateData) {
        throw new UnsupportedOperationException("not implemented");
    }

}
