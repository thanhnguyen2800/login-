//package vn.iotstar.Dao.impl;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import vn.iotstar.Dao.IUserDao;
//import vn.iotstar.configs.DBConnectMySQL;
//import vn.iotstar.models.Usermodel;
//
//public class UserDaoImpl extends DBConnectMySQL implements IUserDao{
//	
//	public Connection conn = null;
//	public PreparedStatement ps = null;
//	public ResultSet rs = null;
//	
//	@Override
//	public List<Usermodel> findAll() {
////		String sql = "SELECT * FROM users ";
////		List<Usermodel> list = new ArrayList<Usermodel>();
////		try {
////		conn = new DBConnectMySQL().getConnection();
////		ps = conn.prepareStatement(sql);
////		rs = ps.executeQuery();
////		while (rs.next()) {
////			list.add(new Usermodel(
////				rs.getInt("idusers"),
////				rs.getString("username"),
////				rs.getString("email"),
////				rs.getString("password"),
////				rs.getString("fullname"),
////				rs.getString("images"),		
////				rs.getString("phone"),
////				rs.getInt("roleid"),
////				rs.getDate("createDate")));
////		return list;
////		  }
////		} catch (Exception e) {
////			e.printStackTrace();
////		
////		}
////		
//		
//		String sql = "SELECT * FROM users";
//		List<Usermodel> list = new ArrayList<>();
//		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
//		     PreparedStatement ps = conn.prepareStatement(sql);
//		     ResultSet rs = ps.executeQuery()) {
//
//		    while (rs.next()) {
//		        list.add(new Usermodel(
//		            rs.getInt("idusers"),
//		            rs.getString("username"),
//		            rs.getString("email"),
//		            rs.getString("password"),
//		            rs.getString("fullname"),
//		            rs.getString("images"),
//		            rs.getString("phone"),
//		            rs.getInt("roleid"),
//		            rs.getDate("createDate")
//		        ));
//		    }
//		    return list;
//		} catch (Exception e) {e.printStackTrace();
//			}
//
//		return null;
//	}
//
//	@Override
//	public Usermodel findById(int idusers) {
//		
//		String sql = "SELECT * FROM users WHERE idusers = ? ";
//		try {
//		conn = new DBConnectMySQL().getDatabaseConnection();
//		ps = conn.prepareStatement(sql);
//		ps.setInt(1, idusers);
//		rs = ps.executeQuery();
//		while (rs.next()) {
//		Usermodel user = new Usermodel();
//		user.setIdusers(rs.getInt("idusers"));
//		user.setEmail(rs.getString("email"));
//		user.setUsername(rs.getString("username"));
//		user.setFullname(rs.getString("fullname"));
//		user.setPassword(rs.getString("password"));
//		user.setImages(rs.getString("images"));
//		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
//		user.setPhone(rs.getString("phone"));
//		user.setCreateDate(rs.getDate("createDate"));
//		return user;}
//		} 
//			catch (Exception e) {e.printStackTrace();
//		
//		}
//		
//		
//		return null;
//	}
//
//	@Override
//	public void insert(Usermodel user) {
//		
//		String sql = "INSERT INTO users(id, username, password, images, fullname, email, phone, roleid, createDate) VALUES (?,?,?,?,?,?,?,?,?)";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, user.getIdusers());
//			ps.setString(2,user.getUsername());
//			ps.setString(3,user.getPassword());
//			ps.setString(4,user.getImages());
//			ps.setString(5,user.getFullname());
//			
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
////	public static void main(String[] args) {
////		UserDaoImpl userDao = new UserDaoImpl();
////		List<Usermodel> list = userDao.findAll();
////		
////		for(Usermodel user : list) {
////			System.out.println(user);
////			
////		}
////	}
//
//	@Override
//	public Usermodel findByUserName(String username) {
//		String sql = "SELECT * FROM users WHERE username = ? ";
//		try {
//		conn = new DBConnectMySQL().getDatabaseConnection();
//		ps = conn.prepareStatement(sql);
//		ps.setString(1, username);
//		rs = ps.executeQuery();
//		while (rs.next()) {
//		Usermodel user = new Usermodel();
//		user.setIdusers(rs.getInt("idusers"));
//		user.setEmail(rs.getString("email"));
//		user.setUsername(rs.getString("username"));
//		user.setFullname(rs.getString("fullname"));
//		user.setPassword(rs.getString("password"));
//		user.setImages(rs.getString("images"));
//		user.setRoleid(Integer.parseInt(rs.getString("roleid")));
//		user.setPhone(rs.getString("phone"));
//		user.setCreateDate(rs.getDate("createDate"));
//		return user;}
//		} 
//			catch (Exception e) {e.printStackTrace();
//		
//		}
//		return null;
//	}
//	@Override
//	public boolean insertUser(Usermodel user) {
//	    String sql = "INSERT INTO users(username, password, email) VALUES (?, ?, ?)";
//	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
//	         PreparedStatement ps = conn.prepareStatement(sql)) {
//	        ps.setString(1, user.getUsername());
//	        ps.setString(2, user.getPassword());
//	        ps.setString(3, user.getEmail());
//	        return ps.executeUpdate() > 0; // thành công trả về true
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return false; // thất bại trả về false
//	}
//	
//	@Override
//	public Usermodel checkLogin(String username, String password) {
//	    try {
//	        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
//	        PreparedStatement ps = conn.prepareStatement(sql);
//	        ps.setString(1, username);
//	        ps.setString(2, password);
//	        ResultSet rs = ps.executeQuery();
//
//	        if (rs.next()) {
//	            Usermodel user = new Usermodel();
//	            user.setUsername(rs.getString("username"));
//	            user.setPassword(rs.getString("password"));
//	            user.setEmail(rs.getString("email"));
//	            return user;
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return null;
//	}
//
//
//
//	
//	//test chương trình. Kích chuột phải chọn run as -> java application
//	   public static void main(String[] args) {
//		   try {
//			   IUserDao userDao = new UserDaoImpl();
//			   new DBConnectMySQL();
//			   System.out.println(userDao.findById(1));  
//		   }
//		   catch(Exception e) {
//			   e.printStackTrace();
//		   }
//	   }
//
//}

package vn.iotstar.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.Dao.IUserDao;
import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.models.Usermodel;

public class UserDaoImpl extends DBConnectMySQL  implements IUserDao {
	
	@Override
	public List<Usermodel> findAll() {
	    String sql = "SELECT * FROM users";
	    List<Usermodel> list = new ArrayList<>();
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            list.add(new Usermodel(
	                rs.getInt("idusers"),
	                rs.getString("username"),
	                rs.getString("email"),
	                rs.getString("password"),
	                rs.getString("fullname"),
	                rs.getString("images"),
	                rs.getString("phone"),
	                rs.getInt("roleid"),
	                rs.getDate("createDate")
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	@Override
	public Usermodel findById(int idusers) {
	    String sql = "SELECT * FROM users WHERE idusers = ? ";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, idusers);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Usermodel user = new Usermodel();
	            user.setIdusers(rs.getInt("idusers"));
	            user.setEmail(rs.getString("email"));
	            user.setUsername(rs.getString("username"));
	            user.setFullname(rs.getString("fullname"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setPhone(rs.getString("phone"));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public boolean insertUser(Usermodel user) {
	    String sql = "INSERT INTO users(username, password, email) VALUES (?, ?, ?)";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getEmail());
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public Usermodel findByUserName(String username) {
	    String sql = "SELECT * FROM users WHERE username = ? ";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Usermodel user = new Usermodel();
	            user.setIdusers(rs.getInt("idusers"));
	            user.setEmail(rs.getString("email"));
	            user.setUsername(rs.getString("username"));
	            user.setFullname(rs.getString("fullname"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setPhone(rs.getString("phone"));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public Usermodel checkLogin(String username, String password) {
	    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
	    try (Connection conn = DBConnectMySQL.getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Usermodel user = new Usermodel();
	            user.setIdusers(rs.getInt("idusers"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setEmail(rs.getString("email"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public void insert(Usermodel user) {
		// TODO Auto-generated method stub
		
	}
}


