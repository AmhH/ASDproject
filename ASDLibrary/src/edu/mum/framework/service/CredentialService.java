package edu.mum.framework.service;

import java.util.List;

import edu.mum.framework.domain.ACredential;

public interface CredentialService<T> {
	public boolean saveCredential(T credential);
	public void deleteCredential(T credential);
	public void updateCredential(ACredential credential);
	public T findCredentialByName(String username);
	public List<T> findAllCredential();
	public boolean login(String userName, String password);
}
