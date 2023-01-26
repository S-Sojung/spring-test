package shop.mtcoding.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.test.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping({ "/", "/loginForm" })
    public String loginForm() {

        return "user/loginForm";
    }
}
