package edowl.Controller;


import edowl.Model.ContactUs;
import edowl.Model.ContactUs;
import edowl.Service.ContactUsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ContactUs")
@CrossOrigin
public class ContactUsController {
    private final ContactUsService contactUsService;

    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    @GetMapping
    public ResponseEntity<List<ContactUs>> getAllContactUs()
    {
        List<ContactUs> contactUss = contactUsService.findAllOrderByDate();
        return new ResponseEntity<>(contactUss, HttpStatus.OK); //ok is 200 status code
    }

    @PostMapping("/add")
    public ResponseEntity<ContactUs> addContactUs(@RequestBody ContactUs contactUs)
    {
        ContactUs newContactUs = contactUsService.addContactUs(contactUs);
        return new ResponseEntity<>(contactUs, HttpStatus.CREATED); //ok is 200 status code
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContactUs(@PathVariable("id") Long id)
    {
        ContactUs attempt = contactUsService.findContactUsById(id);
        contactUsService.deleteContactUs(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteContactUs()
    {
        List<ContactUs> attempt = contactUsService.findAll();
        for (int i = 0; i < attempt.size(); i++) {

            Long a = Long.valueOf(i);
            ContactUs current= attempt.get(i);
            contactUsService.deleteContactUs(current.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

