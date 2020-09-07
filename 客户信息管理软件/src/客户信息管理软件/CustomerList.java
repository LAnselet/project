package �ͻ���Ϣ�������;
/*
 * CustomerListΪCustomer����Ĺ���ģ�飬�ڲ�ʹ���������һ��Customer����
 * �����װһ����Ϣ��
 * - Customer[] customers: ��������ͻ����������
 * - int total = 0: ��¼�ѱ���ͻ����������
 * 
 * �����������ṩһ�¹������ͷ�����
 * - public CustomerList(int totalCustomer)
 * - public boolean addCustomer(Customer customer)
 * - public boolean replaceCustomer(int index, Customer cust)
 * - public boolean deleteCustomer(int index)
 * - public Customer[] getAllCustomers()
 * - public Customer getCustomer(int index)
 * - public int getTotal()
 */
public class CustomerList {
	
	private Customer[] customers;
	private int total;
	
	// ��������������ʼ��customers����
	// toatalCustomer��ָ��customers��������ռ�
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	
	// ������customer����������һ���ͻ������¼֮��
	// customer��ָ��Ҫ��ӵĿͻ�����
	// ��ӳɹ�����true��false��ʾ�����������޷����
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	
	// �޸�ָ������λ�õĿͻ���Ϣ
	// �޸ĳɹ�����true��false�޸�ʧ��
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index >= total) {
			return false;
		}
		
		customers[index] = cust;
		return true;
	}
	
	// ɾ��ָ������λ���ϵĿͻ�
	// trueɾ���ɹ���falseɾ��ʧ��
	public boolean deleteCustomer(int index) {
		if(index < 0 || index >= 5) {
			return false;
		}
		
		for(int i = index; i < total - 1;i++) {
			customers[i] = customers[i + 1];
		}
		
//		customers[total - 1] = null;
//		total--;
//		return true;
		
		customers[--total] = null;
		return true;
	}
	
	// ��ȡ���пͻ���Ϣ
	// 
	public Customer[] getAllCustomers() {
		
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	// ��ȡָ������λ���ϵĿͻ�
	// ����ҵ���Ԫ�أ��򷵻أ����û���ҵ����򷵻�null
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total) {
			return null;
		}
		
		return customers[index];
	}
	
	// ��ȡ�洢�ͻ�������
	public int getTotal() {
		return total;
	}
}
