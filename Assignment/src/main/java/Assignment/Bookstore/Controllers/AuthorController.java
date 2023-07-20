package Assignment.Bookstore.Controllers;

import Assignment.Bookstore.Dtos.AuthorDto;
import Assignment.Bookstore.Services.AuthorService;
import Assignment.Bookstore.Dtos.UpdateAuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorService service;


    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) throws Exception {
        service.addAuthor(authorDto);
        return null;
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PATCH},
            consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateAuthor(@RequestBody UpdateAuthorDto authorDto) throws Exception {
        service.updateAuthor(authorDto);
        return null;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SA')")
    public ResponseEntity<String> deleteAuthor(@RequestParam String name) throws Exception {
        service.deleteAuthor(name);
        return null;
    }


}
