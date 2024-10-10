/* Максимально простой способ запустить нестатичную графику и управление с клавиатуры в своей программе.
 * В угоду простоте ниже используются нелучшие практики программирования
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Graphics extends JFrame implements KeyListener {
    static ArrayList<Planet> planets = new ArrayList<>();
    static {
        Planet p = new Planet();
        planets.add(p);
    }


    public static void draw(Graphics2D g) {
        for( Planet p : planets){
            p.update(1.0 / 60);
        }

        for( Planet p : planets){
            p.drawMe(g);
        }
    }

    //Функция вызывается при нажатии клавиши один раз, и при удерживании несколько раз в секунду
    public void keyPressed(KeyEvent e) {
    }

    static final int w = 1920;
    static final int h = 1080;

    //магический код позволяющий всему работать, лучше не трогать
    public static void main(String[] args) throws InterruptedException {
        Graphics jf = new Graphics();
        jf.setSize(w, h);//размер экрана
        jf.setUndecorated(false);//показать заголовок окна
        jf.setTitle("Моя супер программа");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.createBufferStrategy(2);
        jf.addKeyListener(jf);
        //в бесконечном цикле рисуем новый кадр
        while (true) {
            long frameLength = 1000 / 60; //пытаемся работать из рассчета  60 кадров в секунду
            long start = System.currentTimeMillis();
            BufferStrategy bs = jf.getBufferStrategy();
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            g.clearRect(0, 0, jf.getWidth(), jf.getHeight());
            draw(g);

            bs.show();
            g.dispose();

            long end = System.currentTimeMillis();
            long len = end - start;
            if (len < frameLength) {
                Thread.sleep(frameLength - len);
            }
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    //Вызывается когда клавиша отпущена пользователем, обработка события аналогична keyPressed
    public void keyReleased(KeyEvent e) {

    }
}
