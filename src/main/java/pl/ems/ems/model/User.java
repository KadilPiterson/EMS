package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Nazwa użytkownika nie może być pusta")
    @Size(max = 50, message = "Nazwa użytkownika nie może przekraczać 50 znaków")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Hasło nie może być puste")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Email nie może być pusty")
    @Email(message = "Email musi być poprawny")
    @Size(max = 100, message = "Email nie może przekraczać 100 znaków")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Imię nie może być puste")
    @Size(max = 50, message = "Imię nie może przekraczać 50 znaków")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(max = 50, message = "Nazwisko nie może przekraczać 50 znaków")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull(message = "Płeć nie może być pusta")
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "PESEL nie może być pusty")
    @Pattern(regexp = "\\d{11}", message = "PESEL musi składać się z 11 cyfr")
    @Column(name = "pesel", nullable = false, unique = true)
    private String pesel;

    @NotBlank(message = "Telefon nie może być pusty")
    @Size(max = 15, message = "Telefon nie może przekraczać 15 znaków")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotNull(message = "Status użytkownika nie może być pusty")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @NotBlank(message = "Kod pocztowy nie może być pusty")
    @Size(max = 10, message = "Kod pocztowy nie może przekraczać 10 znaków")
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @NotBlank(message = "Numer domu nie może być pusty")
    @Size(max = 10, message = "Numer domu nie może przekraczać 10 znaków")
    @Column(name = "house_number", nullable = false)
    private String houseNumber;

    @Size(max = 10, message = "Numer lokalu nie może przekraczać 10 znaków")
    @Column(name = "apartment_number")
    private String apartmentNumber;

    @NotBlank(message = "Ulica nie może być pusta")
    @Size(max = 100, message = "Ulica nie może przekraczać 100 znaków")
    @Column(name = "street", nullable = false)
    private String street;

    @NotBlank(message = "Miasto nie może być puste")
    @Size(max = 50, message = "Miasto nie może przekraczać 50 znaków")
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}