package Assignment.Bookstore.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class UpdateAuthorDto {

    String name;



    @Getter
    @Setter
    public class data{
        private String name;

        private LocalDate birthday;
    }


    data data;

}
