package edowl.Controller;


import edowl.Model.Announcement;
import edowl.Service.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Announcement")
@CrossOrigin
public class AnnouncementController {
    private final AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public ResponseEntity<List<Announcement>> getAllAnnouncement()
    {
        List<Announcement> announcements = announcementService.findAllOrderByDate();
        return new ResponseEntity<>(announcements, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement announcement)
    {
        Announcement newAnnouncement = announcementService.addUpdate(announcement);
        return new ResponseEntity<>(announcement, HttpStatus.CREATED); //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable("id") Long id)
    {
        Announcement attempt = announcementService.findAnnouncementById(id);
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

