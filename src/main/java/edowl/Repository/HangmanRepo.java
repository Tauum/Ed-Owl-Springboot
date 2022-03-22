package edowl.Repository;

import edowl.Model.Hangman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HangmanRepo extends JpaRepository<Hangman, Long> {

    void deleteHangmanById(Long id);

    Optional<Hangman> findHangmanById(Long id);

    Hangman findFirstByHiddenOrderByIdDesc(boolean hidden);

    List<Hangman> findAllByOrderByGeneratedDateDesc();

    List<Hangman> findAllByHiddenOrderByGeneratedDateDesc(boolean hidden);

    Optional<Hangman> findFirstHangmanByTitle(String title);
}
