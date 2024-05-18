package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Identyfikator wydarzenia nie może być pusty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @NotNull(message = "Identyfikator użytkownika nie może być pusty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "registered_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @PrePersist
    protected void onCreate() {
        registeredAt = new Date();
    }
}
