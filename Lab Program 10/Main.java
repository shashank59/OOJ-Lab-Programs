import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ActionListener{
    TextField t1,t2;
    String msg="";
    Button btn;
    Main(){
        Label l1 = new Label("First Number: ",Label.RIGHT);
        t1 = new TextField(10);
        Label l2 = new Label("Second Number: ",Label.RIGHT);
        
        t2 = new TextField(10);
        btn = new Button("Submit");
        this.add(l1);
        this.add(t1);
        this.add(l2);
        this.add(t2);
        this.add(btn,BorderLayout.CENTER);
        this.setVisible(true);
        this.setSize(600, 300);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
        btn.addActionListener(this);
        addWindowListener(new MyWindow());
        setBackground(Color.BLACK);
     }
    @Override
    public Insets getInsets() {
        return new Insets(50,10,10,20);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
        String st1 = t1.getText();
        String st2 = t2.getText();
        double n1,n2;
        n1 = 0.0;
        n2 = 0.0;
        if(st1.equals("")||st2.equals("")) {

            msg="You cannot leave the text elements blank";
        }else{
            try {
                n1 = Double.parseDouble(st1);
                n2 = Double.parseDouble(st2);
                try {
                    double res = n1/n2;
                    msg = "Result of division: "+res;
                }catch(ArithmeticException e1) {
                    msg = e1.toString();
                }
            }catch(NumberFormatException e2) {
                msg = "Enter only numbers and not other things";
            }
        }
        new MyDialog(this,"Result Dialog",false,msg,n1,n2);
    }
    public static void main(String[] args) {
        new Main();
    }
}

class MyDialog extends Dialog implements ActionListener{

    public MyDialog(Frame owner, String title, boolean modal,String msg, double n1, double n2) {
        super(owner, title, modal);
        this.setVisible(true);
        this.setSize(300, 400);
        this.setLayout(new FlowLayout());
        this.add(new Label("First Number: "+n1));
        this.add(new Label("Second Number: "+n2));
        this.add(new Label(msg));
        
        Button b = new Button("Close");
        this.add(b);
        b.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        
    }
    
    
}

class MyWindow extends WindowAdapter{
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
