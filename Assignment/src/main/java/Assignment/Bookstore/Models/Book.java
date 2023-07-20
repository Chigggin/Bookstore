package Assignment.Bookstore.Models;

import javax.persistence.*;

import Assignment.Bookstore.Utils.ListConverter;
import org.hibernate.annotations.BatchSize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
@BatchSize(size = 100)
@Getter
@Setter
@NoArgsConstructor
public class Book {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ISBN")
	private String isbn;

	@Column(name= "TITLE")
	private String title;

	@Convert(converter = ListConverter.class)
	@Column(name = "Authors", nullable = false)
	private List<String> authorIds = new ArrayList<>();

	@Column(name = "YEAR")
	private int year;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "GENRE")
	private String genre;


}