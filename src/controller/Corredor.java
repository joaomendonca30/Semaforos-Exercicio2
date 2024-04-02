package controller;

public class Corredor extends Thread {
    private String nome;
    private Porta porta;
    private static final int DISTANCIA_CORREDOR = 200;

    private static final int TEMPO_PORTA_MINIMO = 1000;
    private static final int TEMPO_PORTA_MAXIMO = 2000;

    private static final int VELOCIDADE_MINIMA = 4;
    private static final int VELOCIDADE_MAXIMA = 6;


    public Corredor(String nome, Porta porta) {
        this.nome = nome;
        this.porta = porta;
    }

    @Override
    public void run() {
        int distanciaPercorrida = 0;
        int velocidade = (int) (Math.random() * (VELOCIDADE_MAXIMA - VELOCIDADE_MINIMA + 1) + VELOCIDADE_MINIMA);
        while (distanciaPercorrida < DISTANCIA_CORREDOR) {
            distanciaPercorrida += velocidade;
            System.out.println(nome + " percorreu " + distanciaPercorrida + " metros.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nome + " chegou na porta.");
        try {
            int tempoAberturaPorta = (int) (Math.random() * (TEMPO_PORTA_MAXIMO - TEMPO_PORTA_MINIMO + 1) + TEMPO_PORTA_MINIMO);
            Thread.sleep(tempoAberturaPorta);
            porta.entrar(nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}