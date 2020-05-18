package aut.utcluj.isp.ex4;


import java.util.List;
import java.util.Map;

/**
 * @author stefan
 */
public class AirplaneTicketController {
    /**
     * Default number of tickets when a new instance is created
     */
    public static final int DEFAULT_NUMBER_OF_TICKETS = 10;
    private List<AirplaneTicket> tickets;

    public AirplaneTicketController() {
        tickets = new ArrayList<>();
        generateTickets();
    }

    /**
     * Generate default tickets
     */
    private void generateTickets() {
        for (int i = 0; i < DEFAULT_NUMBER_OF_TICKETS; i++) {
            String destination;
            Double price;

            if (i < 3) {
                destination = "Cluj-Napoca";
                price = 10d;
            } else if (i < 6) {
                destination = "Baia Mare";
                price = 20d;
            } else {
                destination = "Timisoara";
                price = 15d;
            }

            final AirplaneTicket airplaneTicket = new AirplaneTicket("ID-" + i, price, destination);
            airplaneTicket.setStatus(TicketStatus.NEW);

            tickets.add(airplaneTicket);
        }
    }

    public List<AirplaneTicket> getTickets() {
        return tickets;
    }

    /**
     * Get ticket details by ticket id
     *
     * @param ticketId - unique ticket id
     * @return
     * @apiNote: this method should throw {@link NoTicketAvailableException} exception if ticket not found
     */
    public AirplaneTicket getTicketDetails(final String ticketId) {
        for (AirplaneTicket ticket : tickets) {
            if (ticket.getId().equals(ticketId))
                return ticket;
        }
        throw new NoTicketAvailableException("No Ticket Available!");
    }

    /**
     * Buy ticket with specific destination
     * Ticket information should be updated: customer name and status {@link TicketStatus#ACTIVE}
     *
     * @param destination - destination
     * @param customerId  - customer name
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoDestinationAvailableException} - if destination not supported by AirplaneTicketController
     * {@link NoTicketAvailableException} - if destination exists but no ticket with NEW status available
     */
    public void buyTicket(final String destination, final String customerId) {
        boolean existDestination=false , ticketAvailable = false;
        for (AirplaneTicket ticket : tickets) {
            if(ticket.getDestination().equals(destination)) {
                existDestination=true;
                if(ticket.getStatus().equals(TicketStatus.NEW)){
                    ticketAvailable=true;
                    ticket.setCustomerId(customerId);
                    ticket.setStatus(TicketStatus.ACTIVE);
                }
            }
        }
        if(existDestination) { throw new NoDestinationAvailableException("No destination available."); }
        if(ticketAvailable) { throw new NoTicketAvailableException("No ticket available."); }
    }

    /**
     * Cancel specific ticket
     * Status of the ticket should be set to {@link TicketStatus#CANCELED}
     *
     * @param ticketId - unique ticket id
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void cancelTicket(final String ticketId) {

        if (getTicketDetails(ticketId).getCustomerId() == null)
            throw new TicketNotAssignedException("Ticket bot assigned");
        getTicketDetails(ticketId).setStatus(TicketStatus.CANCELED);
    }

    /**
     * Change ticket customer name by specific ticket id
     *
     * @param ticketId   - unique ticket id
     * @param customerId - unique customer name
     * @return
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void changeTicketCustomerId(final String ticketId, final String customerId) {
        getTicketDetails(ticketId).setCustomerId(customerId);
    }

    /**
     * This method should filter all tickets by provided status.
     * An empty list should be returned if no tickets available with desired status
     *
     * @param status - ticket status
     * @return
     */
    public List<AirplaneTicket> filterTicketsByStatus(final TicketStatus status) {
        List<AirplaneTicket> filteredStatus = new ArrayList<>();
        for (AirplaneTicket ticket : tickets){
            if (ticket.getStatus().equals(status)) filteredStatus.add(ticket);}
        return filteredStatus;
    }

    /**
     * Return the tickets grouped by customer id
     *
     * @return dictionary where the key is the customer name and the value is a list of tickets for that customer
     * @apiNote: only tickets with available name should be returned
     */
    public Map<String, List<AirplaneTicket>> groupTicketsByCustomerId() {
        Map<String , List<AirplaneTicket>> MGroupTickets = new HashMap<>();
        for (int i = 0 ; i < tickets.size() ; i++){
            ArrayList<AirplaneTicket> LGroupTickets = new ArrayList<>();
            for (int j = i ; j < tickets.size() ; j++){
                if (tickets.get(j).getCustomerId().equals(tickets.get(j).getCustomerId())){
                    LGroupTickets.add(tickets.get(j));
                }
            }
            MGroupTickets.put(tickets.get(i).getCustomerId(),LGroupTickets);
        }
        return MGroupTickets;
    }
}
