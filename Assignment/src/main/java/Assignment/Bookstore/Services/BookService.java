package Assignment.Bookstore.Services;

import Assignment.Bookstore.Repository.AuthorRepository;
import Assignment.Bookstore.Utils.BookMapper;
import Assignment.Bookstore.Repository.BookRepository;
import Assignment.Bookstore.Dtos.BookDto;
import Assignment.Bookstore.Dtos.UpdateBookDto;
import Assignment.Bookstore.Models.Author;
import Assignment.Bookstore.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository repo;
    @Autowired
    AuthorRepository aRepo;

    public BookDto addBook(BookDto dto) throws Exception {
        List<Author> authors = new ArrayList<>();
        if(!dto.getAuthor().isEmpty()) {
             authors = aRepo.findByNames(dto.getAuthor());
            if(authors.size() != dto.getAuthor().size())
            {
                throw new Exception("Authors not found");
            }
        }
        List<String> ids = authors.stream().map(a -> a.getId().toString()).collect(Collectors.toList());
        return BookMapper.toDto(repo.save(BookMapper.toEntity(dto, ids)));
    }

    public BookDto updateBook(UpdateBookDto dto) throws Exception
    {
        Book book;
        try {
            book = repo.findBooksByIsbn(dto.getIsbn()).get(0);
        }catch(IndexOutOfBoundsException e)
        {
            throw new Exception("Book not found");
        }

        if(dto.getData().getIsbn()!= null && !dto.getData().getIsbn().isBlank())
        {
            if( repo.findBooksByIsbn(dto.getData().getIsbn()).size() > 0 && !book.getIsbn().equals(dto.getData().getIsbn()))
            {
                throw new Exception("Cannot update; ISBN existing");
            }
            book.setIsbn(dto.getData().getIsbn());
        }

        List<Author> authors = new ArrayList<>();
        if(dto.getData().getAuthor() != null && !dto.getData().getAuthor().isEmpty()) {
            authors = aRepo.findByNames(dto.getData().getAuthor());
            if(authors.size() != dto.getData().getAuthor().size())
            {
                throw new Exception("Authors not found");
            }
        }
        book.setGenre(dto.getData().getGenre() != null && dto.getData().getGenre().isBlank() ? dto.getData().getGenre() : book.getGenre());
        book.setTitle(dto.getData().getName() != null && dto.getData().getName().isBlank() ? dto.getData().getName() : book.getTitle());
        book.setYear(dto.getData().getYear() != null && dto.getData().getYear().isBlank() ? Integer.parseInt(dto.getData().getYear()) : book.getYear());
        book.setPrice(dto.getData().getPrice() != null && dto.getData().getPrice().isBlank()? Double.parseDouble(dto.getData().getPrice()) : book.getPrice());
        book.setAuthorIds(!authors.isEmpty() ? authors.stream().map(a -> a.getId().toString()).collect(Collectors.toList()): book.getAuthorIds());
        return BookMapper.toDto(repo.save(book));

    }

    public List<BookDto> findBooks(String title, String author) throws Exception {
        List<BookDto> dtos;

        if(title == null||title.isBlank() ) {
            throw new Exception("No query");
        }
        if(author== null || author.isBlank())
        {
            dtos  = BookMapper.toDtos(repo.findBooksByTitle(title)).stream().map(bookDto -> populateAuthorIdsWithNames(bookDto)).collect(Collectors.toList());
        }
        else
        {
            Author auth;
            try {
              auth =   aRepo.findByName(author).get(0);
            }catch(Exception e)
            {
                throw new Exception("Author does not exist");
            }
            dtos  = BookMapper.toDtos(repo.findBooksByAuthorAndTitle(auth.getId().toString(),title)).stream().map(bookDto -> populateAuthorIdsWithNames(bookDto)).collect(Collectors.toList());;
        }
        return dtos;
    }


    public Boolean deleteBook(String isbn) throws Exception {
        if(isbn!=null && !isbn.isBlank())
        {
            try {
                Book book = repo.findBooksByIsbn(isbn).get(0);
                repo.delete(book);
                return true;
            }catch(IndexOutOfBoundsException e) {
                throw new Exception("Book doesn't exist");
            }catch(Exception ex)
            {
                throw ex;
            }



        }
        return false;
    }


    private BookDto populateAuthorIdsWithNames(BookDto dto)
    {
        dto.setAuthor( aRepo.findAllNamesById(dto.getAuthor()));
        return dto;
    }

}
