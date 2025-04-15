package Siddhesh.Banking_App.repository;

import Siddhesh.Banking_App.entity.accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepository extends JpaRepository<accounts, Long>{
}
