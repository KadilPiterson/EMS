package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_event_approvals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Identyfikator wydarzenia nie może być pusty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @NotNull(message = "Identyfikator pracownika nie może być pusty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @NotNull(message = "Status zatwierdzenia nie może być pusty")
    @Pattern(regexp = "approved|rejected", message = "Status zatwierdzenia może być tylko 'approved' lub 'rejected'")
    @Column(name = "approval_status", nullable = false)
    private String approvalStatus;

    @Column(name = "approval_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvalDate;

    @PrePersist
    protected void onCreate() {
        approvalDate = new Date();
    }
}
