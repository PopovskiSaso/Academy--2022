package mk.iwec.bokshelf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mk.iwec.bokshelf.domain.Publisher;

public class PublisherService {
	private static final Map<Integer, Publisher> publishers = new TreeMap<>();

	public Publisher findById(Integer id) {
		return (id == null) ? null : publishers.get(id);
	}

	public List<Publisher> getPublishersOrderedById() {
		List<Publisher> publisherList = new ArrayList<>(publishers.values());
		return publisherList;
	}

	public Integer saveOrUpdate(Publisher publisher) {
		Integer key = (publisher == null || publisher.getId() == null) ? publishers.size() + 1 : publisher.getId();
		publisher.setId(key);
		publishers.put(key, publisher);
		return publisher.getId();
	}

	public boolean delete(Integer id) {
		Publisher publisher = publishers.remove(id);
		return (publisher != null) ? true : false;
	}
}
