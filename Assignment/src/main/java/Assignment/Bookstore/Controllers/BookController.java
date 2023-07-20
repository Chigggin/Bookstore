package Assignment.Bookstore.Controllers;

import Assignment.Bookstore.Dtos.BookDto;
import Assignment.Bookstore.Services.BookService;
import Assignment.Bookstore.Dtos.UpdateBookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {


    @Autowired
    BookService service;

    @GetMapping("/find")
    public ResponseEntity<List<BookDto>> findBooks(@RequestParam String title, @RequestParam(required = false) String author) throws Exception {
        return ResponseEntity.ok().body( service.findBooks(title,author));
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) throws Exception {
        service.addBook(bookDto);
        return null;
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.PATCH},
            consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateBook(@RequestBody UpdateBookDto bookDto) throws Exception {
        service.updateBook(bookDto);
        return null;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SA')")
    public ResponseEntity<String> updateBook(@RequestParam String isbn) throws Exception {
        service.deleteBook(isbn);
        return null;
    }

}
