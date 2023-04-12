package mk.iwec.bokshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import mk.iwec.bokshelf.domain.Author;
import mk.iwec.bokshelf.domain.Book;
import mk.iwec.bokshelf.domain.Category;
import mk.iwec.bokshelf.domain.FileType;
import mk.iwec.bokshelf.domain.Publisher;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@Entity
	public class Book {

		@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@JoinColumn(name = "author_id")
		private Author author;

		@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@JoinColumn(name = "publisher_id")
		private Publisher publisher;

		@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@JoinColumn(name = "fileType_id")
		private FileType fileType;

		@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@JoinColumn(name = "category_id")
		private Category category;
	}
}
