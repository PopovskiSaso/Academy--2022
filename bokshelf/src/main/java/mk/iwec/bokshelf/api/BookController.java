package mk.iwec.bokshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mk.iwec.bokshelf.domain.Book;
import mk.iwec.bokshelf.service.BookService;

@RestController
@RequestMapping("api/v2/books")
public class BookController {

	@Autowired
	private BookService service;

	/*@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getBooksOrderedById() {
		return service.getBooksOrderedById();
	}*/

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getById(@PathVariable(value = "id") Integer id) {
		Book book = service.findById(id);
		HttpStatus status = book != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Book>(book, status);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Integer insert(@RequestBody Book book) {
		return service.saveOrUpdate(book);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Integer update(@RequestBody Book book) {
		return service.saveOrUpdate(book);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		boolean isDeleted = service.delete(id);
		System.err.println("######" + isDeleted);
		return (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

	}
}
