package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
