package aut.utcluj.isp.ex4;

import java.util.List;
import java.util.Map;

public interface AirplaneTicketControllerInterface {

    List<AirplaneTicket> getTickets();
    AirplaneTicket getTicketDetails(final String ticketId);
    void buyTicket(final String destination, final String customerId);
    void cancelTicket(final String ticketId);
    void changeTicketCustomerId(final String ticketId, final String customerId);
    List<AirplaneTicket> filterTicketsByStatus(final TicketStatus status);
    Map<String, List<AirplaneTicket>> groupTicketsByCustomerId();

}
