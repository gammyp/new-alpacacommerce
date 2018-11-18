package cf.alpaca202.Shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cf.alpaca202.Shopping.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}