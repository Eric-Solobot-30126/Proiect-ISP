package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class AirplaneTicketController {
    private List<AirplaneTicket> tickets;

    public AirplaneTicketController() {
        tickets=new ArrayList<>();
    }

    /**
     * Add new airplane ticket
     *
     * @param airplaneTicket - airplane ticket object
     */
    public void addNewTicket(final AirplaneTicket airplaneTicket) {
        tickets.add(airplaneTicket);
    }

    /**
     * Get all tickets
     *
     * @return
     */
    public List<AirplaneTicket> getTickets() {
        return this.tickets;
    }

    /**
     * Return total number of tickets
     */
    public int getTotalNumberOfTickets() {
        return tickets.size();
    }

    /**
     * Remove a specific ticket by ticket id
     *
     * @param ticketId - unique ticket id
     */
    public void removeTicketById(final String ticketId) {
        for (int i = 0 ; i < getTotalNumberOfTickets() ; i++)
            if (tickets.get(i).getId().equals(ticketId))
                tickets.remove(tickets.get(i));
    }

    /**
     * Update destination for a specific ticket
     *
     * @param ticketId    - unique ticket id
     * @param destination - new destination
     */
    public void updateTicketDestination(final String ticketId, final String destination) {
        for (int i = 0 ; i < getTotalNumberOfTickets() ; i++)
            if (tickets.get(i).getId().equals(ticketId))
                tickets.get(i).setDestination(destination);
    }

    /**
     * Filter airplane tickets with price between [minPrice, maxPrice]
     *
     * @param minPrice - ticket min prince
     * @param maxPrice - ticket max price
     * @return filteredPrice - List filtered by price
     */
    public List<AirplaneTicket> filterTicketsBetweenMinMaxPrice(final Double minPrice, final Double maxPrice) {
        List<AirplaneTicket> filteredPrice = new ArrayList<>();
        for (int i = 0 ; i < getTotalNumberOfTickets() ; i++)
            if (tickets.get(i).getPrice() <= maxPrice && tickets.get(i).getPrice() >= minPrice)
                filteredPrice.add(tickets.get(i));
            return filteredPrice;
    }

    /**
     * Filter airplane tickets with price between [minPrice, maxPrice] and destination
     *
     * @param minPrice    - ticket min price
     * @param maxPrice    - ticket max price
     * @param destination - destination
     * @return filteredPriceDestination - List filtered by price and destination
     */
    public List<AirplaneTicket> filterTicketsWithPriceAndDestination(final Double minPrice, final Double maxPrice, final String destination) {
        List<AirplaneTicket> filteredPriceDestination = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getDestination().equals(destination) && tickets.get(i).getPrice() <= maxPrice && tickets.get(i).getPrice() >= minPrice)
                filteredPriceDestination.add(tickets.get(i));
        }
        return filteredPriceDestination;
    }
}
