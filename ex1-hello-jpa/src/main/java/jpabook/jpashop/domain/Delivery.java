package jpabook.jpashop.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private  Long id;

    @Embedded
    private Address address;
    private DeliveryStatus status;


    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Order order;
}
