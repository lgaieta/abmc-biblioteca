/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Luciano
 */
public class Book {
    public Integer id;
    public String name;
    public String author;
    public String description;
    public String tag;
    
    public Book(Integer id, String name, String author, String description, String tag) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.tag = tag;
    }
}
