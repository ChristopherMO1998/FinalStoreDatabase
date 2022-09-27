//package com.FinalStoreDatabase.entity;
//
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "orders")
//public class Orders {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "orderId")
//	private int orderId;
//
//	@JoinColumn(name = "customerId", referencedColumnName = "customer_id")
//	private Set<Customer> customerList;
//
//	public Set<Customer> getCustomerList() {
//		return customerList;
//	}
//
//	@JoinColumn(name = "productId", referencedColumnName = "product_id")
//	private Set<Product> productList;
//
//	public Set<Product> getProductList() {
//		return productList;
//	}
//
//	public Orders() {
//	}
//
//	public Orders(int orderId, Set<Customer> customerList, Set<Product> productList) {
//		this.orderId = orderId;
//		this.customerList = customerList;
//		this.productList = productList;
//	}
//
//	public int getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public void setCustomerList(Set<Customer> customerList) {
//		this.customerList = customerList;
//	}
//
//	public void setProductList(Set<Product> productList) {
//		this.productList = productList;
//	}
//
//	@Override
//	public String toString() {
//		return "Orders [orderId=" + orderId + ", customerList=" + customerList + ", productList=" + productList + "]";
//	}
//
//}
