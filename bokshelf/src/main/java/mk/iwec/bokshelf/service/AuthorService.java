package mk.iwec.bokshelf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mk.iwec.bokshelf.domain.Author;

public class AuthorService {
	private static final Map<Integer, Author> authors = new TreeMap<>();

	public Author findById(Integer id) {
		return (id == null) ? null : authors.get(id);
	}

	public List<Author> getAuthorsOrderedById() {
		List<Author> authorsList = new ArrayList<>(authors.values());
		return authorsList;
	}

	public Integer saveOrUpdate(Author author) {
		Integer key = (author == null || author.getId() == null) ? authors.size() + 1 : author.getId();
		author.setId(key);
		authors.put(key, author);
		return author.getId();
	}

	public boolean delete(Integer id) {
		Author author = authors.remove(id);
		return (author != null) ? true : false;
	}
}
