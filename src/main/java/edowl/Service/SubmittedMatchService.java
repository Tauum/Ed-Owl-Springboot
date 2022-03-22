package edowl.Service;

import edowl.Exception.EntityNotFoundException;
import edowl.Model.SubmittedMatch;
import edowl.Repository.SubmittedMatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubmittedMatchService {
    private final SubmittedMatchRepo submittedMatchRepo;

    @Autowired
    public SubmittedMatchService(SubmittedMatchRepo SubmittedMatchRepository) {
        this.submittedMatchRepo = SubmittedMatchRepository;
    }

    public SubmittedMatch addSubmittedMatch(SubmittedMatch matchSubmitted) { return submittedMatchRepo.save(matchSubmitted); }

    public List<SubmittedMatch> findAll(){ return submittedMatchRepo.findAll(); }

    public SubmittedMatch updateSubmittedMatch(SubmittedMatch matchSubmitted){ return submittedMatchRepo.save(matchSubmitted); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteSubmittedMatch(Long id) { submittedMatchRepo.deleteSubmittedMatchById(id);}

    public SubmittedMatch findSubmittedMatchById(Long id)
    {
        return submittedMatchRepo.findSubmittedMatchById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id));
    }

    public List<SubmittedMatch> findAllByUserId(Long id) {
        return submittedMatchRepo.findAllByUserIdOrderByGeneratedDateDesc(id);
    }

    public boolean patchRating(Boolean rating, Long id) {
        SubmittedMatch find = findSubmittedMatchById(id);
        if ( find != null){
            find.setRating(rating);
            submittedMatchRepo.save(find);
            return true;
        }
        return false;
    }
}
