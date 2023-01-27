package shop.mtcoding.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.test.model.Board;
import shop.mtcoding.test.model.BoardRepository;
import shop.mtcoding.test.model.User;

@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    HttpSession session;

    @GetMapping("/board/list")
    public String userBoard(Model model) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notFound";
        }
        model.addAttribute("page", "유저 게시글 목록");
        List<Board> boardList = boardRepository.findByUserId(principal.getId());
        model.addAttribute("boardList", boardList);
        // 여기서 자바 스크립트를 써서 하면 안됨. 리다이렉션이라 리퀘스트 두번 만들어져서
        // 데이터가 넘어갈 수 없다.
        return "board/list";
    }

    @GetMapping({ "/", "/allBoard" })
    public String board(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("page", "전체 게시글 목록");
        model.addAttribute("boardList", boardList);
        return "board/allList";
    }
}
