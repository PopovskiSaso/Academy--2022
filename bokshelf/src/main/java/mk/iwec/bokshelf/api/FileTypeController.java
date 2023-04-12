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

import mk.iwec.bokshelf.domain.FileType;
import mk.iwec.bokshelf.service.FileTypeService;

@RestController
@RequestMapping("api/v2/fileTypes")
public class FileTypeController {
	@Autowired
	private FileTypeService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FileType> getfileTypesById() {
		return service.getFileTypesById();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FileType> getById(@PathVariable(value = "id") Integer id) {
		FileType fileType = service.findById(id);
		HttpStatus status = fileType != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<FileType>(fileType, status);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Integer insert(@RequestBody FileType fileType) {
		return service.saveOrUpdate(fileType);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Integer update(@RequestBody FileType fileType) {
		return service.saveOrUpdate(fileType);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

	public HttpStatus delete(@PathVariable(value = "id") Integer id) {
		boolean isDeleted = service.delete(id);
		System.err.println("######" + isDeleted);
		return (isDeleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

	}
}
