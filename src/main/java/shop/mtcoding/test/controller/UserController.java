package shop.mtcoding.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.test.model.User;
import shop.mtcoding.test.model.UserRepository;
import shop.mtcoding.test.util.Script;

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

    @ResponseBody
    @PostMapping("/join")
    public String join(String username, String password, String email) {
        try {
            int result = userRepository.insert(username, password, email);
            if (result != 1) {
                return Script.back("회원가입 실패");
            }
        } catch (Exception e) {
            return Script.back("회원가입 실패");
            // TODO: handle exception
        }

        return Script.href("/loginForm");
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

    @GetMapping("/userInfoForm")
    public String userInfoForm(Model model) {
        User principal = (User) session.getAttribute("principal");
        model.addAttribute("page", "회원 정보 수정");

        model.addAttribute("user", principal);
        return "user/userInfoForm";
    }

    @PostMapping("/userInfo/{id}/update")
    public String userInfo(@PathVariable int id, Model model, String password) {
        // 유효성 검사를 해야한다.
        // 인증검사
        // 권한검사

        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            return "redirect:/loginForm";
        }

        if (id != principal.getId()) {
            return "redirect:/loginForm";
        }

        int result = userRepository.updateById(principal.getId(), password);
        if (result != 1) {
            return "redirect:/notFound";
        }

        // 세션 동기화
        User user = userRepository.findById(principal.getId());
        session.setAttribute("principal", user);
        return "redirect:/board/list";
    }
}
