package com.proyecto.ejercicio.infrastructure.output.repository;

import com.proyecto.ejercicio.infrastructure.output.repository.entity.AccountEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {

    @Query("SELECT a FROM AccountEntity a")
    List<AccountEntity> findAllAccounts();

    @Query("SELECT a FROM AccountEntity a WHERE a.id = :id")
    Optional<AccountEntity> findById(@Param("id") Integer id);

    @Transactional
    @Query("UPDATE AccountEntity a SET a.number = :number, a.type = :type, " +
           "a.initialBalance = :initialBalance, a.status = :status, a.customerId = :customerId " +
           "WHERE a.id = :id")
    void updateAccount(@Param("id") Integer id, 
                       @Param("number") String number, 
                       @Param("type") String type, 
                       @Param("initialBalance") Double initialBalance, 
                       @Param("status") Boolean status, 
                       @Param("customerId") Integer customerId);

    @Query("SELECT a FROM AccountEntity a WHERE a.customerId = :customerId")
    List<AccountEntity> findByCustomerId(@Param("customerId") Integer customerId);
}
