package com.prashanth.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashanth.model.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
