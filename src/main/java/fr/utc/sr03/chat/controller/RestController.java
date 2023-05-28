package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.UserService;
import fr.utc.sr03.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("ws")
public class RestController {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getUser() {

        return userService.getAllUsers();

    }

    /*@GetMapping("/onebylogin/{login}")
    public TrombiIndividusDTO getIndividu(@PathVariable String login)
    {
        TrombiIndividus trombiIndividus = trombiService.getOne(login);

        return "blablabla";
    }*/

}
