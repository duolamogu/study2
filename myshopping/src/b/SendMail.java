package b;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendMail {
	private MimeMessage mimeMsg;//邮件对象
	private Session session;
	private Properties props;
	private boolean needAuth=false;
	private String username="";
	private String password="";
	private Multipart mp;
	public SendMail(){
		createMimeMessage();
	}
	public SendMail(String smtp){
		setSmtpHost(smtp);
		createMimeMessage(); 
	}
	public void setSmtpHost(String hostName){
		System.out.println("设置系统属性：mail.stmp.host="+hostName);
		if(props==null) props=System.getProperties();
		props.put("mail.smtp.host",hostName);
	public boolean createMimeMessage(){
		try{
			System.out.println("获取邮件会话对象");
			session=Session.getDefaultInstance(props,null);
		}catch(Exception e){
			System.err.println("获取邮件会话对象错误"+e);
			return false;
		}
		System.out.println("准备创建MIME邮件对象");
		try{
			mimeMsg =new MimeMessage(session);
			mp=new MimeMultipart();
			return true;
		}catch(Exception e){
			System.err.println("创建MIME邮件对象失败"+e);
			return false;
		}
	}
	public void setNeedAnth(boolean need){
		System.out.println("设置smtp身份认证：mail.smtp.auth="+need);
		if(props==null) props=System.getProperties();
		if(need){
			props.put("mail.smtp.auth", "true");
		}else{
			props.put("mail.smtp.auth", false);
		}
	}
	public void setNamePass(String name,String pass){
		username=name;
		password=pass;
	}
	public boolean setSubject(String mailSubject){
		System.out.print("设置邮件主题");
		try{
			mimeMsg.setSubject(mailSubject);
			return true;
		}catch(Exception e){
			System.err.println("设置邮件主题发生错误");
			return false;
		}
	}
	public boolean setBody(String mailBody){
		try{
			BodyPart bp=new MimeBodyPart();
			bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=gb2312/>"+mailBody,"text/html;charset=gb2312");
			mp.addBodyPart(bp);
			
			return true;
		}catch(Exception e){
			System.err.println("发生错误"+e);
			return false;
		}
	}
	public boolean addFileAffix(String filename){
		System.out.println("增加邮件附件："+filename);
		try{
			
			BodyPart bp=new MimeBodyPart();
			FileDataSource fileds=new FileDataSource(filename);
			bp.setDataHandler(new DataHandler(fileds));
			bp.setFileName(fileds.getName());
			mp.addBodyPart(bp);
			return true;
		}catch(Exception e){
			System.err.println("增加邮件附件"+filename+"发生错误"+e);
			return false;
		}
	}
	public boolean setForm(String from){
		System.out.println("设置发信人");
		try{
			mimeMsg.setFrom(new InternetAddress(from));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean setTo(String to){
		if(to==null) return false;
		try{
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean setCopyTp(String copyto){
		if(copyto==null) return false;
		try{
			mimeMsg.setRecipients(Message.RecipientType.CC, (Address[])InternetAddress.parse(copyto));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean sendout(){
		try{
			mimeMsg.setContent(mp);
			System.out.println("正在发送邮件……");
			Session mailSession=Session.getInstance(props,null);
			Transport transport=mailSession.getTransport("smtp");
			transport.connect((String)props.get("mail.smtp.host"),username,password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			System.out.println("发送成功");
			transport.close();
			return true;
		}catch(Exception e){
			System.out.println("发送失败"+e);
			return false;
		}
	}
	public static void sendToSomebody(String mailbody,String title,String toEmail){
		SendMail themail=new SendMail("smtp.163.com");
		themail.setNeedAnth(true);
		if(themail.setSubject(title)==false) return;
		if(themail.setBody(mailbody)==false) return;
		if(themail.setTo(toEmail)==false) return;
		if(themail.setForm("285@163.com")==false) return;
		themail.setNamePass("285", "123456");
		if(themail.sendout()==false) return;
	}
}
