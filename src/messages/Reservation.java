package messages;

import java.util.List;

public final class Reservation {
	private final String sectionName;
	private final int rowNumber;
	private final List<Integer> seatNumbers;
	private final int userId;
	
	public Reservation(int row,  List<Integer> seats, int userId, String sectionName){
		this.rowNumber = row;
		this.seatNumbers = seats;
		this.userId = userId;
		this.sectionName = sectionName;
	}

	/**
	 * @return the row
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/**
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @return the seats
	 */
	public  List<Integer> getSeatNumbers() {
		return seatNumbers;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(("user: "+userId+" "));
		sb.append("Row: "+ rowNumber+" SeatNumber(s): ");
		for(Integer i : seatNumbers){
			sb.append("["+i+"] ");
		}
		sb.append("Section: "+sectionName);
		return sb.toString();
		
	}

}
