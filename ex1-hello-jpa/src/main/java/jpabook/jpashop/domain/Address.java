package jpabook.jpashop.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(length = 10)
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private String fullAddress() {
        return getCity() + " " + getStreet() + " " + getZipcode();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Address address)) {
            return false;
        }
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(
            getStreet(), address.getStreet()) && Objects.equals(getZipcode(),
            address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
