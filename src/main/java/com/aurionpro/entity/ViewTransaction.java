package com.aurionpro.entity;

public class ViewTransaction {
	
	private Long senderaccNo;
	private String receiverAccNo;
	private String type;
	private int amount;
	private String date;
	
	public ViewTransaction(Long senderaccNo, String receiveraccountnum, String type, int amount, String date) {
		super();
		this.senderaccNo = senderaccNo;
		this.receiverAccNo = receiveraccountnum;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public Long getSenderaccNo() {
		return senderaccNo;
	}

	public void setSenderaccNo(Long senderaccNo) {
		this.senderaccNo = senderaccNo;
	}

	public String getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(String receiverAccNo) {
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
		return "ViewTransaction [senderaccNo=" + senderaccNo + ", receiverAccNo=" + receiverAccNo + ", type=" + type
				+ ", amount=" + amount + ", date=" + date + "]";
	}

	
}
