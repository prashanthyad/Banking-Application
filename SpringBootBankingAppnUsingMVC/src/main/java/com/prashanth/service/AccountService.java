package com.prashanth.service;

import com.prashanth.model.Account;

public interface AccountService 
{
  public Account saveAccount(Account account);
  public Account getAccount(int acc_no);
  public Account depositAccount(int acc_no, String name,String password,double amount);
  public Account withdrawAccount(int acc_no, String name,String password,double amount);
  public Account transferAccount(int acc_no, int tacc_no,String name,String password,double amount);
  public String closeAccount(int acc_no,String name,String password);
}
