package mk.iwec.bokshelf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;

import mk.iwec.bokshelf.domain.Book;
import mk.iwec.bokshelf.repository.BookRepository;

public class BookService {
	private static final Map<Integer, Book> books = new TreeMap<>();
	@Autowired
	public BookRepository repository;

	public Book findById(Integer id) {
		return (id == null) ? null : books.get(id);
	}

	public List<Book> getBooksOrderedById() {
		List<Book> bookList = new ArrayList<>(books.values());
		return bookList;
	}

	public Integer saveOrUpdate(Book book) {
		Integer key = (book == null || book.getId() == null) ? books.size() + 1 : book.getId();
		book.setId(key);
		books.put(key, book);
		return book.getId();
	}

	public boolean delete(Integer id) {
		Book book = books.remove(id);
		return (book != null) ? true : false;
	}
}
