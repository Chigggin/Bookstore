package Assignment.Bookstore.Services;

import Assignment.Bookstore.Utils.AuthorMapper;
import Assignment.Bookstore.Repository.AuthorRepository;
import Assignment.Bookstore.Dtos.AuthorDto;
import Assignment.Bookstore.Dtos.UpdateAuthorDto;
import Assignment.Bookstore.Models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository repo;


    public Boolean addAuthor(AuthorDto dto) throws Exception {
        Author author = AuthorMapper.toEntity(dto);
        if(author.getName()==null || author.getName().isBlank())
        {
            throw new Exception("Author name cannot be null");
        }
        repo.save(author);
        return true;
    }


    public Boolean updateAuthor(UpdateAuthorDto dto) throws Exception
    {
        if(dto.getName() == null || dto.getName().isBlank())
        {
            throw new Exception("Name of author not specified/ cannot be blank");
        }

        List<Author> authors = repo.findByName(dto.getName());
        if(authors.size() > 1)
        {
            throw new Exception("Author is not unique");
        }
        if(authors.size() == 0)
        {
            throw new Exception("Author not found");
        }

        authors.get(0).setBirthday(dto.getData().getBirthday());
        authors.get(0).setName(dto.getData().getName());

        repo.save(authors.get(0));

        return true;
    }

    public Boolean deleteAuthor(String name) throws Exception {

        if(name != null && !name.isBlank()) {
            List<Author> author = repo.findByName(name);
            if(author.size() > 1)
            {
                throw new Exception("More than one author of the same name found");
            }
            if(author.size() == 0)
            {
                throw new Exception("Author does not exist");
            }
            repo.delete(author.get(0));
            return true;
        }
        return false;

    }



}
