package dat.carport.model.entities.DBEntities;

import java.util.Objects;

public class DBCustomer {
    private String userEmail;
    private String firstName;
    private String lastName;
    private String address;
    private String zipcode;
    private String city;
    private String phone;


    public DBCustomer(String userEmail, String firstName, String lastName, String address, String zipcode, String city, String phone) {
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBCustomer that = (DBCustomer) o;
        return Objects.equals(userEmail, that.userEmail) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(zipcode, that.zipcode) && Objects.equals(city, that.city) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, firstName, lastName, address, zipcode, city, phone);
    }

    @Override
    public String toString() {
        return "DBCustomer{" +
                "userEmail='" + userEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
