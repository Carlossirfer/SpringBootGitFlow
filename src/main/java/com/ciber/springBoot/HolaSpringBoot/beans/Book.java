/**
 * 
 */
package com.ciber.springBoot.HolaSpringBoot.beans;

/**
 * @author ciber
 *
 */
//comentario funcionalidad

public class Book {
    private Long id;
    private String title;
 
    
    public Book(Long id, String title) {
    	this.id = id;
		this.title = title;
	}
    
	public Book() {
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
 
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
