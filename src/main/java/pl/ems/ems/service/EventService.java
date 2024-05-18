package pl.ems.ems.service;

import pl.ems.ems.model.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);
    void deleteEvent(Long id);
    Event getEventById(Long id);
    List<Event> getAllEvents();
    List<Event> searchEvents(String keyword);
}
