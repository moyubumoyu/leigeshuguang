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
			this.callToNumbers.add(this.callTo);
			this.communicationRecords.add(this.phoneNumber + 
					"," + timeStart + 
					"," + timeEnd + 
					"," + this.callTo+
					";");
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
		double feePerMinute = YRate.getRatio();
		//ͨ���������������������
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}
	
	//��ӡͨ����¼
	public void printDetails() {
		Iterator it = this.communicationRecords.iterator();
		
		while(it.hasNext()) {
			System.out.println("---------ͨ����¼�ָ���---------");
			
			String [] recordField = ((String) it.next()).split(",");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[1]));
			Date timeEnd = new Date(Long.parseLong(recordField[2]));
			//DateFormat mediumFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
			//DateFormat
			
			//SimpleDateFormat			
			System.out.println("ͨ����ʼʱ�䣺" + simpleDateFormat.format(timeStart));
			System.out.println("ͨ������ʱ�䣺" + simpleDateFormat.format(timeEnd));
			
			System.out.println("�Ʒѣ�" 
					+ accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2]))
					+ " Ԫ��");
		}
	}
}


