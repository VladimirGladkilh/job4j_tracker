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
        String[] abus = new String[] {"11", "222", "33"};
        process(val, "222", abus);
    }


    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {

        for (int i = 0; i < abuses.length; i ++) {
            if (abuses[i].equals(value)) {
                throw new ElementAbuseException("Найдено запрещенное значение");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
