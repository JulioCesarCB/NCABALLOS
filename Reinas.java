import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JGridLayout;
import javax.swing.JTextField;



public class Reinas extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int NUM_REINAS;
    private int[] solution;
    private final static  int SIZE = 600;
    public Reinas(int NUM_REINAS) {
        this.NUM_REINAS = NUM_REINAS;
        this.solution = new int[NUM_REINAS];
        //init();
        //String strArray = Arrays.toString(solution);
        //System.out.println(strArray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SIZE,SIZE);
        
        BorderLayout gestorLayout = new BorderLayout();
        //GridLayout gestor = new GridLayout(3,3);
        //setLayout(gestor);
        setLayout(gestorLayout);

        JButton btn1 = new JButton("B1");
        JButton btn2 = new JButton("B1");
        JButton btn3 = new JButton("B1");
        JButton btn4 = new JButton("B1");
        //JTextField

        add(BorderLayout.NORTH,btn1);
        add(BorderLayout.SOUTH,btn2);
        //add(BorderLayout.CENTER,getBoard());
        add(BorderLayout.EAST,btn3);
        add(BorderLayout.WEST,btn4);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);

        setLocationRelativeTo(this);
        setVisible(true);
        
        
        
    }

    /*public JPanel getBoard(){
        JPanel panel = new JPanel();
        GridLayout gestor = new GridLayout (NUM_REINAS,NUM_REINAS);
        panel. setLayout(gestor);
        for (int i = 0; i < NUM_REINAS; i++) {
            for (int j = 0; j < NUM_REINAS; j++) {
                JButton cell = new JButton ("x")
                if(i%2 == 0){
                    cell.setBackground(Color.GRAY)
                }
                cell.setEnabled(false);
                panel.add(cell);
                
            }
        }
    }*/

    public void getOptions(){

    }

    public void getResult(){

    }

    public void init() {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = -1;
        }
    }

    public void searchSolution() {
        init();
        backtracking(solution, 0);
    }

    public boolean backtracking(int[] solucion, int reina) {
        // condicion para evaluar si hemos probado todas las reinas
        boolean success = false;
        if (reina < NUM_REINAS) { // caso base
            do {
                solucion[reina]++;// [0,-1,-1,-1] //[0,0,-1,-1]
                // es para determinar las soluciones parciales
                boolean valid = isValid(solution, reina);
                String strSol = Arrays.toString(solution);
                System.out.println(strSol + " " + (valid ? "sol parcial" : "")
                        + (valid && (reina == NUM_REINAS - 1) ? "solucion" : ""));
                if (valid) {
                    // reina = reina +1;
                    success = backtracking(solucion, reina + 1);
                }
            } while (solution[reina] < (NUM_REINAS - 1) && (!success));
            solucion[reina] = -1;
        } //else {}
        return success;
    }

    // estudiar y explicar la sgte clase como es que se determina
    // si la restriccion se cumple o no (fila y diagonales)
    public boolean isValid(int[] solution, int reina) {
        boolean ok = true;
        for (int i = 0; i < reina; i++) {
            if (solution[i] == solution[reina] || Math.abs(solution[i] - solution[reina]) == Math.abs(i - reina)) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Reinas reina = new Reinas(3);
        reina.searchSolution();
    }

}
