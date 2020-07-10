package b.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import b.domain.Book;
public class MyCart {
	HashMap<String ,Book> hm=new HashMap<String ,Book>();
	public void addBook(String id){
		if(hm.containsKey(id)){
			Book book=hm.get(id);
			int shoppingNum=book.getShoppingNum();
			book.setShoppingNum(shoppingNum+1);
		}else{
			hm.put(id, new BookService().getBookById(id));
		}
	}
	public void delBook(String id){
		hm.remove(id);
	}
	public void updateBook(String id,String nums){
		Book book=hm.get(id);
		book.setShoppingNum(Integer.parseInt(nums));
	}
	public void clearBook(){
		hm.clear();
	}
	public ArrayList showMyCart(){
		ArrayList<Book> al=new ArrayList<Book>();
		Iterator iterator=hm.keySet().iterator();
		while(iterator.hasNext()){
			String id=(String)iterator.next();
			Book book=hm.get(id);
			al.add(book);
		}
		return al;
	}
	public float getTotalPrice(){
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
