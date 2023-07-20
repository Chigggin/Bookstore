package Assignment.Bookstore.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Getter
@Setter
public class UpdateBookDto {

    String isbn;



    @Getter
    @Setter
    public class data{
        private String name;

        private ArrayList<String> author;

        private String isbn;

        private String genre;

        private String price;

        private String year;
    }


    data data;

}
