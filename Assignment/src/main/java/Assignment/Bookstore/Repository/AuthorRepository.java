package Assignment.Bookstore.Repository;

import Assignment.Bookstore.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

        @Query(value = "SELECT * FROM Author WHERE name IN (:names)", nativeQuery = true)
        public List<Author> findByNames(List<String> names);

        @Query(value = "SELECT * FROM Author WHERE name = :name", nativeQuery = true)
        public List<Author> findByName(String name);

        @Query(value = "SELECT name FROM Author WHERE id IN (:ids) ", nativeQuery = true)
        public List<String> findAllNamesById(List<String> ids);


}
