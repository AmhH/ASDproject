package edu.mum.framework.service.impl;

import java.util.List;

import edu.mum.framework.dao.CredentialDao;
import edu.mum.framework.domain.ACredential;
import edu.mum.framework.domain.concrete.Credential;
import edu.mum.framework.service.CredentialService;

public class CredentialServiceImpl<T> implements CredentialService<T> {
	private CredentialDao credentialDao;
	
	public CredentialServiceImpl(CredentialDao credentialDao){
		this.credentialDao=credentialDao;
	}

	@Override
	public boolean saveCredential(T credential) {
	  /*List<T> list= findAllCredential();
	  if(list.stream()
			  .anyMatch(x->(((ACredential)x).getPassword() .equals((ACredential)credential).getPassword())
			        && (((ACredential) x).getUserName().equals((ACredential)credential).getPassword())))*/
		credentialDao.add(credential);
		    return true;
		
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
		List<T> list= findAllCredential();
		System.out.println("list:   "+list);
	
		if(list.stream().anyMatch(x->((ACredential) x).getPassword().equals(password) && ((ACredential) x).getUserName().equals(userName)))
		    return true;
		return false;
				
	}

}
