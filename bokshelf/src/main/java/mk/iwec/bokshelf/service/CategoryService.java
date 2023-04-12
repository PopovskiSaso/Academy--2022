package mk.iwec.bokshelf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mk.iwec.bokshelf.domain.Category;

public class CategoryService {
	private static final Map<Integer, Category> categories = new TreeMap<>();

	public Category findById(Integer id) {
		return (id == null) ? null : categories.get(id);
	}

	public List<Category> getCategoriesById() {
		List<Category> categoriesList = new ArrayList<>(categories.values());
		return categoriesList;
	}

	public Integer saveOrUpdate(Category category) {
		Integer key = (category == null || category.getId() == null) ? categories.size() + 1 : category.getId();
		category.setId(key);
		categories.put(key, category);
		return category.getId();
	}

	public boolean delete(Integer id) {
		Category author = categories.remove(id);
		return (author != null) ? true : false;
	}
}
