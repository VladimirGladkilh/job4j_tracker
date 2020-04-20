package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User find = users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport)).findFirst().orElse(null);

        return find;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account find = null;
        if (user != null) {
            find = users.get(user).stream()
                .filter(account -> account.getRequisite().equals(requisite)).findFirst().orElse(null);
        }
        return find;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, dеstRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcMoney = srcAccount.getBalance();
            double destMoney = destAccount.getBalance();
            if (srcMoney <= amount) {
                srcAccount.setBalance(srcMoney-amount);
                destAccount.setBalance(destMoney+amount);
                rsl = true;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}