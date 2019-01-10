package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> getCommentsByRestaurantIdRestaurant(int idRestaurant);
    List<Comment> getCommentsByUserIdUser(int idUser);
}
