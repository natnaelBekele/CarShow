package com.binary.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerId;
    private String firstName,lastname;
   // @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Car> cars;

    public Owner() {

    }
    public Owner(Long ownerId, String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.ownerId = ownerId;
    }
    public Owner(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }
}
