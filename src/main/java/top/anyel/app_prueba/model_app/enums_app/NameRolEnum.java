package top.anyel.app_prueba.model_app.enums_app;

import lombok.AllArgsConstructor;
import lombok.Data;


public enum NameRolEnum {
    ADMIN("administrador"),
    USER("User"),
    GUEST("Guest");

    private String name;

    NameRolEnum(String name){
        this.name = name;
    }

}
