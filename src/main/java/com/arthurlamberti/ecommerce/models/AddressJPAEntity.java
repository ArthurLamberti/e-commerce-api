package com.arthurlamberti.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "addresses")
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressJPAEntity extends BaseEntity {

    @Id
    private String id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "numeral", nullable = false)
    private String numeral;

    @Column(name = "complement")
    private String complement;

//    @Column(name = "active")
//    private boolean active;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private CustomerJPAEntity customer;
//
//    @ManyToOne
//    @JoinColumn(name = "seller_id")
//    private SellerJPAEntity seller;
//
//    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
//    private List<ShippingJpaEntity> shipping;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
