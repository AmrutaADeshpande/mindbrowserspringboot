

package com.rts.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.auth.dal.ObjectDao;

import com.rts.bo.ManagerBo;
import com.rts.model.Manager;
import com.rts.service.ManagerService;
import com.rts.utility.SecurityPasswordUtility;

@Service
public class ManagerServiceImpl implements ManagerService {
	private static final Integer SIGN_UP = 1,SIGN_IN=0;
	@Autowired
	private ObjectDao objectDao;

	@Override
	public void signupManeger(ManagerBo managerBo) throws Exception {
		try
		{
			validateUserInfo(managerBo, SIGN_UP);
			String plainPass = managerBo.getPassword();
			String securedPass = SecurityPasswordUtility.generatePasswordHash(plainPass);
			String[] passArr = securedPass.split(":");
			String password = passArr[0];
			Manager manager=new Manager();			
			manager.setPassword(password);;
		    manager.setFirtName(managerBo.getFirtName());
			manager.setEmail(managerBo.getEmail());
			manager.setAddress(managerBo.getAddress());
			manager.setCompany(managerBo.getCompany());
			if (manager.getDobstr() != null && !manager.getDobstr().isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dob = sdf.parse(manager.getDobstr());
				manager.setDob(dob);
			}

			objectDao.saveObject(manager);
		}
		catch(Exception e)
		{
			throw e;
			
		}
	
	}
	
	
	private void validateUserInfo(ManagerBo managerBo, Integer flag) throws Exception {
		
		if(managerBo.getPassword() == null || managerBo.getPassword().isEmpty()) {
		throw new Exception("password cannot be null");	
		}
		
			if(managerBo.getEmail() != null && !managerBo.getEmail().isEmpty()) {
				Manager securityUserDB = objectDao.getObjectByParam(Manager.class, "email", managerBo.getEmail());
				if(securityUserDB != null) {
					throw new Exception("email cannot be null");
				}
			}
		}


	@Override
	public void loginManager(ManagerBo managerBo) throws Exception {
		try
		{
			validateUserInfo(managerBo, SIGN_IN);
			Manager manager=new Manager();		
			
			if (managerBo.getEmail() != null && !managerBo.getEmail().isEmpty()) {
				manager = objectDao.getObjectByParam(Manager.class, "email", managerBo.getEmail());
			} 
	
						objectDao.saveObject(manager);	
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	}
	


