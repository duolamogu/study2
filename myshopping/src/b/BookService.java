package b;
import java.util.ArrayList;

import b.domain.Book;
import b.utils.SqlHelper;
import com.hsp.utils.*;
public class BookService {
	public ArrayList getAllBook(){
		String sql="select * from book where 1=?";
		String[] parameters={"1"};
		ArrayList al=new SqlHelper().executeQuery(sql, parameters);
		ArrayList<Book> newAl=new ArrayList<Book>();
		for(int i=0;i<al.size();i++){
			Object obj[]=(Object[])al.get(i);
			Book book=new Book();
			book.setId(Integer.parseInt(obj[0].toString()));
			book.setName(obj[1].toString());
			book.setAuthor(obj[2].toString());
			book.setPublishHouse(obj[3].toString());
			book.setPrice(Float.parseFloat(obj[4].toString()));
			book.setNuml(Integer.parseInt(obj[5].toString()));
			newAl.add(book);
		}
		return newAl;
	}
	public Book getBookById(String id){
		Book book=new Book();
		String sql="select * from book where id=?";
		String parameters[]={id};
		ArrayList al=new SqlHelper().executeQuery(sql, parameters);
		if(al.size()==1){
			Object[] obj=(Object[])al.get(0);
			book.setId(Integer.parseInt(obj[0].toString()));
			book.setName(obj[1].toString());
			book.setAuthor(obj[2].toString());
			book.setPublishHouse(obj[3].toString());
			book.setPrice(Float.parseFloat(obj[4].toString()));
			book.setNuml(Integer.parseInt(obj[5].toString()));
		}
		return book;
		
		
		
		
	}
}
