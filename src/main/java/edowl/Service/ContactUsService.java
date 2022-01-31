package edowl.Service;


import edowl.Exception.EntityNotFoundException;
import edowl.Model.ContactUs;
import edowl.Repository.ContactUsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ContactUsService {
    private final ContactUsRepo contactUsRepo;

    @Autowired
    public ContactUsService(ContactUsRepo contactUsRepository) {
        this.contactUsRepo = contactUsRepository;
    }

    public ContactUs addContactUs(ContactUs contactUs) { return contactUsRepo.save(contactUs); }

    public List<ContactUs> findAll(){ return contactUsRepo.findAll(); }

    //query method (auto generates method in spring back-backend)
    @Transactional
    public void deleteContactUs(Long id) { contactUsRepo.deleteContactUsById(id);}

    public ContactUs findContactUsById(Long id) {
        return contactUsRepo.findContactUsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not foud with id: " + id)) ;
    }

    public List<ContactUs> findAllOrderByDate() {
        return contactUsRepo.findAllByOrderByGeneratedDate();
    }

}