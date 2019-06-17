package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.UserRepository;
import si.feri.um.models.User;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(path = "/{idUser}")
    public User getUserById(@PathVariable int idUser) {
        if (userRepository.existsById(idUser)) {
            //noinspection OptionalGetWithoutIsPresent
            return userRepository.findById(idUser).get();
        } else
            return null;
    }

    @GetMapping(path = "/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.getUserByEmail(email);
    }

    @GetMapping(path = "/googleId/{googleUserId}")
    public User getUserByGoogleUserId(@PathVariable String googleUserId) {
        return userRepository.getUserByGoogleUserId(googleUserId);
    }

    @GetMapping(path = "/email/{email}/googleId/{googleUserId}")
    public Boolean getUserByEmailOrGoogleUserId(@PathVariable String email, @PathVariable String googleUserId) {
        return userRepository.getUserByEmailOrGoogleUserId(email, googleUserId) != null;
    }

    @PostMapping(path = "/add")
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping(path = "/update/{idUser}")
    public User updateUser(@RequestBody User newUserData, @PathVariable int idUser) {
        return userRepository.findById(idUser)
                .map(user -> {
                    user.setGoogleUserId(newUserData.getGoogleUserId());
                    user.setNameSurname(newUserData.getNameSurname());
                    user.setBirthday(newUserData.getBirthday());
                    user.setGender(newUserData.getGender());
                    user.setEmail(newUserData.getEmail());
                    user.setPhotoUrl(newUserData.getPhotoUrl());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUserData.setIdUser(idUser);
                    return userRepository.save(newUserData);
                });
    }

    @DeleteMapping(path = "/delete/{idUser}")
    public boolean deleteUser(@PathVariable int idUser) {
        if (userRepository.existsById(idUser)){
            userRepository.deleteById(idUser);
            return true;
        } else
            return false;
    }
}
