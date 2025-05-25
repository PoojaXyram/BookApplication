package com.enterprise.bookapplication.serviceimpl;




import com.enterprise.bookapplication.dao.AuthorDao;
import com.enterprise.bookapplication.dto.AuthorDto;
import com.enterprise.bookapplication.entity.Author;
import com.enterprise.bookapplication.exceptions.ResourceNotFound;
import com.enterprise.bookapplication.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = this.modelMapper.map(authorDto, Author.class);
        Author saveauthor = this.authorDao.save(author);
        return this.modelMapper.map(saveauthor, AuthorDto.class);
    }

    @Override
    public AuthorDto getById(Integer id) {
        Author authors = this.authorDao.findById(id).orElseThrow(() -> new ResourceNotFound("Authors", id));
        return this.modelMapper.map(authors, AuthorDto.class);
    }

    @Override
    public List<AuthorDto> getAll(Integer pageNumber, Integer pageSize) {

        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Author>authorsPage = this.authorDao.findAll(pageable);
        List<Author>authorsList=authorsPage.getContent();
        return authorsList.stream().map(authors -> this.modelMapper.map(authors, AuthorDto.class)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto updateAuthor(Integer id, AuthorDto authorDto) {
        Author authors = this.modelMapper.map(authorDto, Author.class);
        Author updateAuthor = this.authorDao.findById(id).orElseThrow(() -> new ResourceNotFound("Authors", id));
        updateAuthor.setNationality(authorDto.getNationality());
        Author updatedAuthor=this.authorDao.save(updateAuthor);
        return this.modelMapper.map(updatedAuthor, AuthorDto.class);

    }

    @Override
    public void deleteAuthor(Integer id) {
        Author authors = this.authorDao.findById(id).orElseThrow(() -> new ResourceNotFound("Authors", id));
        this.authorDao.delete(authors);
    }

}
