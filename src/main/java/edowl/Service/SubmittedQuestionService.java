package edowl.Service;


import edowl.Exception.EntityNotFoundException;
import edowl.Model.SubmittedQuestion;
import edowl.Repository.SubmittedQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmittedQuestionService {
    private final SubmittedQuestionRepo submittedQuestionRepo;

    @Autowired
    public SubmittedQuestionService(SubmittedQuestionRepo submittedQuestionRepository) {
        this.submittedQuestionRepo = submittedQuestionRepository;
    }

    public SubmittedQuestion addSubmittedQuestion(SubmittedQuestion submittedQuestion) { return submittedQuestionRepo.save(submittedQuestion); }

    public List<SubmittedQuestion> findAll(){ return submittedQuestionRepo.findAll(); }

    public SubmittedQuestion updateSubmittedQuestion(SubmittedQuestion submittedQuestion){ return submittedQuestionRepo.save(submittedQuestion); }

    //query method (auto generates method in spring back-backend)
    public void deleteSubmittedQuestion(Long id) { submittedQuestionRepo.deleteSubmittedQuestionById(id);}

    public SubmittedQuestion findSubmittedQuestionById(Long id)
    {
        return submittedQuestionRepo.findSubmittedQuestionById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id));
    }
}