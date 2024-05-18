package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name = "tbl_user_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "ID użytkownika nie może być puste")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "ID roli nie może być puste")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
