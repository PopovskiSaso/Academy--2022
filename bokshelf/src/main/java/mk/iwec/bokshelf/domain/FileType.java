package mk.iwec.bokshelf.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class FileType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@Column(name = "short_name", length = 50, nullable = false)
	private String shortName;

	public FileType() {
		super();
	}

	public FileType(String name, String shortName) {
		super();
		this.name = name;
		this.shortName = shortName;
	}

	public FileType(Integer id, String name, String shortName) {
		super();
		this.id = id;
		this.name = name;
		this.shortName = shortName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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
		FileType other = (FileType) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "FileType [id=" + id + ", name=" + name + ", shortName=" + shortName + "]";
	}
}
