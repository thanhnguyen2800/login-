package vn.iotstar.services.impl;

import vn.iotstar.Dao.IUserDao;
import vn.iotstar.Dao.impl.UserDaoImpl;
import vn.iotstar.models.Usermodel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
    IUserDao userDao = new UserDaoImpl();
    
	@Override
	public Usermodel login(String username, String password) {
		Usermodel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public Usermodel FindByUserName(String username) {
		
		return userDao.findByUserName(username);
	}

	@Override
	public boolean insertUser(Usermodel user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}
	


}
