package com.niit.dao;

import com.niit.model.UserDetail;
import java.util.List;

public interface UserDetailDAO {

	public boolean registerUser(UserDetail userdetail);
	public boolean checkLogin(UserDetail userdetail);
	public boolean getUser(UserDetail loginname);
	public boolean updateUser(UserDetail user);
	public boolean deleteuser(UserDetail user);
	public List<UserDetail> listUsers();
	
	
	
	
}
