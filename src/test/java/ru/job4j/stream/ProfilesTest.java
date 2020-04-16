package ru.job4j.stream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void testAddress() {
        Profile newProfile = new Profile();
        Address adr = new Address();
        adr.setCity("Ekaterinburg");
        adr.setStreet("Lenina");
        adr.setHome(10);
        adr.setApartment(123);
        newProfile.setAddress(adr);
        List<Profile> listProfiles = new ArrayList<Profile>();
        listProfiles.add(newProfile);
        List<Address> addresses = Profiles.collect(listProfiles);
        //addresses.forEach(System.out :: println);
        assertThat(addresses.get(0).getCity() , is("Ekaterinburg"));
    }
}
