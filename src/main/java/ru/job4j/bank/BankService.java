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
        User findedUser = findByPassport(passport);
        if (findedUser != null) {
            List<Account> accounts = users.get(findedUser);
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
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Поиск счета по реквизитам (имени счета) в списке счетов указанного пользователя.
     * @param passport ключ для поиска пользователя в системе.
     * @param requisite реквизиты счета для поиска его в списке счетов пользователя.
     * @return результат  поиска (счет пользователя либо null).
     */
    public Account findByRequisite(String passport, String requisite) {
        User findedUser = findByPassport(passport);
        Account rsl = null;
        if (findedUser != null) {
            List<Account> accounts = users.get(findedUser);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
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
     * @return возвращает резульнат опрации перевода (выполнен или нет)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount  = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
