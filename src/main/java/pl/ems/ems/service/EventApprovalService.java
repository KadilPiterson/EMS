package pl.ems.ems.service;

import pl.ems.ems.model.EventApproval;

import java.util.List;

public interface EventApprovalService {
    EventApproval saveEventApproval(EventApproval eventApproval);
    void deleteEventApproval(Long id);
    EventApproval getEventApprovalById(Long id);
    List<EventApproval> getAllEventApprovals();
}
