 package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUser = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                findUser = user;
            }
        }
        if (findUser == null) {
            throw  new  UserNotFoundException("Пользователь не найден");
        }
        return findUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валиден, либо логин меньше 3 символов");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Me", true)
        };
        User user = null;
        try {
            user = findUser(users, "Me");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
}
