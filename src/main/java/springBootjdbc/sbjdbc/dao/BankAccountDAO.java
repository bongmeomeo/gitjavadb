package springBootjdbc.sbjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import springBootjdbc.sbjdbc.mapper.BankAccountMapper;
import springBootjdbc.sbjdbc.modal.BankAccountInfo;

public class BankAccountDAO extends JdbcDaoSupport{

	@Autowired
	public BankAccountDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<BankAccountInfo> getBankAccountInfo(){
		String sql = BankAccountMapper.BASE_SQL;
		
		Object[] params = new Object[] {};
		BankAccountMapper mapper = new BankAccountMapper();
		List<BankAccountInfo> list = this.getJdbcTemplate().query(sql,  params, mapper);
	
		return list;
	}
	
	public BankAccountInfo findBankAccount(Long id) throws EmptyResultDataAccessException {
		String sql = "SELECT ID, FULL_NAME, BALANCE FROM BANK_ACCOUNT WHERE ID = ?";
	
		Object[] param = new Object[] {};
		BankAccountMapper mapper = new BankAccountMapper();
	
		try {
			BankAccountInfo bankAccount = this.getJdbcTemplate().queryForObject(sql, param, mapper);
			return bankAccount;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
//	Add money
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(Long id , double amount) {
		BankAccountInfo accountInfo = this.findBankAccount(id);
		if (accountInfo == null) {
//			 Error Dont exist account
			
		} 
		double newBalance = accountInfo.getBalance() + amount;
		if ( newBalance <0) {
//			Error < 0 money
		}
		accountInfo.setBalance(newBalance);
//		update database
		String sqlUpdate ="update BANK_ACCOUNT set BALANCE = ? where ID = ?";
		this.getJdbcTemplate().update(sqlUpdate, accountInfo.getBalance(), accountInfo.getId());
		
	}
//	 Show money
	public void sendMoney(Long fromAccountId, Long ) {
		
	}
}
