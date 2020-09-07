package 客户信息管理软件;
/*
 * CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 * 本类封装一下信息：
 * - Customer[] customers: 用来保存客户对象的数组
 * - int total = 0: 记录已保存客户对象的数量
 * 
 * 该类种子少提供一下构造器和方法：
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
	
	// 构造器，用来初始化customers数组
	// toatalCustomer，指定customers数组的最大空间
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	
	// 将参数customer添加组中最后一个客户对象记录之后
	// customer，指定要添加的客户对象
	// 添加成功返回true；false表示数组已满，无法添加
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	
	// 修改指定索引位置的客户信息
	// 修改成功返回true；false修改失败
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index >= total) {
			return false;
		}
		
		customers[index] = cust;
		return true;
	}
	
	// 删除指定索引位置上的客户
	// true删除成功；false删除失败
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
	
	// 获取所有客户信息
	// 
	public Customer[] getAllCustomers() {
		
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	// 获取指定索引位置上的客户
	// 如果找到了元素，则返回；如果没有找到，则返回null
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total) {
			return null;
		}
		
		return customers[index];
	}
	
	// 获取存储客户的数量
	public int getTotal() {
		return total;
	}
}
