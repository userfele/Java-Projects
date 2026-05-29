import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 This program generates a spiral.
 */
public class SpiralGenerator
{
    public static void draw(Graphics g)
    {
        int size = 10;
        int increment = size;
        int xLast, yLast, xNext, yNext;
        int count = 0;
        xLast = 200;
        yLast = 200;
        boolean done = false;
        while (!done)
        {
            int dx = 0;
            int dy = 0;
            if (count % 4 == 0)
            {
                dx = 1;
                dy = 0;
            } // right
            else if (count % 4 == 1)
            {
                dx = 0;
                dy = -1;
            } // up
            else if (count % 4 == 2)
            {
                dx = -1;
                dy = 0;
            } // left
            else if (count % 4 == 3)
            {
                dx = 0;
                dy = 1;
            } // down
            xNext = xLast + dx * size;
            yNext = yLast + dy * size;
            if (count % 2 == 1)
            {
                size = size + increment;
            }
            count++;
            if ((xLast < 0) || (yLast < 0) || (xNext < 0) || (yNext < 0))
            {
                done = true;
            }
            g.drawLine(xLast, yLast, xNext, yNext);
            xLast = xNext;
            yLast = yNext;
        }
    }
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent component = new JComponent()
        {
            public void paintComponent(Graphics graph)
            {
                draw(graph);
            }
        };
        frame.add(component);
        frame.setVisible(true);
    }
}
