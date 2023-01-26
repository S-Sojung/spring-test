package shop.mtcoding.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.test.model.User;
import shop.mtcoding.test.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession session;

    @GetMapping("/loginForm")
    public String loginForm(Model model) {
        model.addAttribute("page", "로그인");
        return "user/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinFonm(Model model) {
        model.addAttribute("page", "회원가입");
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
        return "redirect:/board/list";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/loginForm";
    }

    @GetMapping("/userInfoForm/{id}")
    public String userInfoForm(Model model, @PathVariable int id) {
        User principal = (User) session.getAttribute("principal");
        model.addAttribute("page", "회원 정보 수정");

        if (principal == null) {
            return "redirect:/loginForm";
        }
        User user = (User) session.getAttribute("principal");
        if (user.getId() != principal.getId()) {
            return "redirect:/loginForm";
        }

        model.addAttribute("user", user);
        return "user/userInfoForm";
    }

    @PostMapping("/userInfo")
    public String userInfo(Model model, String password) {
        User principal = (User) session.getAttribute("principal");

        int result = userRepository.updateById(principal.getId(), password);
        if (result != 1) {
            return "redirect:/notFound";
        }
        return "redirect:/board/list";
    }
}
