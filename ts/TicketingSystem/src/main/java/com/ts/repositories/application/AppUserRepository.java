package com.ts.repositories.application;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;

import com.ts.models.app.AccessUser;


public interface AppUserRepository extends CrudRepository<AccessUser, Long> {
	
	/**
	 * Retrieve <code>User</code> from the data store by username.
	 *
	 * @param lastName
	 *            Value to search for
	 * @return a <code>Collection</code> of matching <code>User</code>s (or an
	 *         empty <code>Collection</code> if none found)
	 */
	AccessUser findByUsername(String username,String password) throws DataAccessException;
	
	AccessUser findByUsername(String username) throws DataAccessException;
}
