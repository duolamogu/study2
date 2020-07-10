package b;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import b.domain.Book;
import b.domain.Users1;
import b.utils.DBUtil;
public class OrderService{
	private Connection ct=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	public void submitOrder(MyCart myCart,Users1 user){//下订单涉及两张表
		String sql="insert into orders values(orders_seq.nextval,?,?,sysdate)";
		try{
			ct= DBUtil.getConnection();
			ct.setAutoCommit(false);
			ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			ps=ct.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setFloat(2, myCart.getTotalPrice());
			ps.executeUpdate();
			sql="select orders_seq.currval from orders";
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			int orderId=0;
			if(rs.next()){
				orderId=rs.getInt(1);
			}
			ArrayList al=myCart.showMyCart();
			for(int i=0;i<al.size();i++){
				Book book=(Book)al.get(i);
				sql="insert into orderItem values(orderItem_seq.nextval,?,?,?)";
				ps=ct.prepareStatement(sql);
				ps.setInt(1, orderId);
				ps.setInt(2, book.getId());
				ps.setInt(3, book.getShoppingNum());
				ps.executeUpdate();
			}
			ct.commit();
		}catch(Exception e){
			try {
				ct.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			DBUtil.close(rs, ps, ct);
		}
	}
}
