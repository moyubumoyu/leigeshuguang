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
	
	//ģ��ͨ����¼������
	public void generateCommunicateRecord() {
		//�������ͨ����¼��Ŀ
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			//������ɵ�i��ͨ����¼
			
			Calendar cal = Calendar.getInstance();
			
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			//��ö�Ӧ����
			long timeStart = cal.getTimeInMillis();
			//����ʱ�俪ʼ���ʮ�����������һ��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			
			//���к���
			this.callTo = getCallToPhoneNumber();
			//����ͨ����¼
			this.singleRecord = new HashMap();
			this.singleRecord.put("����",this.phoneNumber);
			this.singleRecord.put("��ʼʱ��", new Date(timeStart));
			this.singleRecord.put("����ʱ��", new Date(timeEnd));
			this.singleRecord.put("���к���", this.callTo);
			this.singleRecord.put("�Ʒ�", this.accountFee(timeStart, timeEnd));
			this.communicationRecords.add(this.singleRecord);
			
			
		}
	}
	
	
	
	//������ɱ��к��루����λ�����������
	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
	
	//ģ��ƷѰ취�����ַ�������ʽ���ر���4λС���ļƷѽ��
	private String accountFee(long timeStart, long timeEnd) {
		
		//ÿ�����շ�*Ԫ
		double feePerMinute = 0.2;
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	//��ӡͨ����¼
	public void printDetails() {
		Iterator itRecords = this.communicationRecords.iterator();
		
		while(itRecords.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			
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


