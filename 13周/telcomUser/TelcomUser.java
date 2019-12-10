package telcomUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class TelcomUserBasedOnCollection {
	
	private String phoneNumber;
	private String callTo;
	private LinkedList communicationRecords;
	
	private ArrayList communication;
	private HashMap singleRecord;
	
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
			this.singleRecord = new HashMap();
			this.singleRecord.put("主叫",this.phoneNumber);
			this.singleRecord.put("开始时间", new Date(timeStart));
			this.singleRecord.put("结束时间", new Date(timeEnd));
			this.singleRecord.put("被叫号码", this.callTo);
			this.singleRecord.put("计费", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
			
			
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
		double feePerMinute = 0.2;
		//通话分钟数按四舍五入计算
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	//打印通话记录
	public void printDetails() {
		Iterator itRecords = this.communicationRecords.iterator();
		
		while(itRecords.hasNext()) {
			System.out.println("---------通话记录分割线---------");
			
			this.singleRecord = ((HashMap)itRecords.next());
			Set keySet = this.singleRecord.keySet();
			Iterator itKey = keySet.iterator();
			while(itKey.hasNext()){
				Object key = itKey.next();
				Object value = this.singleRecord.get(key);
				System.out.println(key + ":" + value);
			}
		}
	}
}


