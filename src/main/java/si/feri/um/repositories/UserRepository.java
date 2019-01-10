package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByGoogleUserId(String googleUserId);
    User getUserByEmail(String email);
    User getUserByEmailOrGoogleUserId(String email, String googleUserId);
}
