package messages;

import messages.ReservationStatus.ReservationStatusCode;

public final class ReservationUpdate {
	private final Reservation reservation;
	private final ReservationStatusCode status;
	
	public ReservationUpdate(Reservation reservation, ReservationStatusCode status) {
		this.reservation = reservation;
		this.status = status;
	}
	/**
	 * @return the reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}
	/**
	 * @return the status
	 */
	public ReservationStatusCode getStatus() {
		return status;
	}

}
