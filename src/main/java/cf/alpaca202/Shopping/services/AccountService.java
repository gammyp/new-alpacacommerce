package cf.alpaca202.Shopping.services;

import cf.alpaca202.Shopping.models.Account;
import cf.alpaca202.Shopping.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
