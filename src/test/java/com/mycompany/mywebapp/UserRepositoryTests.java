package com.mycompany.mywebapp;

import com.mycompany.mywebapp.user.User;
import com.mycompany.mywebapp.user.UserRepository;
import org.assertj.core.api.Assertions;
//import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
//import static org.hamcrest.Matchers.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user =new User();
        user.setEmail("manulauu97@gmail.com");
        user.setPassword("manulamanula");
        user.setFirstname("Manula Hewa");
        user.setLastname("Uluwatte");
       // System.out.println("check");
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);

    }
    @Test
    public void testListAll(){
        Iterable<User> users= repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user :users ) {
            System.out.println(user);
        }
     }
}
