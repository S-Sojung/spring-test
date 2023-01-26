package shop.mtcoding.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/notFound")
    public String error() {
        return "/error/error";
    }
}
