package fr.utc.sr03.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//controllers in a Spring MVC application are responsible for handling HTTP requests, processing user input, and returning a response.
@Controller
public class test {

    @GetMapping("helloTEST")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name, Model model) {
        return String.format("Hello %s!", name);
        //model.addAttribute("nom", name);
        //return "helloHTML"
    }
}
