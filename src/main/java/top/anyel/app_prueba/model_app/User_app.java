package top.anyel.app_prueba.model_app;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class User_app {

    @NotNull(message = "ID cannot be null")
    private int id_app;

    @NotBlank(message = "Identification cannot be blank")
    private String identification_app;

    @NotNull(message = "Name cannot be null")
    private String name_app;

    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName_app;

    @Email(message = "Email must be a valid email")
    private String email_app;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate_app;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate_app;

    @NotNull(message = "Rol cannot be null")
    private List<Rol_app> rol_app;

    public User_app() {

    }

}
