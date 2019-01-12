package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.CommentRepository;
import si.feri.um.vao.Comment;

import java.util.List;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    private CommentRepository commentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping(path = "/all")
    public List<Comment> getAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @GetMapping(path = "/{idComment}")
    public Comment getCommentById(@PathVariable int idComment) {
        if (commentRepository.existsById(idComment)) {
            //noinspection OptionalGetWithoutIsPresent
            return commentRepository.findById(idComment).get();
        } else
            return null;
    }

    @GetMapping(path = "/restaurant/{idRestaurant}")
    public List<Comment> getCommentsByRestaurantId(@PathVariable int idRestaurant) {
        return commentRepository.getCommentsByRestaurantIdRestaurant(idRestaurant);
    }

    @GetMapping(path = "/user/{idUser}")
    public List<Comment> getCommentsByUserId(@PathVariable int idUser) {
        return commentRepository.getCommentsByUserIdUser(idUser);
    }

    @PostMapping(path = "/add")
    public Comment addNewComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping(path = "update/{idComment}")
    public Comment updateComment(@RequestBody Comment newCommentData, @PathVariable int idComment) {
        return commentRepository.findById(idComment)
                .map(comment -> {
                    comment.setEdited(newCommentData.isEdited());
                    comment.setRestaurant(newCommentData.getRestaurant());
                    comment.setUser(newCommentData.getUser());
                    comment.setTimeOfPublication(newCommentData.getTimeOfPublication());
                    comment.setText(newCommentData.getText());
                    return commentRepository.save(comment);
                })
                .orElseGet(() -> {
                    newCommentData.setIdComment(idComment);
                    return commentRepository.save(newCommentData);
                });
    }

    @DeleteMapping(path = "/delete/{idComment}")
    public void deleteComment(@PathVariable int idComment) {
        if (commentRepository.existsById(idComment))
            commentRepository.deleteById(idComment);
    }
}
