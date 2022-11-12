package com.travel.model;

public class Booking {

	private int cid;
	
	private int bid;
	
	private String conform;
	
	private int ticketno;
	
	
	
	
	@Override
	public String toString() {
		return 
				"CustomerId :"+cid+"\n"
			   +"BusId :"+bid+"\n"
			   +"Conformation : "+conform+"\n"
			   +"TicketNo :"+ticketno+"\n";
	}

	public Booking(int cid, int bid, String conform, int ticketno) {
		super();
		this.cid = cid;
		this.bid = bid;
		this.conform = conform;
		this.ticketno = ticketno;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getConform() {
		return conform;
	}

	public void setConform(String conform) {
		this.conform = conform;
	}

	public int getTicketno() {
		return ticketno;
	}

	public void setTicketno(int ticketno) {
		this.ticketno = ticketno;
	}
	
	
	
}
