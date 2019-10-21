import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomePage {
    static Timer timer;
    static JFrame mainFrame = new JFrame();
    public static Draw draw = new Draw();
    static JFrame createSim = new JFrame();
    public static void main(String[] args) throws InterruptedException {

        mainFrame.setLayout(new GridBagLayout());
        mainFrame.setSize(1500, 800);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("yaya");
            }
        });


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        JPanel goStop = new JPanel();
        goStop.setLayout(new GridLayout(1, 3));
        c.weightx = 1;
        c.weighty = 0.25;

        c.ipady = 50;
        c.ipadx = 100;

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        JButton start = new JButton("Go");
        JButton stop = new JButton("Stop");
        JButton load = new JButton("Create New Simulation");
        start.addActionListener(actionEvent -> start());
        stop.addActionListener(actionEvent -> stop());
        load.addActionListener(actionEvent -> change());
        goStop.add(start);
        goStop.add(stop);
        goStop.add(load);
        mainFrame.add(goStop, c);


        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        mainFrame.add(draw, c);

        JLabel label = new JLabel("Test");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        mainFrame.add(label, c);

        JPanel bcontainer = new JPanel();
        bcontainer.setLayout(new GridLayout(1, 2));
        c.weightx = 1;
        c.weighty = 0.25;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        mainFrame.add(bcontainer, c);

        JPanel stats = new JPanel();
        stats.setBackground(Color.DARK_GRAY);
        stats.setLayout(new GridLayout(2, 3));
        JLabel lbl_AS = new JLabel("Average Speed: ");
        JLabel lbl_NOC = new JLabel("Number Of Cars: ");
        JLabel lbl_T = new JLabel("Length of Simulation: ");
        stats.add(lbl_AS);
        stats.add(lbl_NOC);
        stats.add(lbl_T);
        bcontainer.add(stats);
        JPanel export = new JPanel();
        export.setBackground(Color.ORANGE);
        bcontainer.add(export);
        mainFrame.setVisible(true);
        load();
    }

    private static void load() {
        timer = new Timer(1, actionEvent -> {
            for (Car i : CarList.index) {
                i.updatePosition();
                mainFrame.repaint();
                System.out.println(i.currentSpeed);
            }
        });
    }

    private static void start() {
        timer.start();
    }

    private static void stop() {
        timer.stop();
    }

    private static void change() {
        CreateSimPage c = new CreateSimPage(createSim);

    }

}
