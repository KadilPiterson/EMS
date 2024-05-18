package pl.ems.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ems.ems.model.EventApproval;
import pl.ems.ems.service.EventApprovalService;

import java.util.List;

@RestController
@RequestMapping("/api/event-approvals")
public class EventApprovalController {

    private final EventApprovalService eventApprovalService;

    @Autowired
    public EventApprovalController(EventApprovalService eventApprovalService) {
        this.eventApprovalService = eventApprovalService;
    }

    @PostMapping
    public ResponseEntity<EventApproval> createEventApproval(@RequestBody EventApproval eventApproval) {
        EventApproval savedEventApproval = eventApprovalService.saveEventApproval(eventApproval);
        return new ResponseEntity<>(savedEventApproval, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventApproval> getEventApprovalById(@PathVariable Long id) {
        EventApproval eventApproval = eventApprovalService.getEventApprovalById(id);
        if (eventApproval != null) {
            return new ResponseEntity<>(eventApproval, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EventApproval>> getAllEventApprovals() {
        List<EventApproval> eventApprovals = eventApprovalService.getAllEventApprovals();
        return new ResponseEntity<>(eventApprovals, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventApproval> updateEventApproval(@PathVariable Long id, @RequestBody EventApproval eventApprovalDetails) {
        EventApproval eventApproval = eventApprovalService.getEventApprovalById(id);
        if (eventApproval != null) {
            eventApproval.setEvent(eventApprovalDetails.getEvent());
            eventApproval.setEmployee(eventApprovalDetails.getEmployee());
            eventApproval.setApprovalStatus(eventApprovalDetails.getApprovalStatus());

            EventApproval updatedEventApproval = eventApprovalService.saveEventApproval(eventApproval);
            return new ResponseEntity<>(updatedEventApproval, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEventApproval(@PathVariable Long id) {
        eventApprovalService.deleteEventApproval(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
