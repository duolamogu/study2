import java.io.Serializable;

public class Product {
    private String id;//产品标识
    private String name;//产品名
    private String des;//产品描述
    private double price;//产品价格

    public Product() {
    }
        public void setID(String id){
            this.id=id;
        }
        public void setName(String name){
            this.name=name;
        }
        public void setDes(String des){
            this.des=des;
        }
        public void setPrice(double price){
            this.price=price;
        }
        public String getID(){
            return id;
        }
        public String getName(){
            return name;
        }
        public String getDes(){
            return des;
        }
        public double getPrice(){
            return price;
        }

}

