package dat.carport.model.entities.ServiceEntities;

import dat.carport.model.entities.DBEntities.DBCustomer;

import java.util.Objects;

public class Customer {

    String email;
    String firstName;
    String lastName;
    String address;
    String zipCode;
    String city;
    String phoneNumber;

    public Customer(String email, String firstName, String lastName, String address, String zipCode, String city, String phoneNumber) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }


    public Customer(DBCustomer dbc){
        this.email = dbc.getUserEmail();
        this.firstName = dbc.getFirstName();
        this.lastName = dbc.getLastName();
        this.address = dbc.getAddress();
        this.zipCode = dbc.getZipcode();
        this.city = dbc.getCity();
        this.phoneNumber = dbc.getPhone();
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return zipCode == customer.zipCode && phoneNumber == customer.phoneNumber && email.equals(customer.email) && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && address.equals(customer.address) && city.equals(customer.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, lastName, address, zipCode, city, phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", zipCode=" + zipCode +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
