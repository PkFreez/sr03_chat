package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import fr.utc.sr03.chat.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;



@Controller
@RequestMapping("admin")//any request like http://localhost:8080/admin/... will be handled by the controller.
public class AdminController {
    @Autowired
    private UserRepository userRepository;//access and manipulation of data
    @Autowired
    private UserService userService;
    @GetMapping("users")//http://localhost:8080/admin/users
    public String getUserList(Model model) {
        List<User> users = userService.getAllUsers();//List<User> users = userRepository.findAll( );
        model.addAttribute("users", users);//model attribute initialized and created for each controller method request, then forwarded to the html View.
        return "user_list";
    }

    @GetMapping("users/add")//http://localhost:8080/admin/users/add
    public String getUserForm(Model model) {
        model.addAttribute("user", new User( ));
        return "user_form";
    }

    @PostMapping("users/add")//http://localhost:8080/admin/users/add + POST
    public String addUser(@ModelAttribute User user, Model model) {//@ModelAttribute binds HTTP request parameters to model attributes.
        System.out.println("===> first name = " + user.getFirstName());
        System.out.println("===> last name = " + user.getLastName());
        //securité pas à faire

        user.setMail(user.getMail());
        user.setPassword(user.getPassword());
        user.setAdmin(false);
        //userRepository.save(user);
        userService.addUser(user);
        return "redirect:/admin/users";

    }
}
