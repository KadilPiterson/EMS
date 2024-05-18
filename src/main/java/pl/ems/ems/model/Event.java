package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "tbl_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Tytuł wydarzenia nie może być pusty")
    @Size(max = 100, message = "Tytuł wydarzenia może mieć maksymalnie 100 znaków")
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 500, message = "Opis wydarzenia może mieć maksymalnie 500 znaków")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Data wydarzenia nie może być pusta")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull(message = "Czas wydarzenia nie może być pusty")
    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Size(max = 100, message = "Lokalizacja może mieć maksymalnie 100 znaków")
    @Column(name = "location")
    private String location;

    @NotNull(message = "Maksymalna liczba uczestników nie może być pusta")
    @Min(value = 1, message = "Maksymalna liczba uczestników musi być większa od 0")
    @Column(name = "max_participants", nullable = false)
    private Integer maxParticipants;

    @NotNull(message = "Cena wydarzenia nie może być pusta")
    @DecimalMin(value = "0.0", inclusive = false, message = "Cena wydarzenia musi być większa od 0")
    @Digits(integer = 10, fraction = 2, message = "Cena wydarzenia musi być poprawna liczbowo")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @NotNull(message = "Status wydarzenia nie może być pusty")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EventStatus status;

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new java.util.Date();
    }
}