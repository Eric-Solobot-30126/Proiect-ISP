package aut.utcluj.isp.ex4;

public class MainClass {

    public static void main(String[] args) {
        AirplaneTicketControllerInterface mvc_model = new AirplaneTicketController();
        MVC_View mvc_view = new MVC_View();
        MVC_Controller mvc_controller = new MVC_Controller(mvc_model,mvc_view);
        mvc_controller.initController();
    }

}
