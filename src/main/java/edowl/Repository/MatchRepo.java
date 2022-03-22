package edowl.Repository;

import edowl.Model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepo extends JpaRepository<Match, Long> {

    void deleteMatchById(Long id);

    Optional<Match> findMatchById(Long id);

    List<Match> findAllByOrderByGeneratedDateDesc();

    List<Match> findAllByHiddenOrderByGeneratedDateDesc(boolean hidden);

    Match findFirstByHiddenOrderByIdDesc(boolean hidden);

    Optional<Object> findFirstMatchByTitle(String title);
}
