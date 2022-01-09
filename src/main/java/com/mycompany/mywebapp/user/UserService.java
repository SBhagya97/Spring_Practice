package com.mycompany.mywebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws userNotFoundException {
        Optional<User> result = repo.findById(id);
        if(result.isPresent()){
           return result.get();
        }
        throw new userNotFoundException("Could not found the User with the ID"+id);
    }

    public void delete(Integer id) throws userNotFoundException{
        Long count = repo.countById(id);

        if(count == null || count == 0){
            try {
                throw new userNotFoundException("Could not found the User with the ID"+id);
            } catch (userNotFoundException e) {
                e.printStackTrace();
            }
        }
        repo.deleteById(id);
    }

}
