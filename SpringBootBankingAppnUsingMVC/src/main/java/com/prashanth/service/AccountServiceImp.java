package com.prashanth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanth.model.Account;
import com.prashanth.repo.AccountRepo;
@Service
public class AccountServiceImp implements AccountService 
{
	@Autowired
	private AccountRepo repo;

	@Override
	public Account saveAccount(Account account) 
	{
		Account acc=repo.save(account);
		return acc;
	}

	@Override
	public Account getAccount(int acc_no) 
	{
		Account get=repo.findById(acc_no).get();
		return get;
	}

	@Override
	public Account depositAccount(int acc_no,String name,String password,double amount) {
		Account acc=repo.findById(acc_no).get();
		int AccNo=acc.getAcc_no();
		String PassWord=acc.getPassword();
		String Name=acc.getName();
		double Amt=acc.getAmount();
		if(acc_no==AccNo && password.equals(PassWord) && name.equals(Name))
		{
			Amt=acc.getAmount()+amount;
		}
	    acc.setAmount(Amt);
	    repo.save(acc);
	    return acc;
	}

	@Override
	public Account withdrawAccount(int acc_no, String name, String password, double amount) 
	{
		Account acc=repo.findById(acc_no).get();
		int AccNo=acc.getAcc_no();
		String PassWord=acc.getPassword();
		String Name=acc.getName();
		double Amt=acc.getAmount();
		if(acc_no==AccNo && name.equals(Name) && password.equals(PassWord))
		{
			if(Amt<amount)
			{
				return null;
			}
		
		   else
		   {
			  Amt=Amt-amount;
		   }
		}
		acc.setAmount(Amt);
		repo.save(acc);
		return acc;
	}

	@Override
	public Account transferAccount(int acc_no, int tacc_no, String name, String password, double amount) 
	{
		Account acc=repo.findById(acc_no).orElse(null);
		Account acc1=repo.findById(tacc_no).orElse(null);
		
		if(acc!=null && acc1!=null)
		{
			if(acc.getPassword().equals(password) && acc.getName().equals(name))
			{
				double sourceAccountBalance=acc.getAmount();
				if(sourceAccountBalance>=amount)
				{
					double targetAccountBalance=acc1.getAmount()+amount;
					acc.setAmount(sourceAccountBalance-amount);
					acc1.setAmount(targetAccountBalance);
					repo.save(acc);
					repo.save(acc1);
					return acc1;
				}
				else
				{
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String closeAccount(int acc_no, String name, String password) 
	{
		
		Account acc=repo.findById(acc_no).get();
		if(acc!=null)
		{
		    if(acc.getAcc_no()==acc_no&&acc.getName().equals(name)&&acc.getPassword().equals(password))
		    {
		    	 acc.setAmount(0);
		    	 repo.save(acc);
	             return "Account closed successfully!";
	        }
	    }

	        return "Failed to close account. Please check your credentials.";
	    }
	}


