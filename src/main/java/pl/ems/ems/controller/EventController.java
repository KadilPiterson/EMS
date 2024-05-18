package pl.ems.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ems.ems.model.Event;
import pl.ems.ems.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            event.setTitle(eventDetails.getTitle());
            event.setDescription(eventDetails.getDescription());
            event.setDate(eventDetails.getDate());
            event.setTime(eventDetails.getTime());
            event.setLocation(eventDetails.getLocation());
            event.setMaxParticipants(eventDetails.getMaxParticipants());
            event.setPrice(eventDetails.getPrice());
            event.setStatus(eventDetails.getStatus());

            Event updatedEvent = eventService.saveEvent(event);
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam String keyword) {
        List<Event> events = eventService.searchEvents(keyword);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
