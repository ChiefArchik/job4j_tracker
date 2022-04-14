package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу простой банковской системы.
 * @author DMITRY ARTAMONOV
 *  * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Регистрация пользователя.
     * Метод принимает обект User и добавляет его в список пользователей.
     * @param user объект добавляемый в список.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавление пользователю банковского счета.
     * Метод принимает уникальный ключ пользователя,
     * выполняет поиск пользователя в системе,
     * присваивает пользователю новый счет.
     * @param passport ключ для поиска пользователя в системе.
     * @param account имя банковского счета.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> findedUser = findByPassport(passport);
        if (findedUser.isPresent()) {
            List<Account> accounts = users.get(findedUser.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает уникальный ключ пользователя,
     * выполняет поиск пользователя в системе.
     * @param passport ключ для поиска пользователя в системе.
     * @return результат поиска (пользователь которому принадлежит ключ либо null)
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск счета по реквизитам (имени счета) в списке счетов указанного пользователя.
     * @param passport ключ для поиска пользователя в системе.
     * @param requisite реквизиты счета для поиска его в списке счетов пользователя.
     * @return результат  поиска (счет пользователя либо null).
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> findedUser = findByPassport(passport);
        return findedUser.flatMap(user -> users.get(user)
                .stream()
                .filter(u -> u.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод описывает порядок перевода средств между счетами пользователей.
     * Определяет возможность выполнения перевода средств,
     * и производит операции списания и зачисления средств.
     * @param srcPassport ключ для поиска пользователя который переводит средства в системе.
     * @param srcRequisite реквизиты счета с которого средства будут списаны.
     * @param destPassport ключ для поиска пользователя который получает средства в системе.
     * @param destRequisite реквизиты счета на который сркдства будут зачислены.
     * @param amount сумма перевода.
     */
    public void transferMoney(String srcPassport, String srcRequisite,
                              String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount  = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        }
    }
}
