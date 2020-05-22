package aut.utcluj.isp.ex4;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class MVC_View {

    // declare Bounds

    private static final int width = 1080 , height = 720 ,
            Border = Math.max(width/200,height/200) ,
            PWidth = width/2-2*Border , PHeight = height- 5*Border - 3*height/20 ,
            F1BWidth = (width-10*Border)/3 , F1BHeight = height/20 ,
            F2LWidth = (PWidth-6*Border)/2 , F2LHeight = PHeight/10;

    // add Swing objects

    private JList<String> F1LTickets , F2LTickets;
    private JFrame frame;
    private JPanel F1Panel , F2Panel , F2ScrollPanel;
    private JScrollPane F1Scroll , F2Scroll;
    private JLabel LF2ID , LF2Price , LF2Destination , LF2CustomerID , LF2Status ,
            LF1ButtonDestination , LF1ButtonCustomerId , LF1ButtonTicketId ,
            LButtonBackground;
    private JTextField TF1ButtonDestination , TF1ButtonCustomerId , TF1ButtonTicketId , TF2CustomerName;
    private JButton BBuy, BSort, BCancel, BF2CustomerName;

    // add design Objects

    private Font font = new Font("Courier",Font.BOLD,14);
    private Color color1 = new Color(25,25,25),
            color2 = new Color(70,70,70),
            color3 = new Color(120,120,120),
            color4 = new Color(150,150,150),
            color5 = new Color(250,250,250);

    public MVC_View(){

        frame = new JFrame();
        addF1();
        addF2();
        addButtons();
        frame.setTitle("Airplane tickets");
        frame.setSize(width + 15,height + 53);
        frame.getContentPane().setBackground(color1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void addF1(){

        // Add List

        this.F1Panel = new JPanel();
        frame.add(this.F1Panel);

    }

    private void addF2(){

        // F1Panel setDesign

        F2Panel = new JPanel();
        F2Panel.setLayout(null);
        F2Panel.setBounds(2*Border + PWidth,Border,PWidth,PHeight);
        F2Panel.setBackground(color2);

        // Add List

        F2ScrollPanel = new JPanel();
        frame.add(F2ScrollPanel);

        // LF2ID setDesign

        LF2ID = new JLabel();
        LF2ID.setText("ID");
        LF2ID.setBackground(color3);
        LF2ID.setForeground(color5);
        LF2ID.setFont(font);
        LF2ID.setBorder(null);
        LF2ID.setBounds(2*Border,2*Border , 2*Border + 2*F2LWidth , F2LHeight);
        LF2ID.setHorizontalAlignment(SwingConstants.CENTER);
        LF2ID.setHorizontalTextPosition(SwingConstants.CENTER);
        LF2ID.setOpaque(true);

        // LF2Price setDesign

        LF2Price = new JLabel();
        LF2Price.setText("Price");
        LF2Price.setBackground(color3);
        LF2Price.setForeground(color5);
        LF2Price.setFont(font);
        LF2Price.setBorder(null);
        LF2Price.setBounds(2*Border,4*Border + F2LHeight,F2LWidth,F2LHeight);
        LF2Price.setHorizontalAlignment(SwingConstants.CENTER);
        LF2Price.setHorizontalTextPosition(SwingConstants.CENTER);
        LF2Price.setOpaque(true);

        // LF2Destination setDesign

        LF2Destination = new JLabel();
        LF2Destination.setText("Destination");
        LF2Destination.setBackground(color3);
        LF2Destination.setForeground(color5);
        LF2Destination.setFont(font);
        LF2Destination.setBorder(null);
        LF2Destination.setBounds(4*Border + F2LWidth,4*Border + F2LHeight,F2LWidth,F2LHeight);
        LF2Destination.setHorizontalAlignment(SwingConstants.CENTER);
        LF2Destination.setHorizontalTextPosition(SwingConstants.CENTER);
        LF2Destination.setOpaque(true);

        // LF2CustomerID setDesign

        LF2CustomerID = new JLabel();
        LF2CustomerID.setText("Customer ID");
        LF2CustomerID.setBackground(color3);
        LF2CustomerID.setForeground(color5);
        LF2CustomerID.setFont(font);
        LF2CustomerID.setBorder(null);
        LF2CustomerID.setBounds(2*Border,6*Border + 2*F2LHeight,F2LWidth,F2LHeight);
        LF2CustomerID.setHorizontalAlignment(SwingConstants.CENTER);
        LF2CustomerID.setHorizontalTextPosition(SwingConstants.CENTER);
        LF2CustomerID.setOpaque(true);

        // LF2Status setDesign

        LF2Status = new JLabel();
        LF2Status.setText("Status");
        LF2Status.setBackground(color3);
        LF2Status.setForeground(color5);
        LF2Status.setFont(font);
        LF2Status.setBorder(null);
        LF2Status.setBounds(4*Border + F2LWidth,6*Border + 2*F2LHeight,F2LWidth,F2LHeight);
        LF2Status.setHorizontalAlignment(SwingConstants.CENTER);
        LF2Status.setHorizontalTextPosition(SwingConstants.CENTER);
        LF2Status.setOpaque(true);

        // Change Customer Name Design

        TF2CustomerName = new JTextField();
        TF2CustomerName.setBounds(LF2CustomerID.getX(),LF2CustomerID.getY(),9*(LF2CustomerID.getWidth())/10,LF2CustomerID.getHeight());
        TF2CustomerName.setBorder(BorderFactory.createLineBorder(color3,2,true));
        TF2CustomerName.setFont(font);
        TF2CustomerName.setForeground(color5);
        TF2CustomerName.setBackground(color3);
        F2Panel.add(TF2CustomerName);
        TF2CustomerName.setVisible(false);

        BF2CustomerName = new JButton(">>");
        BF2CustomerName.setFont(font);
        BF2CustomerName.setBounds(LF2CustomerID.getX() + LF2CustomerID.getWidth() - (LF2CustomerID.getWidth())/10 , LF2CustomerID.getY() , (LF2CustomerID.getWidth())/10,LF2CustomerID.getHeight());
        BF2CustomerName.setForeground(color5);
        BF2CustomerName.setContentAreaFilled(false);
        BF2CustomerName.setBorderPainted(false);
        BF2CustomerName.setMnemonic('O');
        BF2CustomerName.setMargin(new Insets(0,0,0,0));
        BF2CustomerName.setBorder(null);
        BF2CustomerName.setVisible(true);
        LF2CustomerID.add(BF2CustomerName);

        //Add to panel

        F2Panel.add(LF2ID);
        F2Panel.add(LF2Price);
        F2Panel.add(LF2Destination);
        F2Panel.add(BF2CustomerName);
        F2Panel.add(LF2CustomerID);
        F2Panel.add(LF2Status);

        this.frame.add(F2Panel);
    }

    private void addButtons(){

        LButtonBackground = new JLabel();
        LButtonBackground.setBackground(color2);
        LButtonBackground.setBorder(null);
        LButtonBackground.setBounds(Border,2*Border + PHeight, width - 3*Border , 3*F1BHeight + 4*Border);
        LButtonBackground.setOpaque(true);

        // add text field and labels for buttons

        LF1ButtonCustomerId = new JLabel("Customer name ");
        LF1ButtonCustomerId.setBounds(2*Border,2*Border+PHeight, F1BWidth, F1BHeight);
        LF1ButtonCustomerId.setFont(font);
        LF1ButtonCustomerId.setForeground(color5);
        LF1ButtonCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
        LF1ButtonDestination = new JLabel("Destination ");
        LF1ButtonDestination.setBounds(4*Border + F1BWidth,2*Border+PHeight, F1BWidth, F1BHeight);
        LF1ButtonDestination.setFont(font);
        LF1ButtonDestination.setForeground(color5);
        LF1ButtonDestination.setHorizontalAlignment(SwingConstants.CENTER);
        LF1ButtonTicketId = new JLabel("Ticket id ");
        LF1ButtonTicketId.setBounds(6*Border + 2* F1BWidth,2*Border+PHeight, F1BWidth, F1BHeight);
        LF1ButtonTicketId.setFont(font);
        LF1ButtonTicketId.setForeground(color5);
        LF1ButtonTicketId.setHorizontalAlignment(SwingConstants.CENTER);


        TF1ButtonCustomerId = new JTextField();
        TF1ButtonCustomerId.setBounds(2*Border,3*Border+ F1BHeight +PHeight, F1BWidth, F1BHeight);
        TF1ButtonCustomerId.setBorder(BorderFactory.createLineBorder(color3,2,true));
        TF1ButtonCustomerId.setFont(font);
        TF1ButtonCustomerId.setForeground(color5);
        TF1ButtonCustomerId.setBackground(color4);
        TF1ButtonDestination = new JTextField();
        TF1ButtonDestination.setBounds(4*Border + F1BWidth,3*Border+ F1BHeight +PHeight, F1BWidth, F1BHeight);
        TF1ButtonDestination.setBorder(BorderFactory.createLineBorder(color3,2,true));
        TF1ButtonDestination.setFont(font);
        TF1ButtonDestination.setForeground(color5);
        TF1ButtonDestination.setBackground(color4);
        TF1ButtonTicketId = new JTextField();
        TF1ButtonTicketId.setBounds(6*Border + 2* F1BWidth,3*Border+ F1BHeight +PHeight, F1BWidth, F1BHeight);
        TF1ButtonTicketId.setBorder(BorderFactory.createLineBorder(color3,2,true));
        TF1ButtonTicketId.setFont(font);
        TF1ButtonTicketId.setForeground(color5);
        TF1ButtonTicketId.setBackground(color4);

        // add Buttons

        BBuy = new JButton();
        BBuy.setText("Buy");
        BBuy.setFont(font);
        BBuy.setBackground(color2);
        BBuy.setForeground(color5);
        BBuy.setOpaque(true);
        BBuy.setContentAreaFilled(false);
        BBuy.setBorderPainted(false);
        BBuy.setMnemonic('O');
        BBuy.setMargin(new Insets(0,0,0,0));
        BBuy.setBorder(null);
        BBuy.setBounds(2*Border,4*Border + 2* F1BHeight + PHeight, F1BWidth, F1BHeight);

        BSort = new JButton();
        BSort.setText("Sort NEW");
        BSort.setFont(font);
        BSort.setBackground(color2);
        BSort.setForeground(color5);
        BSort.setOpaque(true);
        BSort.setContentAreaFilled(false);
        BSort.setBorderPainted(false);
        BSort.setMnemonic('O');
        BSort.setMargin(new Insets(0,0,0,0));
        BSort.setBorder(null);
        BSort.setBounds(4*Border + F1BWidth,4*Border + 2* F1BHeight + PHeight, F1BWidth, F1BHeight);

        BCancel = new JButton();
        BCancel.setText("Cancel");
        BCancel.setFont(font);
        BCancel.setBackground(color2);
        BCancel.setForeground(color5);
        BCancel.setOpaque(true);
        BCancel.setContentAreaFilled(false);
        BCancel.setBorderPainted(false);
        BCancel.setMnemonic('O');
        BCancel.setMargin(new Insets(0,0,0,0));
        BCancel.setBorder(null);
        BCancel.setBounds(6*Border + 2* F1BWidth,4*Border + 2* F1BHeight +PHeight, F1BWidth, F1BHeight);

        // add things to Frame


        frame.add(LF1ButtonCustomerId);
        frame.add(LF1ButtonDestination);
        frame.add(LF1ButtonTicketId);
        frame.add(TF1ButtonCustomerId);
        frame.add(TF1ButtonDestination);
        frame.add(TF1ButtonTicketId);
        frame.add(BCancel);
        frame.add(BSort);
        frame.add(BBuy);
        frame.add(LButtonBackground);
    }

    public void setF1LTickets(String[] tickets) {

        this.frame.remove(F1Panel);
        this.F1LTickets = new JList<>(tickets);
        this.F1LTickets.setBackground(color3);
        this.F1LTickets.setForeground(color5);
        this.F1LTickets.setFont(font);
        this.F1LTickets.setSelectionBackground(color2);
        this.F1LTickets.setSelectionForeground(color4);
        this.F1LTickets.setBorder(new BorderUIResource.LineBorderUIResource(color2));
        this.F1Scroll = new JScrollPane(this.F1LTickets);
        this.F1Scroll.setBackground(color2);
        this.F1Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.F1Scroll.getVerticalScrollBar().setBackground(color5);
        this.F1Scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(color3);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(color3);
                return button;
            }
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = color3;
                this.thumbDarkShadowColor = color2;
                this.thumbHighlightColor = color4;
                this.thumbLightShadowColor = color2;
                this.trackColor = color2;
                this.trackHighlightColor = color3;

            }
        });



        this.F1Panel = new JPanel();
        F1Panel = new JPanel();
        F1Panel.setBackground(color2);
        this.F1Panel.add(this.F1Scroll);
        this.F1Panel.setBounds(Border,Border,PWidth,PHeight);
        this.F1LTickets.setFixedCellWidth(PWidth-8*Border);
        double numberOfCells =(PHeight - 4*Border)/(F1LTickets.getCellBounds(0,0).getHeight());
        this.F1LTickets.setVisibleRowCount((int)numberOfCells);
        this.F1LTickets.setSelectedIndex(0);
        F1Panel.add(F1Scroll);
        frame.add(this.F1Panel);
        F1Panel.updateUI();

    }

    public void setF2LTickets(String[] tickets) {

        frame.remove(F2ScrollPanel);
        this.F2LTickets = new JList<>(tickets);
        this.F2LTickets.setBackground(color3);
        this.F2LTickets.setForeground(color5);
        this.F2LTickets.setFont(font);
        this.F2LTickets.setSelectionBackground(color2);
        this.F2LTickets.setSelectionForeground(color4);
        this.F2LTickets.setBorder(new BorderUIResource.LineBorderUIResource(color2));
        this.F2Scroll = new JScrollPane(this.F2LTickets);
        this.F2Scroll.setBackground(color2);
        this.F2Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.F2Scroll.getVerticalScrollBar().setBackground(color5);
        this.F2Scroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(color3);
                return button;
            }
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(color3);
                return button;
            }
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = color3;
                this.thumbDarkShadowColor = color2;
                this.thumbHighlightColor = color4;
                this.thumbLightShadowColor = color2;
                this.trackColor = color2;
                this.trackHighlightColor = color3;

            }
        });
        this.F2ScrollPanel = new JPanel();
        this.F2ScrollPanel.add(this.F2Scroll);
        this.F2ScrollPanel.setBounds(PWidth + 3*Border,10*Border + 3*F2LHeight,PWidth - 2*Border,PHeight - 10*Border - 3*F2LHeight);
        this.F2ScrollPanel.setBackground(color2);
        this.F2LTickets.setFixedCellWidth(PWidth-8*Border);
        double numberOfCells =(PHeight - 10*Border - 3*F2LHeight)/(F2LTickets.getCellBounds(0,0).getHeight());
        this.F2LTickets.setVisibleRowCount((int)numberOfCells);
        F2ScrollPanel.add(F2Scroll);
        frame.add(F2ScrollPanel);
        F2ScrollPanel.updateUI();

    }

    public void setWarningMessage(String msg){
        JOptionPane.showMessageDialog(frame, msg);
    }

    // Getter/Setter

    public JButton getBBuy() {
        return BBuy;
    }

    public JButton getBSort() {
        return BSort;
    }

    public JButton getBCancel() {
        return BCancel;
    }

    public JList<String> getF1LTickets() {
        return F1LTickets;
    }

    public JTextField getTF1ButtonCustomerId() {
        return TF1ButtonCustomerId;
    }

    public JTextField getTF1ButtonDestination() {
        return TF1ButtonDestination;
    }

    public JTextField getTF1ButtonTicketId() {
        return TF1ButtonTicketId;
    }

    public JLabel getLF2ID() {
        return LF2ID;
    }

    public JLabel getLF2Price() {
        return LF2Price;
    }

    public JLabel getLF2Destination() {
        return LF2Destination;
    }

    public JLabel getLF2CustomerID() {
        return LF2CustomerID;
    }

    public JLabel getLF2Status() {
        return LF2Status;
    }

    public JTextField getTF2CustomerName() {
        return TF2CustomerName;
    }

    public JButton getBF2CustomerName() {
        return BF2CustomerName;
    }

}

/*LINKS
    FONTS : https://alvinalexander.com/blog/post/jfc-swing/swing-faq-list-fonts-current-platform/
    LIST : https://stackoverflow.com/questions/21501770/multiple-lines-in-jlist-java
    MVC : https://medium.com/@ssaurel/learn-to-make-a-mvc-application-with-swing-and-java-8-3cd24cf7cb10
    LIST of LABELS : https://stackoverflow.com/questions/50958536/java-swing-how-to-make-scrollable-view-of-items-that-may-have-buttons-inside-of
 */
