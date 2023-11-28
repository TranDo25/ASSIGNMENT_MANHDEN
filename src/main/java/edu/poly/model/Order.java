package edu.poly.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity @Table(name = "Orders")
public class Order implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;String username;
    String address;
    Boolean available;
    Boolean confirm;
    Double price;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createDate = new Date();
    @ManyToOne @JoinColumn(name="Account_id")
    Account account;
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
