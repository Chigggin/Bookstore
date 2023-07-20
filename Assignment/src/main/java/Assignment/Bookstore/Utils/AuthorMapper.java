package Assignment.Bookstore.Utils;

import Assignment.Bookstore.Dtos.AuthorDto;
import Assignment.Bookstore.Models.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper {


    public static AuthorDto toDto(Author author)
    {
        AuthorDto dto = new AuthorDto();
        dto.setName(author.getName());
        dto.setBirthday(author.getBirthday());

        return dto;
    }


    public static List<AuthorDto> toDtos(List<Author> authors)
    {
        return authors.stream().map(author -> toDto(author)).collect(Collectors.toList());
    }

    public static Author toEntity(AuthorDto dto)
    {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBirthday(dto.getBirthday());
        return author;
    }
}
