package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     *Метод ищет пользователя по номеру паспорта, сравнивая паспорта в списке с входящим значением
     * @param passport - паспорт пользователя
     * @return возвращает пользователя User, если найден и null, если нет.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     *Метод проводит поиск счета пользователя по номеру его паспорта и реквизитам счета
     * @param passport - паспорт владельца счета;
     * @param requisite - реквизит счета, который необходимо найти
     * @return возвращает счет типа Account, если счет найден или null, если нет.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(value -> value.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}