import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    List<CartItem>items=new ArrayList<CartItem>();
    public List<CartItem>getItems(){
        return items;
    }
    public void setItems(List<CartItem>items){
        this.items=items;
    }
    public void add(CartItem ci){
        for(Iterator<CartItem>iter=items.iterator();iter.hasNext();){
            CartItem item=iter.next();
            if(item.getProduct().getID()==ci.getProduct().getID()){
                item.setCount(item.getCount()+1);
                return;
            }
        }
        items.add(ci);
    }
    public double getTotalPrice(){
        double d=0.0;
        for(Iterator<CartItem>it=items.iterator();it.hasNext();){
            CartItem current=it.next();
            d+=current.getProduct().getPrice()*current.getCount();
        }
        return d;
    }
    public void deleteItemByID(String productID){
        for(Iterator<CartItem>iter=items.iterator();iter.hasNext();){
            CartItem item=iter.next();
            if(item.getProduct().getID().equals(productID)){
                iter.remove();
                return;
            }
        }
    }
}
