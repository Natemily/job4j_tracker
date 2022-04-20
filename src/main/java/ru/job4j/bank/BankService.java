package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает добавление пользователя или его счет в систему, поиск по номеру паспорта
 * или счета, а так же перевод с одного счета на другой
 * @author Nerezko Natalia
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя и создает ему список счетов
     * @param user - пользователь, которого необходимо добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет пользователю, предварительно проверяя наличие пользователя
     * через поиск по паспорту,а так же отсутсиве у него данного счета.
     * @param passport - паспорт пользователя;
     * @param account - счет пользователя, который необходимо добавить.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     *Метод ищет пользователя по номеру паспорта, сравнивая паспорта в списке с входящим значением
     * @param passport - паспорт пользователя
     * @return возвращает пользователя User, если найден и null, если нет.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst();
    }

    /**
     *Метод проводит поиск счета пользователя по номеру его паспорта и реквизитам счета
     * @param passport - паспорт владельца счета;
     * @param requisite - реквизит счета, который необходимо найти
     * @return возвращает счет типа Account, если счет найден или null, если нет.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(value -> value.getRequisite().equals(requisite))
                    .findFirst();
        }
        return null;
    }

    /**
     *Метод принимает на вход паспорта и счета отправителя и получателя, а так же сумму перевода,
     * проверяет наличие счетов и необходимого количества стредств на счете отправителя.
     * Затем делает перевод
     * @param srcPassport - паспорт отправителя;
     * @param srcRequisite - счет отправителя;
     * @param destPassport - паспорт получателя;
     * @param destRequisite - счет получателя;
     * @param amount - сумма перевода.
     * @return возвращает true, если перевод удался и false - если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}