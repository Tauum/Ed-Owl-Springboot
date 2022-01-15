package edowl.Repository;

import edowl.Model.SubmittedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubmittedQuestionRepo extends JpaRepository<SubmittedQuestion, Long> {

    void deleteSubmittedQuestionById(Long id);

    Optional<SubmittedQuestion> findSubmittedQuestionById(Long id);
}