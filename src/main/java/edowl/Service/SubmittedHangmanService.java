package edowl.Service;

import edowl.Exception.EntityNotFoundException;
import edowl.Model.SubmittedHangman;
import edowl.Repository.SubmittedHangmanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubmittedHangmanService {
    private final SubmittedHangmanRepo submittedHangmanRepo;
    @Autowired
    public SubmittedHangmanService(SubmittedHangmanRepo hangmanSubmittedRepo) {
        this.submittedHangmanRepo = hangmanSubmittedRepo;
    }

    public List<SubmittedHangman> findAll() {
        return submittedHangmanRepo.findAll();
    }

    public SubmittedHangman findSubmittedHangmanById(Long id) {
        return submittedHangmanRepo.findSubmittedHangmanById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id));
    }

    public SubmittedHangman addSubmittedHangman(SubmittedHangman hangmanSubmitted) {
        return submittedHangmanRepo.save(hangmanSubmitted);
    }

    public SubmittedHangman updateSubmittedHangman(SubmittedHangman hangmanSubmitted) {
        return submittedHangmanRepo.save(hangmanSubmitted);
    }
    @Transactional
    public void deleteSubmittedHangman(Long id) {
        submittedHangmanRepo.deleteSubmittedHangmanById(id);
    }

    public List<SubmittedHangman> findAllByUserIdAndHangmanId(Long userId, Long hangmanId) {
        return submittedHangmanRepo.findAllSubmittedHangmanByUserIdAndHangmanId(userId,hangmanId);
    }

    public List<SubmittedHangman> findAllByUserId(Long id) {
        return submittedHangmanRepo.findAllByUserIdOrderByGeneratedDateDesc(id);
    }
}

