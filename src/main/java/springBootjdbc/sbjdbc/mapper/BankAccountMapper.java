package springBootjdbc.sbjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springBootjdbc.sbjdbc.modal.BankAccountInfo;

public class BankAccountMapper implements RowMapper<BankAccountInfo> {
	public static final String BASE_SQL ="SELECT ID, FULL_NAME, BALANE FROM BANK_ACCOUNT";
	
	@Override
	public BankAccountInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("ID");
		String fullName = rs.getString("FULL_NAME");
		double balance = rs.getDouble("BALANCE");
		
		return new BankAccountInfo(id, fullName, balance);
	}
}
