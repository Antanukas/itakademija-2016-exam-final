package lt.itakademija.controller;

import lt.itakademija.model.EventRegistration;
import lt.itakademija.model.RegisteredEvent;
import lt.itakademija.model.RegisteredEventUpdate;
import lt.itakademija.repository.SecurityEventsRepository;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController //Prideta
@Api(value="Security service")
@RequestMapping(value="/spring-exam/webapi/events")
@EnableAutoConfiguration
public class SecurityServiceController {
	
	@Autowired //Prideta
    private final SecurityEventsRepository repository;

    public SecurityServiceController(final SecurityEventsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Get registered events", notes="Returns registered events")
    public List<RegisteredEvent> getRegisteredEvents() {
        return repository.getEvents();
        
    }
    
    @RequestMapping( method = RequestMethod.POST)
    @ApiOperation(value="Create registered events")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisteredEvent createEvent(@ApiParam(value="Event registration data", required=true)
    			@RequestBody EventRegistration registrationData) {
    	return repository.create(registrationData);
    }
   
    @RequestMapping(path="/{eventId}", method = RequestMethod.DELETE)
    @ApiOperation(value="Deletes registered events", notes="Deletes registered events by ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public RegisteredEvent deleteEvent(@ApiParam(value="Event ID", required=true)@PathVariable Long id) {
        return repository.delete(id);
    }
    
    
    @RequestMapping(path="/{eventId}", method = RequestMethod.PUT)
    @ApiOperation(value="Updates registered events", notes="Updates registered events by ID")
    public RegisteredEvent updateEvent(@ApiParam(value="Event ID", required=true)Long id,
    		@ApiParam(value="Reg. Event update data", required=true)RegisteredEventUpdate updateData) {
        return repository.update(id, updateData);
    }

}
