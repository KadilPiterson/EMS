package pl.ems.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tbl_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Nazwa roli nie może być pusta")
    @Size(max = 50, message = "Nazwa roli może mieć maksymalnie 50 znaków")
    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;
}
