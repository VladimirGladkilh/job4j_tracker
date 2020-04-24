package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> opt = findByPassport(passport);
        if (opt.isPresent()) {
            List<Account> list = users.get(opt.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> opt = Optional.ofNullable( users.keySet().stream()
                .filter(user -> user.getPassport()
                        .equals(passport))
                        .findFirst().orElse(null));
        return opt;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> opt = findByPassport(passport);
        Optional<Account> find = Optional.empty();
        if (opt.isPresent()) {
            find = Optional.ofNullable(users.get(opt.get()).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst().orElse(null));
        }
        return find;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, dеstRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            double srcMoney = srcAccount.get().getBalance();
            double destMoney = destAccount.get().getBalance();
            if (srcMoney <= amount) {
                srcAccount.get().setBalance(srcMoney-amount);
                destAccount.get().setBalance(destMoney+amount);
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