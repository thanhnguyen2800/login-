package vn.iotstar.services;

import vn.iotstar.models.Usermodel;

public interface IUserService {
	Usermodel login(String username, String password);
	
	Usermodel FindByUserName(String username);
}
