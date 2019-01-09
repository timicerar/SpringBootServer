package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import si.feri.um.repositories.CommentRepository;
import si.feri.um.vao.Comment;

@Controller
@RequestMapping(path = "/comment")
public class CommentController {

    private CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
