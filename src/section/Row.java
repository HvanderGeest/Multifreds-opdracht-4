package section;
import java.util.ArrayList;
import java.util.List;
import config.AplConfig;

public class Row {
	private ArrayList<Seat> seats = new ArrayList<>();
	/**
	 * Creates a Row with a number of seats.
	 * @param nrOfSeats number of seats the row is supposed to have
	 */
	public Row (int nrOfSeats){
		for(int i = 0; i < nrOfSeats; i++ ){
			seats.add(new Seat());
		}
	}
	
	/**
	 * Checks whether this Row has a number of seats in a Row that can be reserved.
	 * @param number the number of seats that the Row needs to have unreserved
	 * @return true if this row has the number of seats in a row unreserved
	 */
	public boolean hasSeatsInARow(int number){
		int numberInArow = 0;
		for(Seat s : seats){
			if(s.isReserved()){
				numberInArow =0;
			} else {
				numberInArow ++;
			}
			if(numberInArow == number){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Reserves the seats and returns the seat numbers of the reserved seats.
	 * @param nrOfPersons the number of persons seats needs to be gotten for
	 * @param customerId the customer id of the person who wants to reserve
	 * @return ArrayList with the reserved seat numbers, returns null if a reservation couldn't be made.
	 */
	public List<Integer> getSeats(int nrOfPersons, int customerId){
		ArrayList<Integer> seatNumbers = new ArrayList<>();
		int numberInArow = 0;
		int index = 0;
		for(Seat s : seats){
			if(s.isReserved()){
				numberInArow =0;
				seatNumbers.clear();
			} else {
				numberInArow ++;
				seatNumbers.add(index);
			}
			if(numberInArow == nrOfPersons){
				//reservation
				for(Integer i : seatNumbers){
					assert !seats.get(i).isReserved(): "this seat is supposed to be free";
					assert !seats.get(i).IsPayed(): "this seat isn't supposed to be payed for";
					seats.get(i).reserve(customerId);
				}
				return seatNumbers;
			}
			index++;
		}
		return null;
	}
	
	/**
	 * Gets a seat for a given seat number
	 * @param seatNumber the seat number of the seat
	 * @return a Seat
	 */
	public Seat getSeat(int seatNumber){
		return seats.get(seatNumber);
	}
	
	/**
	 * Creates a String representation of this Row.
	 * @return String representation of this Row.
	 */
	public String stringRow(){
		StringBuilder b = new StringBuilder();
		b.append("<");
		int idSize = (AplConfig.NUMBER_OF_CUSTOMERS+"").length(); // for an outlining purpose
		for(Seat s : seats){
			if(s.IsPayed()){
				String id= s.getCustomerId()+""; 
				while(id.length() != idSize){
					id = "-"+id;
				}
				b.append("["+id+"]" );
			} else {
				String id = "";
				while(id.length() != idSize){
					id = "X"+id;
				}
				b.append("["+id+"]" );
			}
			
		}
		b.append(">");
		return b.toString();
	} 
	
	/**
	 * Returns the number of seats in this Row.
	 * @return number of seats in this Row
	 */
	public int getNumberOfSeats(){
		return seats.size();
	}
	
	

}
