package edu.mum.framework.dao;

import edu.mum.framework.domain.ACredential;

public interface CredentialDao<T> extends Dao<T>{
	void update(ACredential credential);
	T findByUserName(String userName);
}
