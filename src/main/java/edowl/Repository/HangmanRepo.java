package edowl.Repository;

import edowl.Model.Hangman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HangmanRepo extends JpaRepository<Hangman, Long> {

    void deleteHangmanById(Long id);

    Optional<Hangman> findHangmanById(Long id);

    Hangman findFirstByOrderByIdDesc();

}
