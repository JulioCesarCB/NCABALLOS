import java.util.Arrays;

public class Caballos {

    private int NUM_CABALLOS;
    private int[] solution;

    public Caballos(int NUM_CABALLOS) {
        this.NUM_CABALLOS = NUM_CABALLOS;
        this.solution = new int[NUM_CABALLOS];
        // init();
        // String strArray = Arrays.toString(solution);
        // System.out.println(strArray);
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

    public boolean backtracking(int[] solucion, int caballo) {
        // condicion para evaluar si hemos probado todas los caballos
        boolean success = false;
        if (caballo < NUM_CABALLOS) { // caso base
            do {
                solucion[caballo]++;// [0,-1,-1,-1] //[0,0,-1,-1]
                // es para determinar las soluciones parciales
                boolean valid = isValid(solution, caballo);
                String strSol = Arrays.toString(solution);
                System.out.println(strSol + " " /* + (valid ? "sol parcial" : "") */
                        + (valid && (caballo == NUM_CABALLOS - 1) ? "solucion" : ""));
                if (valid) {

                    success = backtracking(solucion, caballo + 1);
                }
            } while (solution[caballo] < (NUM_CABALLOS - 1) && (!success));
            solucion[caballo] = -1;
        } // else {}
        return success;
    }

    // estudiar y explicar la sgte clase como es que se determina
    // si la restriccion se cumple o no (fila y diagonales)
    public boolean isValid(int[] solution, int caballo) {
        boolean ok = true;
        for (int i = 0; i < caballo; i++) {

            if (!(solution[i] == solution[caballo]
                    || Math.abs(solution[i] - solution[caballo]) == Math.abs(i - caballo))
                    && (Math.abs(i - caballo) <= 2)) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Caballos caballo = new Caballos(7);
        caballo.searchSolution();
    }

}
