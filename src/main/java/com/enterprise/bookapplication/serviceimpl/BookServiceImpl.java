package com.enterprise.bookapplication.serviceimpl;



import com.enterprise.bookapplication.dao.AuthorDao;
import com.enterprise.bookapplication.dao.BookDao;
import com.enterprise.bookapplication.dao.CategoryDao;
import com.enterprise.bookapplication.dto.BookDto;
import com.enterprise.bookapplication.dto.BookResponse;
import com.enterprise.bookapplication.entity.Author;
import com.enterprise.bookapplication.entity.Book;
import com.enterprise.bookapplication.exceptions.ResourceNotFound;
import com.enterprise.bookapplication.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book books = this.modelMapper.map(bookDto, Book.class);
        Book savedbooks = this.bookDao.save(books);
        return this.modelMapper.map(savedbooks, BookDto.class);
    }

    @Override
    public BookDto getById(Integer id) {
        Book books = this.bookDao.findById(id).orElseThrow(() -> new ResourceNotFound("Books", id));
        return this.modelMapper.map(books, BookDto.class);
    }

    @Override
    public BookResponse
    getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDirec) {
        Sort sort = null;
        if (sortDirec.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Book> booksPage = this.bookDao.findAll(pageable);
        List<Book> booksList = booksPage.getContent();
        List<BookDto> list = booksList.stream().map(books -> this.modelMapper.map(books, BookDto.class)).collect(Collectors.toList());
        BookResponse bookResponse = new BookResponse();
        bookResponse.setContent(list);
        bookResponse.setPageNumber(booksPage.getNumber());
        bookResponse.setPageSize(booksPage.getSize());
        bookResponse.setTotalPages(booksPage.getTotalPages());
        bookResponse.setTotalElements(booksPage.getTotalElements());
        bookResponse.setLastPage(booksPage.isLast());


        return bookResponse;
    }

    @Override
    public BookDto updateBook(Integer id, BookDto bookDto) {
        Book books = bookDao.findById(id).orElseThrow(() -> new ResourceNotFound("Books", id));
        books.setTitle(bookDto.getTitle());
        books.setIsbn(bookDto.getIsbn());
        Book updatedBooks = bookDao.save(books);
        return this.modelMapper.map(updatedBooks, BookDto.class);
    }

    @Override
    public void deletebook(Integer id) {
        Book book = bookDao.findById(id).orElseThrow(() -> new ResourceNotFound("Books", id));
        this.bookDao.delete(book);
    }

    @Override
    public List<BookDto> findByAuthor(Integer id) {
       Author author= authorDao.findById(id).orElseThrow(() -> new ResourceNotFound("Author", id));
       List<Book>bookList=bookDao.findByAuthor(author);
        List<BookDto> bookDtos=bookList.stream()
                .map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtos;

    }

    @Override
    public List<BookDto> findByCategory(Integer id) {
//        Category category=categoryDao.findById(id).orElseThrow(() -> new ResourceNotFound("Author", id));
        List<BookDto>bookDtos=bookDao.findByCategoryId(id).stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
                return bookDtos;
    }


}
