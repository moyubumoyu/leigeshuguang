package telcomUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class TelcomUserBasedOnCollection {
	private String phoneNumber;
	private String callTo;
	private LinkedList communicationRecords;
	
	
	
	private HashSet callToNumbers;
	public TelcomUserBasedOnCollection(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new LinkedList();
		
		
	    	
	}
	
	//模拟通话记录的生成
	public void generateCommunicateRecord() {
		//随机生成通话记录数目
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//随机生成第i条通话记录
			
			Calendar cal = Calendar.getInstance();
			
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//获得对应毫秒
			long timeStart = cal.getTimeInMillis();
			//结束时间开始后的十分钟内随机的一个时间，至少一分钟
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			
			//被叫号码
			this.callTo = getCallToPhoneNumber();
			//插入通话记录
			this.callToNumbers.add(this.callTo);
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo+
					";");
		}
	}
	
	//随机生成被叫号码（后四位随机）并返回
	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
	
	//模拟计费办法，以字符串的形式返回保留4位小数的计费结果
	private String accountFee(long timeStart, long timeEnd) {
		
		//每分钟收费*元
		double feePerMinute = YRate.getRatio();
		//通话分钟数按四舍五入计算
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	//打印通话记录
	public void printDetails() {
		Iterator it = this.communicationRecords.iterator();
		
		while(it.hasNext()) {
			System.out.println("---------通话记录分割线---------");
			
			String [] recordField = ((String) it.next()).split(",");
			System.out.println("主叫：" + recordField[0]);
			System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			//DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
			//DateFormat
			
			//SimpleDateFormat			
			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " 元。");
		}
	}
}


