package edowl.Service;


import edowl.Exception.EntityNotFoundException;
import edowl.Model.Announcement;
import edowl.Repository.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepo announcementRepo;

    @Autowired
    public AnnouncementService(AnnouncementRepo announcementRepository) {
        this.announcementRepo = announcementRepository;
    }

    public Announcement addUpdate(Announcement announcement) { return announcementRepo.save(announcement); }

    public List<Announcement> findAll(){ return announcementRepo.findAll(); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteAnnouncement(Long id) { announcementRepo.deleteAnnouncementById(id);}

    public Announcement findAnnouncementById(Long id) {
        return announcementRepo.findAnnouncementById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id)) ;
    }

    public List<Announcement> findAllOrderByDate() {
        return announcementRepo.findAllByOrderByGeneratedDate();
    }
}