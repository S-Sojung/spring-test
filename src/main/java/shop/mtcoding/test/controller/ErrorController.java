package shop.mtcoding.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/notFound")
    public String error() {
        return "/error/error";
    }
}
