package b.service;
import java.sql.ResultSet;
import java.util.ArrayList;

import b.domain.Users1;
import b.utils.SqlHelper;
import com.hsp.utils.*;
public class Users1Service {
	public boolean checkUser(Users1 user){
		String sql="select * from users1 where id=? and pwd=? ";
		String parameters[]={user.getId()+"",user.getPwd()};
		ArrayList al=new SqlHelper().executeQuery(sql, parameters);
		if(al.size()==0){
			return false;
		}else{
			Object [] objects=(Object[])al.get(0);
			user.setName((String)objects[1]);
			user.setEmail((String)objects[3]);
			user.setGrade(Integer.parseInt(objects[5].toString()));
			return true;
		}
	}
}
