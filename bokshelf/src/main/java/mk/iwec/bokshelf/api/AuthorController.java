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

import mk.iwec.bokshelf.domain.Author;
import mk.iwec.bokshelf.service.AuthorService;

@RestController
@RequestMapping("api/v2/authors")
public class AuthorController {
	@Autowired
	private AuthorService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Author> getAuthorsOrderedById() {
		return service.getAuthorsOrderedById();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Author> getById(@PathVariable(value = "id") Integer id) {
		Author author = service.findById(id);
		HttpStatus status = author != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Author>(author, status);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Integer insert(@RequestBody Author author) {
		return service.saveOrUpdate(author);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Integer update(@RequestBody Author author) {
		return service.saveOrUpdate(author);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		boolean isDeleted = service.delete(id);
		System.err.println("######" + isDeleted);
		return (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

	}
}
