package edowl.Service;


import edowl.Exception.EntityNotFoundException;
import edowl.Model.Quiz;
import edowl.Repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuizService {
    private final QuizRepo quizRepo;

    @Autowired
    public QuizService(QuizRepo quizRepository) {
        this.quizRepo = quizRepository;
    }

    public Quiz addQuiz(Quiz quiz) { return quizRepo.save(quiz); }

    public List<Quiz> findAll(){ return quizRepo.findAll(); }

    public Quiz updateQuiz(Quiz quiz){ return quizRepo.save(quiz); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteQuiz(Long id) { quizRepo.deleteQuizById(id);}

    public Quiz findQuizById(Long id)
    {
        return quizRepo.findQuizById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id));
    }

    public List<Quiz> findAllOrderByGeneratedDateDesc() {
        return quizRepo.findAllByOrderByGeneratedDateDesc();
    }

    public Quiz findQuizOrderByGeneratedDateDesc() {
        return quizRepo.findFirstByOrderByIdDesc();
    }
}

