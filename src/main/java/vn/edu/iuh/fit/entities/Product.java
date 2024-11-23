package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "code", columnDefinition = "varchar(50)")
    private String code;
    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;
    @Column(name = "description", columnDefinition = "varchar(250)")
    private String description;
    @Column(name = "register_date")
    private Date register_date;
    @Column(name = "price", columnDefinition = "varchar(50)")
    private double price;

    public Product(String code, String name, String description, Date register_date, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.register_date = register_date;
        this.price = price;
    }
}
