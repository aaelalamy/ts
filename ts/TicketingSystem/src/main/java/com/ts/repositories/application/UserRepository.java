package com.ts.repositories.application;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.ts.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	/**
	 * Retrieve <code>User</code> from the data store by username.
	 *
	 * @param lastName
	 *            Value to search for
	 * @return a <code>Collection</code> of matching <code>User</code>s (or an
	 *         empty <code>Collection</code> if none found)
	 */
	User findByUsernameAndPassword(String username,String password) throws DataAccessException;
	
	User findByUsername(String username) throws DataAccessException;
}
