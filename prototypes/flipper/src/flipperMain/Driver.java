package flipperMain;


import flipperModel.Model;
import flipperView.RunGUI;

public class Driver {


    public static void main(String[] args) {
        Model model = new Model();
        RunGUI gui = new RunGUI(model);
        model.setBallVeloctiy(0, 300);

    }
}