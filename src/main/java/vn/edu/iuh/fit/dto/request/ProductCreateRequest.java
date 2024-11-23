package vn.edu.iuh.fit.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class ProductCreateRequest {
    @Column(name = "code", columnDefinition = "varchar(50)")
    private String code;
    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;
    @Column(name = "description", columnDefinition = "varchar(250)")
    private String description;
    @Column(name = "register_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_date;
    @Column(name = "price", columnDefinition = "varchar(50)")
    private double price;
}
