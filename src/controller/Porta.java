package controller;

public class Porta {
    private boolean portaAberta = true;

    public synchronized void entrar(String nome) throws InterruptedException {
        while (!portaAberta) {
            wait();
        }
        System.out.println(nome + " cruzou a porta.");
        portaAberta = false;
        notifyAll();
    }

    public synchronized void abrir() {
        portaAberta = true;
        notifyAll();
    }
}
