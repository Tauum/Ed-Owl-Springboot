package edowl.Repository;

import edowl.Model.Announcement;
import edowl.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AnnouncementRepo extends JpaRepository<Announcement, Long> {

    Optional<Announcement> findAnnouncementById(Long id);

    void deleteAnnouncementById(Long id);

    List<Announcement> findAllByOrderByGeneratedDate();
}

