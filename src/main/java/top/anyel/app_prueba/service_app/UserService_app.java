package top.anyel.app_prueba.service_app;


import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import top.anyel.app_prueba.model_app.User_app;
import top.anyel.app_prueba.repository_app.UserRepository_app;

import java.util.List;

@Service
public class UserService_app {

    private UserRepository_app userRepository_app;

    public UserService_app(UserRepository_app userRepository_app){
        this.userRepository_app = userRepository_app;
    }

    public User_app save(User_app user_app){
        return userRepository_app.save(user_app);
    }

    public User_app findById(int id) {
        return userRepository_app.findById(id);
    }

    public List<User_app> findAll(){
        return userRepository_app.findAll();
    }

    public User_app updateById(int id, User_app user_app){
        return userRepository_app.updateById(id, user_app);
    }

    public String deleteById(int id){
        return userRepository_app.deleteById(id);
    }
}
