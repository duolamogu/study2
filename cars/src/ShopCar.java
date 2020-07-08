
import java.util.ArrayList;


public class ShopCar {
    private ArrayList<GoodsSingle> buylist = new ArrayList<GoodsSingle>();

    public ArrayList<GoodsSingle> getBuylist() {
        return buylist;
    }

    /**
     * 向购物车中添加商品 参数single为GooleSigle类的对象
     */
    public void addItem(GoodsSingle single) {
        if (buylist.size() == 0) {
            GoodsSingle temp = new GoodsSingle();
            temp.setName(single.getName());
            temp.setNum(single.getNum());
            temp.setPrice(single.getPrice());
            buylist.add(temp);
        } else {
            int i = 0;
            // 遍历集合查看是否已经存在药品添加的商品
            for (; i < buylist.size(); i++) {
                GoodsSingle temp = (GoodsSingle) buylist.get(i);
                if (temp.getName().equals(single.getName())) {
                    temp.setNum(temp.getNum() + 1);
                    break;
                }
            }
            if (i > buylist.size()) {
                GoodsSingle temp = new GoodsSingle();
                temp.setName(single.getName());
                temp.setNum(single.getNum());
                temp.setPrice(single.getPrice());
                buylist.add(temp);
            }
        }
    }
    /**
     * 从购物车中移除指定的商品
     */
    public void removeItem(String name){
        for (int i = 0; i < buylist.size(); i++) {
            GoodsSingle temp=(GoodsSingle) buylist.get(i);
            if(temp.getName().equals(MyTools.toChinese(name))){
                if(temp.getNum()>1){
                    temp.setNum(temp.getNum()-1);
                    break;
                }
                else if(temp.getNum()==1){
                    buylist.remove(i);
                }
            }
        }

    }


    /**
     * 清空购物车
     */
    public void clearCar(){
        buylist.clear();
    }
}
