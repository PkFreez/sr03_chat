package fr.utc.sr03.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody // Pour faire sans template html
    public String test() {
    	List<User> users = userRepository.findAll();
        users.forEach(user -> {
            System.out.println(user.getFirstName() + " : " + user.isAdmin());
        });
        return "ok";
    }


    @GetMapping("/test2")
    @ResponseBody // Pour faire sans template html
    public String test2() {

        return "<h1>ok</h1>";
    }

    @GetMapping("/test3")
    @ResponseBody // Pour faire sans template html
    public String test3(@RequestParam(value = "myName", defaultValue = "World") String name, Model model) {

        return "";
    }
}
