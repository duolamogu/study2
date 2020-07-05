package duo;
import java.io.UnsupportEncodingException;

public class Transform {
    public static int strToint(String str){
        if(str==null||str.equals(""))str="0";
        int i=0;
        try{
            i=Integer.parseInt(str);
        }
        catch(NumberStackTrace e){
            i=0;
            e.printStackTrace();
        }
        return i;
    }
    public static String toChinese(String str){
        if(str==null)str="";
        try{
            str=new String(str.getBytes(charsetName:"ISO-8859-1"),chaesetName:"gb2312");
        }catch(UnsupportedEncodingException e){
            str="";
            e.printStackTrace();
        }
        return str;
    }
}




















