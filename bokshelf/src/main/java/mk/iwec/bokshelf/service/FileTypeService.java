package mk.iwec.bokshelf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mk.iwec.bokshelf.domain.FileType;

public class FileTypeService {
	private static final Map<Integer, FileType> fileTypes = new TreeMap<>();

	public FileType findById(Integer id) {
		return (id == null) ? null : fileTypes.get(id);
	}

	public List<FileType> getFileTypesById() {
		List<FileType> fileTypeList = new ArrayList<>(fileTypes.values());
		return fileTypeList;
	}

	public Integer saveOrUpdate(FileType fileType) {
		Integer key = (fileType == null || fileType.getId() == null) ? fileTypes.size() + 1 : fileType.getId();
		fileType.setId(key);
		fileTypes.put(key, fileType);
		return fileType.getId();
	}

	public boolean delete(Integer id) {
		FileType fileType = fileTypes.remove(id);
		return (fileType != null) ? true : false;
	}
}
