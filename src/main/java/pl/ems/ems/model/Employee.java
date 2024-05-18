package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nazwa użytkownika nie może być pusta")
    @Size(max = 50, message = "Nazwa użytkownika może mieć maksymalnie 50 znaków")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Hasło nie może być puste")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Email nie może być pusty")
    @Email(message = "Email musi być prawidłowy")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
