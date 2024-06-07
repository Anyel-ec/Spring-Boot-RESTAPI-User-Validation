package top.anyel.app_prueba.controller_app;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.app_prueba.model_app.Rol_app;
import top.anyel.app_prueba.model_app.User_app;
import top.anyel.app_prueba.model_app.enums_app.NameRolEnum;
import top.anyel.app_prueba.service_app.UserService_app;
import top.anyel.app_prueba.shared_app.logger.CustomLoggerFactory_app;
import top.anyel.app_prueba.shared_app.logger.ICustomLogger_app;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/user_app/v1/")
public class UserController_app {
    private final ICustomLogger_app logger_app;

    private final UserService_app userService_app;

    @Autowired
    public UserController_app(CustomLoggerFactory_app loggerApp, UserService_app userServiceApp) {
        logger_app = loggerApp.getLogger(UserController_app.class); // used class to get the logger
        userService_app = userServiceApp;
    }

    @GetMapping("/")
    public ResponseEntity<Void> index() {
        try {
            logger_app.logInfo("Redirigiendo a Swagger UI");
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/swagger-ui.html")).build();
        } catch (Exception e) {
            logger_app.logError("Error en el inicio de la aplicacion", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/save_body_app")
    public ResponseEntity<?> save(@Valid @RequestBody User_app user_app) {
        try{
            User_app savedUser = userService_app.save(user_app);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // TODO: ! NO IS RECOMMEND TO LIST THE PARAMS
    @PostMapping("/save_params_app")
    public ResponseEntity<?> save(@RequestParam String id_app,
                                  @RequestParam String identification_app,
                                  @RequestParam String name_app,
                                  @RequestParam String lastname_app,
                                  @RequestParam String email_app,
                                  @RequestParam String birthDate_app,
                                  @RequestParam String creationDate_app,
                                  @RequestParam List<String> rol_app) {

        try {

            User_app user_app = new User_app();
            user_app.setId_app(Integer.parseInt(id_app));
            user_app.setIdentification_app(identification_app);
            user_app.setName_app(name_app);
            user_app.setLastName_app(lastname_app);
            user_app.setEmail_app(email_app);
            user_app.setBirthDate_app(LocalDateTime.parse(birthDate_app));
            user_app.setCreationDate_app(LocalDate.parse(creationDate_app));

            List<Rol_app> rolAppList = rol_app.stream()
                    .map(rolName -> new Rol_app(0, NameRolEnum.ADMIN, "Description for " + rolName))
                    .collect(Collectors.toList());

            user_app.setRol_app(rolAppList);

            User_app savedUser = userService_app.save(user_app);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            logger_app.logError("Error al guardar el usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User_app>> findAll() {
        try {
            List<User_app> users = userService_app.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            logger_app.logWarn("Error al buscar usuarios", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User_app> findById(@PathVariable int id) {
        try {
            User_app user = userService_app.findById(id);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger_app.logError("Error al buscar usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateById/")
    public ResponseEntity<?> updateById(@RequestParam int id,
                                        @RequestBody User_app user_app) {
        try {
            User_app updatedUser = userService_app.updateById(id, user_app);
            if (updatedUser == null) {
                String mensaje = "No se encontraron datos para el ID proporcionado.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
            }
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            logger_app.logError("Error al actualizar usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            String mensaje = userService_app.deleteById(id);
            if (mensaje == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron datos para el ID proporcionado.");
            }
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            logger_app.logError("Error al eliminar usuario", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }



}
