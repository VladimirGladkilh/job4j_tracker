package ru.job4j.stream;

import ru.job4j.lambda.Attachment;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        Comparator<Profile> comparator =  new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                int compare = o1.getAddress().compare(o1.getAddress(), o2.getAddress());//Integer.compare(o1.getAddress().hashCode(), o2.getAddress().hashCode());
                if (compare == 0) {
                    compare = Integer.compare(o1.getAddress().hashCode(), o2.getAddress().hashCode());//o1.getAddress().compare(o1.getAddress(), o2.getAddress());
                }
                return compare;
            }
        };
        List<Address> addresses = profiles.stream()
                .sorted(comparator)
                .map(Profile::getAddress).distinct()
                .collect(Collectors.toList());
        return addresses;
    }
}
