package display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int with, height;
    public Display(String title, int with, int height){
        this.title = title;
        this.with = with;
        this.height = height;

        createDisplay();
    }
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(with,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(with,height));
        canvas.setMaximumSize(new Dimension(with,height));
        canvas.setMinimumSize(new Dimension(with,height));

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
