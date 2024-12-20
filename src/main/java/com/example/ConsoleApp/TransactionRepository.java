package com.example.ConsoleApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT customer_id,MAX(amount) " +
            "FROM transactions " +
            "WHERE customer_id = ?1 " +
            "GROUP BY customer_id;",
            nativeQuery = true)
    List<Object[]> selectQuery1(Integer customerId);

    @Query(value = "SELECT customer_id, @amount, count(@amount) " +
            "FROM transactions " +
            "WHERE customer_id= ?1 " +
            "GROUP BY customer_id, @amount " +
            "ORDER BY count(amount) DESC LIMIT 1;",
            nativeQuery = true)
    List<Object[]> selectQuery2(Integer customerId);
}
