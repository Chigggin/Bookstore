package Assignment.Bookstore.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookDto {

    private String name;

    private List<String> author;

    private String isbn;

    private String genre;

    private String price;

    private String year;

}
