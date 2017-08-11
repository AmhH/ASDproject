package edu.mum.framework.service.impl;

import java.util.List;

import edu.mum.framework.dao.CredentialDao;
import edu.mum.framework.domain.ACredential;
import edu.mum.framework.service.CredentialService;

public class CredentialServiceImpl<T> implements CredentialService<T> {
	private CredentialDao credentialDao;
	
	public CredentialServiceImpl(CredentialDao credentialDao){
		this.credentialDao=credentialDao;
	}

	@Override
	public void saveCredential(T credential) {
		credentialDao.add(credential);
		
	}

	@Override
	public void deleteCredential(T credential) {
		credentialDao.remove(credential);
		
	}

	@Override
	public void updateCredential(ACredential credential) {
		credentialDao.update(credential);
		
	}

	@Override
	public T findCredentialByName(String username) {
		return (T) credentialDao.findByUserName(username);
	}

	@Override
	public List<T> findAllCredential() {
	    return credentialDao.findAll();
	}

	@Override
	public boolean login(String userName, String password) {
		/*List<T> list= findAllCredential();
		if(list.stream().anyMatch(x->x.getPassword().equals(password) && x.getUserName().equals(userName)))
		    return true;*/
		return false;
				
	}

}
