package Module9_IntroductiononHowtoBuildaGraphicalUserInterface;
import java.awt.*;
public class Color_calculator 
{

    private Frame f;
    private Panel p1, p2, p3, p4, p5, pcolor;
    private Label lr, lg, lb, la;
    private TextField redField, blueField, greenField, alphaField;
    private Button bcomp;
    private Button bclear; 

    public Color_calculator(){
        f = new Frame("Color calculator");

        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p5 = new Panel();
        pcolor = new Panel();

        lr = new Label("Red: ");
        lg = new Label("Green: ");
        lb = new Label("Blue: ");
        la = new Label("Alpha: ");
        
        redField = new TextField("0.0", 15);
        blueField = new TextField("0.0", 15);
        greenField = new TextField("0.0", 15);
        alphaField = new TextField("0.0", 15);
        
        bcomp  = new Button("Compute");
        bclear = new Button("Clear");
    }

    public void startApp(){
        //redField.setBackground(new Color(225, 225, 20));
        p1.add(lr);
        p1.add(redField);

        p2.add(lg);
        p2.add(greenField);

        p3.add(lb);
        p3.add(blueField);

        p4.add(la);
        p4.add(alphaField);

        p5.add(bcomp);
        p5.add(bclear);

        pcolor.setBackground(new Color(255, 0, 255));
        pcolor.setSize(300, 400);
        //pcolor.setEditable(false);
        f.setLayout(new GridLayout(5, 1));  

        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(pcolor);
        f.setSize(500, 700);;
        f.setVisible(true);
    }
    public static void main(String[] args) {
        Color_calculator cc = new Color_calculator();
        cc.startApp();  
    }
}
