package sk.itsovy.dolinsky.scalablebackend.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import sk.itsovy.dolinsky.scalablebackend.model.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/events")
public class EventController {

    ConcurrentMap<String, Event> events = new ConcurrentHashMap<>();

    @GetMapping("/list")
    public List<Event> getAllEvents() {
        return new ArrayList<Event>(events.values());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Returns event by Id", notes = "Click Try it out please", response = Event.class)
    public Event  getEventById(@ApiParam(value = "ID value for the event you need to retrieve", required = true)
                                   @PathVariable String id) {
        return events.get(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adds event", notes = "Fill the body to create an Event", response = Event.class)
    public Event addEvent(@RequestBody Event event) {
        events.put(event.getId(), event);
        return event;
    }

}



