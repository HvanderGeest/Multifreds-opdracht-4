package section;

public class Seat {
	private boolean reserved = false;
	private int customerId = -1;
	private boolean payed = false;
	
	/**
	 * Reserves a seat for a customer id.
	 * @param customerId customer id the seat needs to be reserved for.
	 */
	public void reserve(int customerId){
		reserved = true;
		this.customerId = customerId;
	}
	
	/**
	 *Sets this seat as payed. 
	 */
	public void payedConfirmation(){
		assert reserved: "a seat also needs to be reserved when bought";
		assert customerId != -1: "this seat needs to have a valid user id";
		payed = true;
	}
	/**
	 * Un-reserves this seat.
	 */
	public void unReserve(){
		reserved = false;
		this.customerId =-1;
	}
	/**
	 * Checks if the seat is reserved
	 * @return true if the seat is reserved, else false.
	 */
	public boolean isReserved(){
		return reserved;
	}
	
	/**
	 * Checks if the payment was made for this seat.
	 * @return true if the payment for the seat was made, false otherwise.
	 */
	public boolean IsPayed(){
		return payed;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	
	

}
