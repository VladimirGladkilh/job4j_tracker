package ru.job4j.stream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void testAddress() {
        Profile profile1 = new Profile();
        Address adr1 = new Address();
        adr1.setCity("Moskow");
        adr1.setStreet("Lenina");
        adr1.setHome(12);
        adr1.setApartment(2);
        profile1.setAddress(adr1);
        Profile profile2 = new Profile();
        Address adr2 = new Address();
        adr2.setCity("Ekaterinburg");
        adr2.setStreet("Lenina");
        adr2.setHome(10);
        adr2.setApartment(123);
        profile2.setAddress(adr2);
        Profile profile3 = new Profile();
        Address adr3 = new Address();
        adr3.setCity("Moskow");
        adr3.setStreet("Lenina");
        adr3.setHome(12);
        adr3.setApartment(2);
        profile3.setAddress(adr3);
        Profile profile4 = new Profile();
        Address adr4 = new Address();
        adr4.setCity("Abokan");
        adr4.setStreet("Tomina");
        adr4.setHome(10);
        adr4.setApartment(1);
        profile4.setAddress(adr4);
        List<Profile> listProfiles = new ArrayList<Profile>();
        listProfiles.add(profile1);
        listProfiles.add(profile2);
        listProfiles.add(profile3);
        listProfiles.add(profile4);


        List<Address> addresses = Profiles.collect(listProfiles);
        //addresses.forEach(System.out :: println);
        /*for (Address ad: addresses
             ) {
            System.out.println(ad.getCity() + " " +ad.getStreet()+" " +ad.hashCode());

        }*/
        assertThat(addresses.get(0).getCity() , is("Abokan"));
        assertThat(addresses.size() , is(3));
    }
}
