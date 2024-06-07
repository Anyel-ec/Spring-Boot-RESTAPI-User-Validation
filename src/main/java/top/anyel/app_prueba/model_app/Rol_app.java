package top.anyel.app_prueba.model_app;


import lombok.AllArgsConstructor;
import lombok.Data;
import top.anyel.app_prueba.model_app.enums_app.NameRolEnum;

@Data
@AllArgsConstructor
public class Rol_app {
    private int id;
    private NameRolEnum name;
    private String description;
}
