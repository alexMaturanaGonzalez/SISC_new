/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Alex
 */
public class BarraLoading extends Thread {

    private boolean life;
    private int order;
    private int prog;
    private int total;
    private javax.swing.JProgressBar progBar;

    public BarraLoading(Object in, int total) {

        this.progBar = (javax.swing.JProgressBar) in;
        this.life = true;
        this.prog = 0;
        this.total = total;
    }

    public void matarLoading() {

        this.life = false;
    }

    public void pausarLoading(int in) {

        this.order = in;
    }

    @Override
    public void run() {
        while (life) {
            if (order == 1) {

                System.out.println("Thread running.." + this.prog);
                this.prog++;
                this.progBar.setValue(this.prog);
                try {

                    Thread.sleep(120); // 125 millisegundos
                } catch (Exception e) {

                    e.printStackTrace();
                    System.out.println("Thread->Sleep problem:");
                }
            }
            if (this.prog == total) {

                life = false;
                System.out.println("Thread ended..");
            }
        }
    }
}
