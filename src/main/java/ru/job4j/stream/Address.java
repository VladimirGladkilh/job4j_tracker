package ru.job4j.stream;

import ru.job4j.lambda.Attachment;

import java.util.Comparator;
import java.util.Objects;

public class Address implements Comparable{
    private String city;
    private String street;

    private int home;

    private int apartment;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

   /* @Override
    public int compare(Object o1, Object o2) {
        Address left = (Address) o1;
        Address rigth = (Address) o2;
        return left.getCity().compareTo(rigth.getCity());
    }*/

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return city.equals(address.getCity()) && street.equals(address.getStreet())
                && home == address.getHome() && apartment == address.getApartment();
    }

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public int compareTo(Object o) {
        return this.getCity().compareTo(((Address) o).getCity());
    }
}
