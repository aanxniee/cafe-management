package com.cafe.com.cafe.modal;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

// p.category.id --> category is an object, category.id is its attribute
@NamedQuery(name = "Product.getAllProduct", query = "select new com.cafe.com.cafe.wrapper.ProductWrapper(p.id, p.name, p.description, p.price, p.status, p.category.id, p.category.name) from Product p")

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "product")
public class Product implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    // many to one --> one row in a table is mapped to multiple rows in another table
    @ManyToOne(fetch = FetchType.LAZY) // lazy = fetch data when needed
    @JoinColumn(name = "category_fk", nullable = false) // connect to category table via foreign key
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    private String status;
}
