package shop.mtcoding.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.test.model.User;
import shop.mtcoding.test.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;

    @GetMapping({ "/", "/loginForm" })
    public String loginForm() {

        return "user/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinFonm() {

        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result != 1) {
            return "redirect:/notFound";
        }
        return "redirect:/loginForm";
    }

    @PostMapping("/login")
    public String join(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        }
        session.setAttribute("principal", user);
        return "redirect:/board";
    }
}
