package Assignment.Bookstore.Repository;

import java.util.List;


import Assignment.Bookstore.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "Select * from Book where title = :title ", nativeQuery = true)
    public List<Book> findBooksByTitle(String title);

    @Query(value = "Select * from Book where isbn = :title ", nativeQuery = true)
    public List<Book> findBooksByIsbn(String title);


    @Query(value = "Select * from Book where authors = :authors", nativeQuery = true)
    public List<Book> findBooksByAuthor(String authors);

    @Query(value = "Select * from Book where authors LIKE %:authors% AND title = :titles", nativeQuery = true)
    public List<Book> findBooksByAuthorAndTitle(String authors, String titles);


}
