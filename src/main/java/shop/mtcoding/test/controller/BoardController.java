package shop.mtcoding.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.test.model.BoradRepository;

@Controller
public class BoardController {

    @Autowired
    BoradRepository boradRepository;

}
