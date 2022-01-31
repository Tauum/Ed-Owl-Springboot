package edowl.Repository;

import edowl.Model.ContactUs;
import edowl.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContactUsRepo extends JpaRepository<ContactUs, Long> {

    Optional<ContactUs> findContactUsById(Long id);

    void deleteContactUsById(Long id);

    List<ContactUs> findAllByOrderByGeneratedDate();
}

