package aut.utcluj.isp.ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author stefan
 */
public class AirplaneTicketController implements AirplaneTicketControllerInterface{

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
            double price;

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
     * @return AirplaneTicket
     * @apiNote: this method should throw {@link NoTicketAvailableException} exception if ticket not found
     */
    public AirplaneTicket getTicketDetails(final String ticketId) {
        for (AirplaneTicket ticket : tickets){
            if (ticket.getId().equals(ticketId))
                return ticket;}
        throw new NoTicketAvailableException("No Ticket Available!");
    }

    /**
     * Buy ticket with specific destination
     * Ticket information should be updated: customer name and status {@link TicketStatus#ACTIVE}
     *
     * @param destination - destination
     * @param customerId  - customer name
     * @apiNote: this method should throw the following exceptions:
     * {@link NoDestinationAvailableException} - if destination not supported by AirplaneTicketController
     * {@link NoTicketAvailableException} - if destination exists but no ticket with NEW status available
     */
    public void buyTicket(final String destination, final String customerId) {
        boolean destinationExists=false , isAvailable=false;
        for (AirplaneTicket ticket : tickets){
            if (ticket.getDestination().equals(destination)){
                destinationExists=true;
                if (ticket.getStatus().equals(TicketStatus.NEW)) {
                    isAvailable = true;
                    ticket.setCustomerId(customerId);
                    ticket.setStatus(TicketStatus.ACTIVE);
                    break;
                }
            }
        }
        if ( !destinationExists ) {
            throw new NoDestinationAvailableException("Don't have tickets with this destination.");
        }
        if ( !isAvailable ) {
            throw new NoTicketAvailableException("No tickets available.");
        }
    }

    /**
     * Cancel specific ticket
     * Status of the ticket should be set to {@link TicketStatus#CANCELED}
     *
     * @param ticketId - unique ticket id
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void cancelTicket(final String ticketId) {
        boolean idExists=false , isAssigned=false;
        for (AirplaneTicket ticket : tickets){
            if (ticket.getId().equals(ticketId)){
                idExists=true;
                if (ticket.getCustomerId() != null && !ticket.getCustomerId().isEmpty()) {
                    isAssigned=true;
                    ticket.setStatus(TicketStatus.CANCELED);
                    break;
                }
            }
        }
        if (!idExists) {
            throw new NoTicketAvailableException("This id does not exist.");
        }
        if(!isAssigned) {
            throw new TicketNotAssignedException("The ticket does not have a customer name.");
        }
    }

    /**
     * Change ticket customer name by specific ticket id
     *
     * @param ticketId   - unique ticket id
     * @param customerId - unique customer name
     * @apiNote: this method should throw the following exceptions:
     * {@link NoTicketAvailableException} - if ticket with this id does not exist
     * {@link TicketNotAssignedException} - if ticket is not assigned to any user
     */
    public void changeTicketCustomerId(final String ticketId, final String customerId) {
        boolean idExists=false , isAssigned = false;
        for (AirplaneTicket ticket : tickets) {
            if (ticket.getId().equals(ticketId)){
                idExists=true;
                if(ticket.getCustomerId() != null && !ticket.getCustomerId().isEmpty())
                    isAssigned = true;
                    ticket.setCustomerId(customerId);
            }
        }
        if ( !idExists ) {
            throw new NoTicketAvailableException("This id does not exist.");
        }
        if ( !isAssigned ) {
            throw new TicketNotAssignedException("The ticket does not have a customer name.");
        }
    }

    /**
     * This method should filter all tickets by provided status.
     * An empty list should be returned if no tickets available with desired status
     *
     * @param status - ticket status
     * @return List filtered by status
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

        for ( int i = 0 ; i < tickets.size() ; i++){
            try {
                List<AirplaneTicket> ticketsList = new ArrayList<>();

                for (AirplaneTicket ticket : tickets) {
                    if (tickets.get(i).getCustomerId().equals(ticket.getCustomerId())) {
                        ticketsList.add(ticket);
                    }

                    MGroupTickets.put(tickets.get(i).getCustomerId(), ticketsList);

                }
            } catch (NullPointerException ignored) {  }
        }

        return MGroupTickets;

    }

}
