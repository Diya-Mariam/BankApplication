package com.aurionpro.entity;

public class ViewPassbook {
	
	private Long senderAccNo;
	private Long receiverAccNo;
	private String type;
	private int amount;
	private String date;
	
	public ViewPassbook(Long senderAccNo, Long receiverAccNo, String type, int amount, String date) {
		super();
		this.senderAccNo = senderAccNo;
		this.receiverAccNo = receiverAccNo;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public Long getSenderAccNo() {
		return senderAccNo;
	}

	public void setSenderAccNo(Long senderAccNo) {
		this.senderAccNo = senderAccNo;
	}

	public Long getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(Long receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ViewPassbook [senderAccNo=" + senderAccNo + ", receiverAccNo=" + receiverAccNo + ", type=" + type
				+ ", amount=" + amount + ", date=" + date + "]";
	}

	

}
