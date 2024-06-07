package top.anyel.app_prueba.repository_app;

import org.springframework.stereotype.Repository;
import top.anyel.app_prueba.model_app.User_app;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository_app {
    List<User_app> users_app = new ArrayList<>();


    public User_app save(User_app user_app){
        users_app.add(user_app);
        return user_app;
    }

    public List<User_app> findAll(){
        return users_app;
    }

    public User_app findById(int id){
        for(User_app user_app : users_app){
            if(user_app.getId_app() == id){
                return user_app;
            }
        }
        return null;
    }
    public User_app updateById(int id, User_app user_app){
        for(int i = 0; i < users_app.size(); i++){
            if(users_app.get(i).getId_app() == id){
                users_app.set(i, user_app);
                return user_app;
            }
        }
        return null;
    }

    public String deleteById(int id){
        for(int i = 0; i < users_app.size(); i++){
            if(users_app.get(i).getId_app() == id){
                users_app.remove(i);
                return "User with id " + id + " was deleted";
            }
        }
        return null;
    }



}
