package edowl.Controller;

import edowl.Model.User;
import edowl.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/check")
//    public ResponseEntity<Boolean> checkValid(@RequestBody User user){
//        User attempt = userService.findUserByEmail(user.getEmail());
//        Boolean result;
//        if (attempt != null){ result = true; }
//        else{ result = false; }
//
//        return new ResponseEntity<>(result, HttpStatus.OK); //ok is 200 status code
//    }

    //@CrossOrigin( origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") Long id)
    {
        User User = userService.findUserById(id);
        return new ResponseEntity<>(User, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/checkAlt")
    public ResponseEntity<Boolean> checkValidPost(@RequestBody User user){
        User attempt = userService.findUserByEmail(user.getEmail());
        Boolean result;
        if (attempt != null){ result = true; }
        else{ result = false; }
        return new ResponseEntity<>(result, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/getByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestBody User user){
        User attempt = userService.findUserByEmail(user.getEmail());
        return new ResponseEntity<>(attempt, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id)
    {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED); //ok is 200 status code
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);  //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
