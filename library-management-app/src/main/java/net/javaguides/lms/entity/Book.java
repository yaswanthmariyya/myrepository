package net.javaguides.lms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", borrowed=" + borrowed + ", borrowedBy="
				+ borrowedBy + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isBorrowed() {
		return borrowed;
	}
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	public User getBorrowedBy() {
		return borrowedBy;
	}
	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}
	private String title;
    private String author;
    private boolean borrowed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;
}
