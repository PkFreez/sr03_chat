package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.dao.UserService;
import fr.utc.sr03.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String postLogin(@ModelAttribute User user, Model model) {
        //TODO verif login
        System.out.println("===> mail = " + user.getMail());
        System.out.println("===> password = " + user.getPassword());
        System.out.println("===> isAdmin = " + user.isAdmin());
        User userLogin = userService.getUser(user.getMail(), user.getPassword(), user.isAdmin());
        if (userLogin == null)//il n'y a pas de tel utilisateur dans la base de donnée
        {
            model.addAttribute("loginError", true);
            return "login";
        }
        if (user.isAdmin()) // l'utilisateur se connecte en tant qu'admin
        {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return "user_list";
        }
        //l'utilisateur se connecte pour les fonctionnalités classiques du webapp
        model.addAttribute("user", userLogin);

        return "user_frontpage";
    }
}
