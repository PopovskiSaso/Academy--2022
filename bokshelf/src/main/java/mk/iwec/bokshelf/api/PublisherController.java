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

import mk.iwec.bokshelf.domain.Publisher;
import mk.iwec.bokshelf.service.PublisherService;

@RestController
@RequestMapping("api/v2/publishers")
public class PublisherController {
	@Autowired
	private PublisherService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Publisher> getPublishersOrderedById() {
		return service.getPublishersOrderedById();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Publisher> getById(@PathVariable(value = "id") Integer id) {
		Publisher publisher = service.findById(id);
		HttpStatus status = publisher != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Publisher>(publisher, status);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Integer insert(@RequestBody Publisher publisher) {
		return service.saveOrUpdate(publisher);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Integer update(@RequestBody Publisher publisher) {
		return service.saveOrUpdate(publisher);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		boolean isDeleted = service.delete(id);
		System.err.println("######" + isDeleted);
		return (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

	}
}
