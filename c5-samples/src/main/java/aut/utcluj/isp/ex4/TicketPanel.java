package aut.utcluj.isp.ex4;

import javax.swing.*;
import java.awt.*;

public class TicketPanel extends JPanel {

    private JButton BInvisible;

    public TicketPanel (String SId , String SPrice , String SDestination , String SCustomerId , String SStatus , Font font , Color CellColor , Color BackgroundColor , int width , int height , int border) {

        int blockWidth = (width - 6*border)/5;
        int blockHeight = height - 2*border;

        //set ID Label

        JLabel LId = new JLabel();
        LId.setText(SId);
        LId.setFont(font);
        LId.setForeground(CellColor);
        LId.setHorizontalAlignment(SwingConstants.CENTER);
        LId.setBounds(border,border,blockWidth,blockHeight);

        //set Price Label

        JLabel LPrice = new JLabel();
        LPrice.setText(SPrice);
        LPrice.setFont(font);
        LPrice.setForeground(CellColor);
        LPrice.setHorizontalAlignment(SwingConstants.CENTER);
        LPrice.setBounds(2*border + blockWidth,border,blockWidth,blockHeight);

        //set Destination Label

        JLabel LDestination = new JLabel();
        LDestination.setText(SDestination);
        LDestination.setFont(font);
        LDestination.setForeground(CellColor);
        LDestination.setHorizontalAlignment(SwingConstants.CENTER);
        LDestination.setBounds(3*border + 2*blockWidth,border,blockWidth,blockHeight);

        //set Customer Label

        JLabel LCustomerId = new JLabel();
        LCustomerId.setText(SCustomerId);
        LCustomerId.setFont(font);
        LCustomerId.setForeground(CellColor);
        LCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
        LCustomerId.setBounds(4*border + 3*blockWidth,border,blockWidth,blockHeight);

        //set ID Label

        JLabel LStatus = new JLabel();
        LStatus.setText(SStatus);
        LStatus.setFont(font);
        LStatus.setForeground(CellColor);
        LStatus.setHorizontalAlignment(SwingConstants.CENTER);
        LStatus.setBounds(5*border + 4*blockWidth,border,blockWidth,blockHeight);

        // Make a invisible button over panel

        this.BInvisible = new JButton();
        BInvisible.setBounds(0,0,width,height);
        BInvisible.setOpaque(false);
        BInvisible.setContentAreaFilled(false);
        BInvisible.setBorderPainted(false);

        // ADD all in Panel

        this.setSize(width,height);
        this.setBackground(BackgroundColor);
        this.add(LId);
        this.add(LPrice);
        this.add(LDestination);
        this.add(LCustomerId);
        this.add(LStatus);

    }

    public JButton getBInvisible() { return BInvisible; }

}
