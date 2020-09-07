package �ͻ���Ϣ�������;
/*
 * CustomerViewΪ��ģ�飬����˵�����ʾ�ʹ����û�����
 * �����װ������Ϣ;
 * - CustomerList customerList = new CustomerList(10)
 * 		����������10���ͻ������CustomerList���󣬹����¸���Ա����ʹ�á�
 * ���������ṩ���·�����
 * - public void enterMainMenu()
 * - private void addNewCustomer()
 * - private void modifyCustomer()
 * - private void deleteCustomer()
 * - private void listAllCustomers()
 * - public static void main(String[] args)
 */
public class CustomerView {

	private CustomerList customerList = new CustomerList(10);
	
	public CustomerView() {
		Customer customer = new Customer("����", '��', 30, "010-56253825", "abc@email.com");
		customerList.addCustomer(customer);
		
	}
	
	// ��ʾ�ͻ���Ϣ�����������ķ���
	public void enterMainMenu() {
		
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("-------------------------�ͻ���Ϣ����ϵͳ-----------------------------");
			System.out.println("		           1.��ӿͻ�                                                                                   ");
			System.out.println("		           2.�޸Ŀͻ�                                                                                   ");
			System.out.println("		           3.ɾ���ͻ�                                                                                   ");
			System.out.println("		           4.�ͻ��б�                                                                                   ");
			System.out.println("		           5.�˳�                                                                                           ");
			System.out.println("		��ѡ��1-5��:                                               ");
			
			char menu = CMUtility.readMenuSelection();
			
			switch(menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.println("ȷ���Ƿ��˳���Y/N����");
				char isExit = CMUtility.readConfirmSelection();
				if(isExit == 'Y') {
					isFlag = false;
				}
			}
		}

	}
	
	// ��ӿͻ�����
	private void addNewCustomer() {
//		System.out.println("��ӿͻ�����");
		System.out.println("---------------------------�޸Ŀͻ�---------------------------------");
		
		System.out.println("������");
		String name = CMUtility.readString(10);
		
		System.out.println("�Ա�");
		char gender = CMUtility.readChar();
				
		System.out.println("���䣺");
		int age = CMUtility.readInt();
		
		System.out.println("�绰���룺");
		String phone = CMUtility.readString(13);
		
		System.out.println("�������䣺");
		String email = CMUtility.readString(30);
		
		// ���������ݷ�װ��������
		Customer customer = new Customer(name, gender, age, phone, email);
		
		boolean isSuccess = customerList.addCustomer(customer);
		if(isSuccess) {
			System.out.println("---------------------------������---------------------------------");
		}else {
			System.out.println("----------------------�ͻ�Ŀ¼���������ʧ��---------------------------------");
		}
	}
	
	// �޸Ŀͻ�����
	private void modifyCustomer() {
//		System.out.println("�޸Ŀͻ�����");
		System.out.println("---------------------------�޸Ŀͻ�---------------------------------");
		Customer cust;
		int number;
		
		for(; ;) {
			System.out.println("��ѡ���޸Ŀͻ���ţ�-1�˳�����");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			
			cust = customerList.getCustomer(number - 1);
			if(cust == null) {
				System.out.println("�޷��ҵ�ָ���ͻ���");
			}else {
				break;
			}
		}
		// �޸Ŀͻ���Ϣ
	
		System.out.println("����(" + cust.getName()+ "):");
		String name = CMUtility.readString(10, cust.getName());
		
		System.out.println("�Ա�(" + cust.getGender()+ "):");
		char gender = CMUtility.readChar(cust.getGender());
				
		System.out.println("����(" + cust.getAge()+ "):");
		int age = CMUtility.readInt(cust.getAge());
		
		System.out.println("�绰����(" + cust.getPhone()+ "):");
		String phone = CMUtility.readString(13, cust.getPhone());
		
		System.out.println("��������(" + cust.getEmail()+ "):");
		String email = CMUtility.readString(30, cust.getEmail());
		
		Customer newCust = new Customer(name, gender, age, phone, email);
		
		boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
		if(isReplaced) {
			System.out.println("---------------------------�޸����--------------------------------");
		}else {
			System.out.println("---------------------------�޸�ʧ��--------------------------------");
		}
	}
	
	// ɾ���ͻ�����
	private void deleteCustomer() {
//		System.out.println("ɾ���ͻ�����");
		System.out.println("---------------------------ɾ���ͻ�--------------------------------");
		int number;
		
		for(; ;) {

			System.out.println("��ѡ���޸Ŀͻ���ţ�-1�˳�����");
			number = CMUtility.readInt();
			
			if(number == -1) {
				return;
			}
			
			Customer customer = customerList.getCustomer(number - 1);
			if(customer == null) {
				System.out.println("�޷��ҵ��ͻ���");
			}else {
				break;
			}
		}
		
		// �ҵ�ָ���Ŀͻ�
		System.out.println("ȷ���Ƿ�ɾ��(Y/N)��");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete == 'Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number - 1);
			if(deleteSuccess) {
				System.out.println("---------------------------ɾ�����--------------------------------");
			}else {
				System.out.println("---------------------------ɾ��ʧ��--------------------------------");
			}
		}else {
			return;
		}
	}
	
	// ��ʾ�ͻ��б����
	private void listAllCustomers() {
//		System.out.println("��ʾ�ͻ��б����");
		System.out.println("---------------------------�ͻ��б�---------------------------------\n");
		
		if(customerList.getTotal() == 0) {
			System.out.println("û�пͻ���Ϣ��");
		}else {
			System.out.println("���\t����\t��\t����\t�绰\t\t����");
			Customer[] custs = customerList.getAllCustomers();
			for(int i = 0;i < custs.length;i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() +
				"\t" + cust.getAge() + "\t" + cust.getPhone()
				+ "\t" + cust.getEmail());
			}
		}
		
		System.out.println("--------------------------�ͻ��б����-------------------------------");
		
	}
	
	public static void main(String[] args) {
		
		CustomerView view = new CustomerView();
		
		view.enterMainMenu();
	}
}
