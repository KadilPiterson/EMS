package pl.ems.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ems.ems.model.EventApproval;
import pl.ems.ems.repository.EventApprovalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventApprovalServiceImpl implements EventApprovalService {

    private final EventApprovalRepository eventApprovalRepository;

    @Autowired
    public EventApprovalServiceImpl(EventApprovalRepository eventApprovalRepository) {
        this.eventApprovalRepository = eventApprovalRepository;
    }

    @Override
    public EventApproval saveEventApproval(EventApproval eventApproval) {
        return eventApprovalRepository.save(eventApproval);
    }

    @Override
    public void deleteEventApproval(Long id) {
        eventApprovalRepository.deleteById(id);
    }

    @Override
    public EventApproval getEventApprovalById(Long id) {
        Optional<EventApproval> eventApproval = eventApprovalRepository.findById(id);
        return eventApproval.orElse(null);
    }

    @Override
    public List<EventApproval> getAllEventApprovals() {
        return eventApprovalRepository.findAll();
    }
}
