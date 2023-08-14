import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PowerIconPanel extends JPanel{

    private JLabel religionLabel;
    private JLabel peopleLabel;
    private JLabel armyLabel;
    private JLabel moneyLabel;

    //Power icon
    ImageIcon religionIcon = new ImageIcon("img/religion_power.png");
    ImageIcon peopleIcon = new ImageIcon("img/people_power.png");
    ImageIcon armyIcon = new ImageIcon("img/army_power.png");
    ImageIcon moneyIcon = new ImageIcon("img/money_power.png");

    public PowerIconPanel() {
        setOpaque(false);
        setLayout(null);
        
        //JLabel for icon
        religionLabel = new JLabel(religionIcon);
        peopleLabel = new JLabel(peopleIcon);
        armyLabel = new JLabel(armyIcon);
        moneyLabel = new JLabel(moneyIcon);

        //Add label
        add(religionLabel);
        add(peopleLabel);
        add(armyLabel);
        add(moneyLabel);
          
    }

    public void setIconBounds(JPanel p){

        int distance = p.getWidth()/13;
        int xPower = p.getWidth()/3 + p.getWidth()/29;
        int yPower = (p.getHeight()/6)/4;

        //Panel bounds
        setBounds(xPower, yPower, distance*4, religionIcon.getIconHeight());

        //Position
        religionLabel.setBounds(0, 0, religionIcon.getIconWidth(), religionIcon.getIconHeight());
        peopleLabel.setBounds(distance, 0, peopleIcon.getIconWidth(), peopleIcon.getIconHeight());
        armyLabel.setBounds(2 * distance, 0, armyIcon.getIconWidth(), armyIcon.getIconHeight());
        moneyLabel.setBounds(3 * distance, 0, moneyIcon.getIconWidth(), moneyIcon.getIconHeight());

    }

}

    
    

