package edowl.Repository;

import edowl.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {

    void deleteNoteById(Long id);

    Optional<Note> findNoteById(Long id);

    List<Note> findAll();

    List<Note> findAllByUserId(Long id);
}
