package edowl.Service;

import edowl.Exception.EntityNotFoundException;
import edowl.Model.Note;
import edowl.Repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NoteService {
    private final NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepository) {
        this.noteRepo = noteRepository;
    }

    public Note addNote(Note note) { return noteRepo.save(note); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteNote(Long id) { noteRepo.deleteNoteById(id);}

    public Note findNoteById(Long id)
    {
        return noteRepo.findNoteById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id)) ;
    }


    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    public List<Note> findAllByUserId(Long id) {
        return noteRepo.findAllByUserId(id);
    }
}