package ru.job4j.stream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void testOrderAddress() {
        Profile profile1 = new Profile(new Address("Moskow", "Lenina", 10, 20));
        Profile profile2 = new Profile(new Address("Ekaterinburg", "Butorina", 12, 210));
        Profile profile3 = new Profile(new Address("Moskow", "Lenina", 10, 20));
        Profile profile4 = new Profile(new Address("Abakan", "Zelenaya", 101, 20));
        List<Profile> listProfiles = Arrays.asList(profile1, profile2, profile3, profile4);
        List<Address> addresses = Profiles.collect(listProfiles);
        assertThat(addresses.get(0).getCity() , is("Abokan"));
    }

    @Test
    public void test3Address() {
        Profile profile1 = new Profile(new Address("Moskow", "Lenina", 10, 20));
        Profile profile2 = new Profile(new Address("Ekaterinburg", "Butorina", 12, 210));
        Profile profile3 = new Profile(new Address("Moskow", "Lenina", 10, 20));
        Profile profile4 = new Profile(new Address("Abakan", "Zelenaya", 101, 20));
        List<Profile> listProfiles = Arrays.asList(profile1, profile2, profile3, profile4);
        List<Address> listValid = Arrays.asList(profile4.getAddress(), profile2.getAddress(), profile1.getAddress());
        List<Address> addresses = Profiles.collect(listProfiles);
        assertThat(addresses.equals(listValid), is(true));
        //assertThat(addresses.size() , is(3));
    }
}
