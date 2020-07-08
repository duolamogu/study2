import java.io.UnsupportedEncodingException;

public class MyTools {
    // 转换中文乱码的问题
    public static String toChinese(String str) {
        if (str == "")
            str = "";
        try {
            // 通过String类的构造方法，将指定的字符串转换成gbk编码
            str = new String(str.getBytes("iso-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str = "";
            e.printStackTrace();
        }
        return str;
    }
    //将String数据类型转换为int数据类型
    public static int strToint(String str){
        if(str==null||str.equals(""))
            str="0";
        int i=0;
        try {
            i=Integer.parseInt(str);
        } catch (NumberFormatException e) {
            i=0;
            e.printStackTrace();
        }
        return i;
    }

}
