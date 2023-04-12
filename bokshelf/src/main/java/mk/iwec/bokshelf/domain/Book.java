package mk.iwec.bokshelf.domain;

import java.util.Locale.Category;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Flow.Publisher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "title", length = 50, nullable = false)
	private String title;
	@Column(name = "subtitle", length = 50, nullable = false)
	private String subtitle;
	@Column(name = "edition_Number", length = 50, nullable = false)
	private Integer editionNumber;
	@Column(name = "copyright_Year", length = 50, nullable = false)
	private Integer copyrightYear;
	@Column(name = "cover_File_Name", length = 50, nullable = false)
	private String coverFileName;
	@Column(name = "ISBN", length = 50, nullable = false)
	private String isbn;
	@Column(name = "book_File_Name", length = 50, nullable = false)
	private String bookFileName;
	@Column(name = "publisher", length = 50, nullable = false)
	private Publisher publisher;
	@Column(name = "authors", length = 50, nullable = false)
	private Set<Author> authors;
	@Column(name = "categories", length = 50, nullable = false)
	private Set<Category> categories;
	@Column(name = "fileTypes", length = 50, nullable = false)
	private Set<FileType> fileTypes;
	@Column(name = "enabled", length = 50, nullable = false)
	private Boolean enabled = false;

	public Book() {
		super();
	}

	public Book(String title, String subtitle, Integer editionNumber, Integer copyrightYear, String coverFileName,
			String isbn, String bookFileName, Publisher publisher, Set<Author> authors, Set<Category> categories,
			Set<FileType> fileTypes, Boolean enabled) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.editionNumber = editionNumber;
		this.copyrightYear = copyrightYear;
		this.coverFileName = coverFileName;
		this.isbn = isbn;
		this.bookFileName = bookFileName;
		this.publisher = publisher;
		this.authors = authors;
		this.categories = categories;
		this.fileTypes = fileTypes;
		this.enabled = enabled;
	}

	public Book(Integer id, String title, String subtitle, Integer editionNumber, Integer copyrightYear,
			String coverFileName, String isbn, String bookFileName, Publisher publisher, Set<Author> authors,
			Set<Category> categories, Set<FileType> fileTypes, Boolean enabled) {
		super();
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.editionNumber = editionNumber;
		this.copyrightYear = copyrightYear;
		this.coverFileName = coverFileName;
		this.isbn = isbn;
		this.bookFileName = bookFileName;
		this.publisher = publisher;
		this.authors = authors;
		this.categories = categories;
		this.fileTypes = fileTypes;
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Integer getEditionNumber() {
		return editionNumber;
	}

	public void setEditionNumber(Integer editionNumber) {
		this.editionNumber = editionNumber;
	}

	public Integer getCopyrightYear() {
		return copyrightYear;
	}

	public void setCopyrightYear(Integer copyrightYear) {
		this.copyrightYear = copyrightYear;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookFileName() {
		return bookFileName;
	}

	public void setBookFileName(String bookFileName) {
		this.bookFileName = bookFileName;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<FileType> getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(Set<FileType> fileTypes) {
		this.fileTypes = fileTypes;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", subtitle=" + subtitle + ", editionNumber=" + editionNumber
				+ ", copyrightYear=" + copyrightYear + ", coverFileName=" + coverFileName + ", isbn=" + isbn
				+ ", bookFileName=" + bookFileName + ", publisher=" + publisher + ", authors=" + authors
				+ ", categories=" + categories + ", fileTypes=" + fileTypes + "]";
	}

}
