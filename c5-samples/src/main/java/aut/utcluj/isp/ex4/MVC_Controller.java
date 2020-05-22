package aut.utcluj.isp.ex4;

import java.util.List;

public class MVC_Controller {

    private AirplaneTicketControllerInterface model;
    private MVC_View view;
    private TicketStatus status = TicketStatus.NEW;
    private boolean ChangeText = false;

    public MVC_Controller(AirplaneTicketControllerInterface model, MVC_View view) {
        this.model = model;
        this.view = view;
        initView();
    }

    public void initView() {
        setListOfTickets(model.getTickets());
    }

    public void initController() {
        BuyTicket();
        SortTickets();
        CancelTicket();
        DisplayTicketDetails();
        DisplayCustomerTickets();
        ChangeCustomerName();
    }

    private void setListOfTickets(List<AirplaneTicket> list){
        String[] ticketDetails = new String[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            ticketDetails[i] = "<html> " +
                    "-----------------------------------------------------------" +
                    "<br/>" +
                    "Id = " + list.get(i).getId() +
                    "<br/>" +
                    "Price = " + list.get(i).getPrice() +
                    "<br/>" +
                    "Destination = " + list.get(i).getDestination() +
                    "<br/>" +
                    "Customer Name = " + list.get(i).getCustomerId() +
                    "<br/>" +
                    "Status = " + list.get(i).getStatus() +
                    "<br/>" +
                    "-----------------------------------------------------------" +
                    "</html>";
        }
        view.setF1LTickets(ticketDetails);
        DisplayTicketDetails();
    }

    private void BuyTicket(){

        view.getBBuy().addActionListener(e -> {
            final String destination = view.getTF1ButtonDestination().getText() ,
                    customerId = view.getTF1ButtonCustomerId().getText();
            try {
                model.buyTicket(destination,customerId);
            }
            catch (NoDestinationAvailableException | NoTicketAvailableException ex){
                view.setWarningMessage(ex.getMessage());
            }
            setListOfTickets(model.getTickets());
        });

    }

    private void SortTickets(){

        view.getBSort().addActionListener(e -> {
            if (status == TicketStatus.NEW) {
                status = TicketStatus.ACTIVE;
            } else if (status == TicketStatus.ACTIVE) {
                status = TicketStatus.CANCELED;
            } else {
                status = TicketStatus.NEW;
            }
            view.getBSort().setText("Sort " + status);
            if ((model.filterTicketsByStatus(this.status).size()) != 0) {
                setListOfTickets(model.filterTicketsByStatus(this.status));
            } else {
                view.setF1LTickets(new String[]{"<html>-----------------------------------------------------------" +
                        "<br/>Id = ~" +
                        "<br/>Price = ~" +
                        "<br/>Destination = ~" +
                        "<br/>Customer Name = ~" +
                        "<br/>Status = ~" +
                        "<br/>-----------------------------------------------------------</html>"});
                DisplayTicketDetails();
            }
        });

    }

    private void CancelTicket(){

        view.getBCancel().addActionListener(e -> {
                final String id = view.getTF1ButtonTicketId().getText();
                try {
                    model.cancelTicket(id);
                    setListOfTickets(model.getTickets());
                }
                catch (NoDestinationAvailableException | NoTicketAvailableException | TicketNotAssignedException ex){
                    view.setWarningMessage(ex.getMessage());
                }
            });

    }

    private void DisplayTicketDetails() {

        String details1 = view.getF1LTickets().getSelectedValue(),
                id1 = extractString(1,details1),
                price1 = extractString(2,details1),
                destination1 = extractString(3,details1),
                customerId1 = extractString(4,details1),
                status1 = extractString(5,details1);

        view.getLF2ID().setText(id1);
        view.getLF2Price().setText(price1);
        view.getLF2Destination().setText(destination1);
        view.getLF2CustomerID().setText(customerId1);
        view.getLF2Status().setText(status1);
        DisplayCustomerTickets();

        view.getF1LTickets().addListSelectionListener(e -> {

            final String details2 = view.getF1LTickets().getSelectedValue(),
                    id2 = extractString(1,details2),
                    price2 = extractString(2,details2),
                    destination2 = extractString(3,details2),
                    customerId2 = extractString(4,details2),
                    status2 = extractString(5,details2);

            DisplayCustomerTickets();
            view.getLF2ID().setText(id2);
            view.getLF2Price().setText(price2);
            view.getLF2Destination().setText(destination2);
            view.getLF2CustomerID().setText(customerId2);
            view.getLF2Status().setText(status2);

        });
    }

    private String extractString (int index , String str){

        String[] extract = str.split("<br/>",14);
        String replace = "";
        switch (index){
            case 1: { replace = "Id = "; break; }
            case 2: { replace = "Price = "; break; }
            case 3: { replace = "Destination = "; break;}
            case 4: { replace = "Customer Name = "; break;}
            case 5: { replace = "Status = "; break;}
        }
        return extract[index].replaceAll(replace , "");
    }

    private void DisplayCustomerTickets(){

        try {
            List<AirplaneTicket> list = model.groupTicketsByCustomerId().get(view.getLF2CustomerID().getText());
            String[] ticketDetails = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ticketDetails[i] = "<html> " +
                        "-----------------------------------------------------------" +
                        "<br/>" +
                        "Id = " + list.get(i).getId() +
                        "<br/>" +
                        "Price = " + list.get(i).getPrice() +
                        "<br/>" +
                        "Destination = " + list.get(i).getDestination() +
                        "<br/>" +
                        "Customer Name = " + list.get(i).getCustomerId() +
                        "<br/>" +
                        "Status = " + list.get(i).getStatus() +
                        "<br/>" +
                        "-----------------------------------------------------------" +
                        "</html>";
            }
            view.setF2LTickets(ticketDetails);
        }
        catch (NullPointerException e) {
            view.setF2LTickets(new String[]{"<html>-----------------------------------------------------------" +
                    "<br/>Id = ~" +
                    "<br/>Price = ~" +
                    "<br/>Destination = ~" +
                    "<br/>Customer Name = ~" +
                    "<br/>Status = ~" +
                    "<br/>-----------------------------------------------------------</html>"});
        }
    }

    private void ChangeCustomerName(){

        view.getBF2CustomerName().addActionListener(e -> {
            if(ChangeText){
                ChangeText=false;
                try {
                    model.changeTicketCustomerId(view.getLF2ID().getText(), view.getTF2CustomerName().getText());
                }
                catch (NoTicketAvailableException | TicketNotAssignedException ex){
                    view.setWarningMessage(ex.getMessage());
                }
                view.getTF2CustomerName().setVisible(false);
                setListOfTickets(model.getTickets());
            }
            else {
                ChangeText = true;
                view.getTF2CustomerName().setVisible(true);
                view.getLF2CustomerID().setText("");
            }
        });

    }

    }