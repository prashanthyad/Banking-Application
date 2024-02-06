package com.prashanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prashanth.model.Account;
import com.prashanth.service.AccountService;

@Controller
public class AccountController 
{
	@Autowired
	private AccountService service;
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	@RequestMapping("/newaccount")	
	public String Register()
	{
		return "registeraccount";
	}
	@RequestMapping("/register")
	public String accountRegister(Account account)
	{
		service.saveAccount(account);
		return "success";
	}
	@RequestMapping("/balance")
	public String Balance()
	{
		return "balance";
	}
	@RequestMapping("/getbalance")
	public String balanceEnquiry(int acc_no,ModelMap model)
	{
		model.put("account", service.getAccount(acc_no));
		return "accountbalance";
	}
    @RequestMapping("/deposit")
    public String Deposit()
    {
    	return "depositform";
    }
    @RequestMapping("/getdeposit")
    public String depositDetails(@RequestParam int acc_no,@RequestParam String name,@RequestParam String password,@RequestParam double amount,ModelMap model)
    {
    	model.put("account", service.depositAccount(acc_no, name, password, amount));
    	model.put("Amtt", amount);
    
    	return "depositresult";
    }
    @RequestMapping("/withdraw")
    public String Withdraw()
    {
    	return "withdrawform";
    }
    @RequestMapping("/getwithdraw")
    public String WithdrawDetails(@RequestParam int acc_no,@RequestParam String name,@RequestParam String password,@RequestParam double amount,ModelMap model)
    {
    	Account acc=service.withdrawAccount(acc_no, name, password, amount);
    	if(acc!=null)
    	{
    	   model.put("account",acc );
    	   model.put("Amt", amount);
    	   return "withdrawresult";
    	}
    	else 
    	{
    		return "Insufficientbalance";
    	}
    }
    @RequestMapping("/transfer")
    public String Transfer()
    {
    	return "transfer";
    }
    @RequestMapping("/gettransfer")
    public String transferDetails(@RequestParam int acc_no,@RequestParam int tacc_no,@RequestParam String name,@RequestParam String password,@RequestParam double amount,ModelMap model)
    {
    	Account acc=service.transferAccount(acc_no, tacc_no, name, password, amount);
    	if(acc!=null) 
    	{
    	model.put("account", service.getAccount(acc_no));
    	model.put("amount", amount);
    	model.put("acc1",service.getAccount(tacc_no));
    	return "transferresult";
    	}
    	else
    	{
    		return "invalidform";
    	}
    }
    
    @RequestMapping("/closeaccount")
    public String getCloseaccount()
    {
  	  return "CloseAccountform";
    }
    @RequestMapping("/closeA/C")
    public String closeAccount(@RequestParam int acc_no,@RequestParam String name,@RequestParam String password,ModelMap model)
    {
  	  String result=service.closeAccount(acc_no, name, password);
  	  model.put("result", result);
  	  return "closeaccresult";
    }
    
    @RequestMapping("/aboutus")
    public String aboutUs()
    {
    	return "aboutus";
    }
    
}



