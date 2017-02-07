package com.fortech.stm.persistence;

import java.sql.SQLException;

public interface UserCredentialsDAO {
	void save(UserCredentials userCredentials) throws SQLException;

	UserCredentials findUser(String username) throws SQLException;

}
