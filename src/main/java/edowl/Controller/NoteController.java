package edowl.Controller;

import edowl.Model.Note;
import edowl.Service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Note")
@CrossOrigin
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {this.noteService = noteService; }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes()
    {
        List<Note> notes = noteService.findAll();
        return new ResponseEntity<>(notes, HttpStatus.OK); //ok is 200 status code
    }
    
    @GetMapping("/GetAllForUser/{id}")
    public ResponseEntity<List<Note>> GetAllForUser(@PathVariable("id") Long id){
        List<Note> notes = noteService.findAllByUserId(id);
        return new ResponseEntity<>(notes, HttpStatus.CREATED); //ok is 200 status code
    }

    @PostMapping("/add")
    public ResponseEntity<Note> addNote(@RequestBody Note note)
    {
        Note newNote = noteService.addNote(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED); //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id)
    {
        Note attempt = noteService.findNoteById(id);
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

