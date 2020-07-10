package b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import b.domain.Book;
public class MyCart {//我的购物车
	HashMap<String ,Book> hm=new HashMap<String ,Book>();
	public void addBook(String id){//添加书
		if(hm.containsKey(id)){
			Book book=hm.get(id);
			//曾经加过再加shoppingNum+1
			int shoppingNum=book.getShoppingNum();
			book.setShoppingNum(shoppingNum+1);
		}else{
			hm.put(id, new BookService().getBookById(id));
		}
	}
	public void delBook(String id){//删除书
		hm.remove(id);
	}
	public void updateBook(String id,String nums){//更新购物车
		Book book=hm.get(id);
		book.setShoppingNum(Integer.parseInt(nums));
	}
	public void clearBook(){//清空购物车
		hm.clear();
	}
	public ArrayList showMyCart(){//显示购物车所有商品
		ArrayList<Book> al=new ArrayList<Book>();
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			String id=(String)iterator.next();
			Book book=hm.get(id);
			al.add(book);
		}
		return al;
	}
	public float getTotalPrice(){//购物车总价格
		float totalPrice=0.0f;
		ArrayList<Book> al=new ArrayList<Book>();
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			String id=(String)iterator.next();
			Book book=hm.get(id);
			totalPrice+=(float)book.getPrice()*book.getShoppingNum();
	}
		return totalPrice;
	}
}
