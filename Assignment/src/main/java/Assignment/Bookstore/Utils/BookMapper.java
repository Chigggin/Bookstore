package Assignment.Bookstore.Utils;

import Assignment.Bookstore.Dtos.BookDto;
import Assignment.Bookstore.Models.Book;
import Assignment.Bookstore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {


    @Autowired
    AuthorRepository repo;

    public static BookDto toDto(Book book)
    {
        BookDto dto = new BookDto();
        dto.setIsbn(book.getIsbn());
        dto.setName(book.getTitle());
        dto.setPrice(Double.toString(book.getPrice()));
        dto.setYear(Integer.toString(book.getYear()));
        dto.setGenre(book.getGenre());
        dto.setAuthor(book.getAuthorIds());

        return dto;
    }


    public static List<BookDto> toDtos(List<Book> books)
    {
        return books.stream().map(book -> toDto(book)).collect(Collectors.toList());
    }

    public static Book toEntity(BookDto dto, List<String> authorIds)
    {
        Book book = new Book();
        book.setIsbn(dto.getIsbn());
        book.setPrice(Double.valueOf(dto.getPrice()));
        book.setTitle(dto.getName());
        book.setAuthorIds(authorIds);
        book.setGenre(dto.getGenre());
        book.setYear(Integer.valueOf(dto.getYear()));
        return book;
    }

}
