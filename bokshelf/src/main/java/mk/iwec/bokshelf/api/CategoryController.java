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

import mk.iwec.bokshelf.domain.Category;
import mk.iwec.bokshelf.service.CategoryService;
@RestController
@RequestMapping("api/v2/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Category> getCategoriesOrderedById() {
		return service.getCategoriesById();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getById(@PathVariable(value = "id") Integer id) {
		Category category = service.findById(id);
		HttpStatus status = category != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Category>(category, status);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Integer insert(@RequestBody Category category) {
		return service.saveOrUpdate(category);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Integer update(@RequestBody Category category) {
		return service.saveOrUpdate(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		boolean isDeleted = service.delete(id);
		System.err.println("######" + isDeleted);
		return (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

	}
}
