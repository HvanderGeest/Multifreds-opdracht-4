package messages;

public final class TicketRequest {
	private final String sectionName;
	private final int nrOfTickets;
	private final int userId;
	
	public TicketRequest(String sectionName, int nrOfTickets, int userId){
		this.sectionName = sectionName;
		this.nrOfTickets = nrOfTickets;
		this.userId = userId;
	}

	/**
	 * @return the vakNaam
	 */
	public String getSectionName() {
		return sectionName;
	}	

	/**
	 * @return the nrOfTickets
	 */
	public int getNrOfTickets() {
		return nrOfTickets;
	}
	/**
	 * @return the userId
	 */
	public int getUserId(){
		return userId;
	}
	
	@Override
	public String toString(){
		return "TicketRequest for: "+sectionName+ " number of seats "+nrOfTickets+" requested by: "+ userId; 
	}

}
