package edowl.Service;

import edowl.Exception.EntityNotFoundException;
import edowl.Model.User;
import edowl.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) { return userRepo.save(user); }

    public List<User> findAll(){ return userRepo.findAll(); }

    public User updateUser(User user){ return userRepo.save(user); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteUser(Long id) { userRepo.deleteUserById(id);}

    public User findUserById(Long id)
    {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id)) ;
    }

    public User findUserByEmail(String email) { // < this is trying to get a user and puit it in a bool

        return userRepo.findUserByEmail(email);
        //  return userRepo.findByEmail(email);
        // VV disabled to prevent not returning a false
        //.orElseThrow(() -> new EntityNotFoundException("Entity not found with email: " + email));
    }
}
