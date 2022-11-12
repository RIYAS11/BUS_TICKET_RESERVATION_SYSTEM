package com.travel.model;

public class Bus_Details {

	private String BName;
	
	private int Bid;
	
	private String BFrom;
	
	private String BTo;
	
	private String BDeparture;
	
	private int TotalSeat;
	
	private int RemainingSeat;

	
	
	
	@Override
	public String toString() {
		return 
			     "BusName :"+BName+"\n"
				+"BusId : "+Bid+"\n"
				+"DepartureCity : "+BFrom+"\n"
				+"ArrivalCity :"+BTo+"\n"
				+"Bus Date And Time"+BDeparture+"\n"
				+"ToatalSeat : "+TotalSeat+"\n"
				+"RemainingSeat :"+RemainingSeat+"\n\n";
	}

	
	public Bus_Details(String bName, int bid, String bFrom, String bTo, String bDeparture, int totalSeat, int remainingSeat) {
		super();
		BName = bName;
		Bid = bid;
		BFrom = bFrom;
		BTo = bTo;
		BDeparture = bDeparture;
		TotalSeat = totalSeat;
		RemainingSeat = remainingSeat;
	}

	public Bus_Details(String bName, int bid, String bFrom, String bTo, String bDeparture, int totalSeat) {
		super();
		BName = bName;
		Bid = bid;
		BFrom = bFrom;
		BTo = bTo;
		BDeparture = bDeparture;
		TotalSeat = totalSeat;
	}


	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public int getBid() {
		return Bid;
	}

	public void setBid(int bid) {
		Bid = bid;
	}

	public String getBFrom() {
		return BFrom;
	}

	public void setBFrom(String bFrom) {
		BFrom = bFrom;
	}

	public String getBTo() {
		return BTo;
	}

	public void setBTo(String bTo) {
		BTo = bTo;
	}

	public String getBDeparture() {
		return BDeparture;
	}

	public void setBDeparture(String bDeparture) {
		BDeparture = bDeparture;
	}

	public int getTotalSeat() {
		return TotalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		TotalSeat = totalSeat;
	}

	public int getRemainingSeat() {
		return RemainingSeat;
	}

	public void setRemainingSeat(int remainingSeat) {
		RemainingSeat = remainingSeat;
	}
	
	
	
	
}
