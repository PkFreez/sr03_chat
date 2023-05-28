package fr.utc.sr03.chat.dao;

import fr.utc.sr03.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {//User = entity the repository work with, Long = type of primary key.
    //User findByMail(String mail); //par exemple. Utilisation : User user = userRepository.findByMail("cccc");
}
