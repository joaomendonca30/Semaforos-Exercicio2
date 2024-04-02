import controller.Corredor;
import controller.Porta;

public class Main {
    public static void main(String[] args) {
        Corredor[] corredores = new Corredor[4];
        Porta porta = new Porta();

        for (int i = 0; i < 4; i++) {
            corredores[i] = new Corredor("O corredor " + (i + 1), porta);
            corredores[i].start();
        }
    }
}