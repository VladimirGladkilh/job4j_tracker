package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i ++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Значение не найдено");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] val = new String[] {"111", "222", "333"};
        try {
            indexOf(val, "5");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
