package dat.carport.model.entities.DBEntities;

import java.util.Objects;

public class DBEmployee {

    private String userEmail;
    private String firstName;
    private String lastName;



    public DBEmployee(String userEmail, String firstName, String lastName) {
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
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

@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBEmployee that = (DBEmployee) o;
        return Objects.equals(userEmail, that.userEmail) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
        }

@Override
public int hashCode() {
        return Objects.hash(userEmail, firstName, lastName);
        }

@Override
public String toString() {
        return "DBEmployee{" +
        "userEmail='" + userEmail + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
        }
        }