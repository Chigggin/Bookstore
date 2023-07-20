package Assignment.Bookstore.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthorDto {

    private String name;

    private LocalDate birthday;

}
