package collisionsView;

import collisionsController.LoadListener;
        import collisionsController.RunListener;
        import collisionsModel.Model;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionListener;

public class RunGUI {

    private final static Dimension WINDOW_SIZE = new Dimension(800, 700);
    private Model m;
    private JFrame jFrame;
    private ActionListener listener;
    private collisionsView.Board board;

    private JPanel playZone;
    private Container cp;
    private GridLayout controlButtons;
    private FlowLayout flow;

    private final int L = 25;

    private GridLayout runGrid;

    public RunGUI(Model model){

        m = model;
        listener = new RunListener(m);

        initialise();
        leftZone();
        rightZone();
        menu();

        jFrame.setVisible(true);
        //jFrame.pack();

        //board.paintComponent(Graphics2D.g);
        jFrame.pack();

    }

    private void initialise() {
        jFrame = new JFrame();
        flow = new FlowLayout();
        jFrame.setLayout(flow);

        jFrame.setTitle("Gizmoball MW05");

        jFrame.setSize(WINDOW_SIZE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cp = new Container();
        //playZone = new JPanel();

        playZone = new collisionsView.Board(500,500,m);

        // Gizmo board is 25x25 pixels each zone (doesnt work atm)
        Dimension runDimension = new Dimension(playZone.getWidth(),playZone.getHeight());
        playZone.setPreferredSize(runDimension);

        cp.setLayout(new GridLayout( 0,1));
        //playZone.setLayout(new GridLayout(21,21));
        cp.setPreferredSize(new Dimension(100,550));



        Container pane = jFrame.getContentPane();

        pane.add(cp,BorderLayout.LINE_START);
        pane.add(playZone,BorderLayout.CENTER);

        jFrame.pack();
        jFrame.setResizable(false);

    }


    private void leftZone() {

        //Create grid and populate with buttons
        controlButtons = new GridLayout(4,1);
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton tick = new JButton("Tick");
        JButton quit = new JButton("Quit");

        start.addActionListener(listener);
        stop.addActionListener(listener);
        tick.addActionListener(listener);
        quit.addActionListener(listener);

        cp.add(start);
        cp.add(stop);
        cp.add(tick);
        cp.add(quit);

    }

    private void rightZone() {
        //JButton but = new JButton();
        //playZone.add(but);




    }

    private void menu() {
        //Create menu bar then populate it
        JMenuBar menuBar = new JMenuBar();

        //Create menu
        JMenu menu = new JMenu("File");

        //Create all menu items
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(listener);

        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(new LoadListener());

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(listener);

        //Construct menu bar
        jFrame.setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(save);
        menu.add(load);
        menu.addSeparator();
        menu.add(exit);
    }

}