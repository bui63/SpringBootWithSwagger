package com.demo.swagger.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static int idCount=3;
    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User(1,"Rahul",new Date()));
        users.add(new User(2,"Rahul2",new Date()));
        users.add(new User(3,"Rahul3",new Date()));
    }
    public List<User> findALL() {
        return users;
    }
    public User save(User user) {
        if(user.getId()==0)
        {
            user.setId(++idCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id) {
        for(User user:users) {
            if(user.getId()==id) {
                return user;
            }
        }
        return  null;
    }
}
