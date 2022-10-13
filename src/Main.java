import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.management.PlatformLoggingMXBean;

public class Main {
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        JFrame frame = new JFrame("Snowman");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        SnowmanComponent snowman = new SnowmanComponent();
        snowman.setBounds(100, 100, 600, 600);
        frame.getLayeredPane().add(snowman);

        frame.setVisible(true);
    }
}

class SnowmanComponent extends JComponent {
    private final static float STROKE_WIDTH = 5;
    private final static float DEBUG_STROKE_WIDTH = 1;
    private final static Color MAIN_COLOR = Color.BLACK;
    private final static Color DEBUG_COLOR = new Color(0, 200, 0, 100);
    private final static double ORIGIN_WIDTH = 1000;
    private final static double ORIGIN_HEIGHT = 1000;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        setStyle(g2d);

        drawBodyBottom(g2d);
        drawBodyMiddle(g2d);
        drawBodyTop(g2d);
        drawHat(g2d);
    }

    private void drawBodyBottom(Graphics2D g2d) {
        setStyle(g2d);
        Rectangle2D bound = new Rectangle2D.Double(
                getLayerX(218),
                getLayerY(568),
                getLayerWidth(522),
                getLayerHeight(430)
        );
        g2d.draw(new Arc2D.Double(bound, 126, 289, Arc2D.OPEN));
    }

    private void drawBodyMiddle(Graphics2D g2d) {
        setStyle(g2d);
        Rectangle2D bound = new Rectangle2D.Double(
                getLayerX(273),
                getLayerY(330),
                getLayerWidth(406),
                getLayerHeight(333)
        );
        //Body
        g2d.draw(new Arc2D.Double(bound, 110, 43, Arc2D.OPEN));
        g2d.draw(new Arc2D.Double(bound, 165, 264, Arc2D.OPEN));

        g2d.setStroke(new BasicStroke(STROKE_WIDTH / 2));
        //Buttons
        g2d.draw(new Ellipse2D.Double(getLayerX(503), getLayerY(437), getLayerWidth(23), getLayerHeight(23)));
        g2d.draw(new Ellipse2D.Double(getLayerX(503), getLayerY(489), getLayerWidth(23), getLayerHeight(23)));
        g2d.draw(new Ellipse2D.Double(getLayerX(503), getLayerY(540), getLayerWidth(23), getLayerHeight(23)));

        //Left hand
        drawLeftHand(g2d);

        //Right hand
        drawRightHand(g2d);
    }

    private void drawLeftHand(Graphics2D g2d) {
        setStyle(g2d);
        Path2D path = new Path2D.Double();
        path.moveTo(getLayerX(666), getLayerY(434));
        path.lineTo(getLayerX(891), getLayerY(364));
        path.lineTo(getLayerX(929), getLayerY(302));
        path.lineTo(getLayerX(951), getLayerY(312));
        path.lineTo(getLayerX(924), getLayerY(360));
        path.lineTo(getLayerX(990), getLayerY(348));
        path.lineTo(getLayerX(998), getLayerY(374));
        path.lineTo(getLayerX(931), getLayerY(389));
        path.lineTo(getLayerX(966), getLayerY(420));
        path.lineTo(getLayerX(950), getLayerY(435));
        path.lineTo(getLayerX(897), getLayerY(395));
        path.lineTo(getLayerX(676), getLayerY(464));
        g2d.draw(path);
    }

    private void drawRightHand(Graphics2D g2d) {
        setStyle(g2d);
        Polygon polygon = new Polygon();
        polygon.addPoint((int) getLayerX(331), (int) getLayerY(435));
        polygon.addPoint((int) getLayerX(321), (int) getLayerY(463));
        polygon.addPoint((int) getLayerX(101), (int) getLayerY(395));
        polygon.addPoint((int) getLayerX(47), (int) getLayerY(434));
        polygon.addPoint((int) getLayerX(30), (int) getLayerY(419));
        polygon.addPoint((int) getLayerX(65), (int) getLayerY(388));
        polygon.addPoint((int) getLayerX(2), (int) getLayerY(374));
        polygon.addPoint((int) getLayerX(8), (int) getLayerY(349));
        polygon.addPoint((int) getLayerX(72), (int) getLayerY(360));
        polygon.addPoint((int) getLayerX(46), (int) getLayerY(312));
        polygon.addPoint((int) getLayerX(66), (int) getLayerY(301));
        polygon.addPoint((int) getLayerX(103), (int) getLayerY(362));
        g2d.draw(polygon);
    }

    private void drawBodyTop(Graphics2D g2d) {
        setStyle(g2d);
        Rectangle2D bound = new Rectangle2D.Double(
                getLayerX(347),
                getLayerY(140),
                getLayerWidth(263),
                getLayerHeight(215)
        );
        //Face
        g2d.draw(new Arc2D.Double(bound, 141, 208, Arc2D.OPEN));
        g2d.draw(new Arc2D.Double(bound, 0, 38, Arc2D.OPEN));

        g2d.setStroke(new BasicStroke(STROKE_WIDTH / 2));
        //Eyes
        g2d.draw(new Ellipse2D.Double(getLayerX(461), getLayerY(210), getLayerWidth(29), getLayerHeight(29)));
        g2d.draw(new Ellipse2D.Double(getLayerX(533), getLayerY(209), getLayerWidth(29), getLayerHeight(29)));

        //Mouth
        g2d.draw(new Ellipse2D.Double(getLayerX(442), getLayerY(294), getLayerWidth(24), getLayerHeight(24)));
        g2d.draw(new Ellipse2D.Double(getLayerX(476), getLayerY(307), getLayerWidth(24), getLayerHeight(24)));
        g2d.draw(new Ellipse2D.Double(getLayerX(515), getLayerY(307), getLayerWidth(24), getLayerHeight(24)));
        g2d.draw(new Ellipse2D.Double(getLayerX(548), getLayerY(293), getLayerWidth(24), getLayerHeight(24)));

        //Nose
        Polygon polygon = new Polygon();
        polygon.addPoint((int) getLayerX(501), (int) getLayerY(253));
        polygon.addPoint((int) getLayerX(668), (int) getLayerY(251));
        polygon.addPoint((int) getLayerX(507), (int) getLayerY(287));
        g2d.draw(polygon);
    }

    private void drawHat(Graphics2D g2d) {
        setStyle(g2d);
        double arc = getLayerWidth(20);
        g2d.draw(new RoundRectangle2D.Double(
                getLayerX(389),
                getLayerY(STROKE_WIDTH / 2),
                getLayerWidth(189),
                getLayerHeight(140),
                arc,
                arc
        ));
        g2d.draw(new Line2D.Double(getLayerX(389), getLayerY(94), getLayerX(389 + 189), getLayerY(94)));

        g2d.draw(new Arc2D.Double(
                new Rectangle2D.Double(
                        getLayerX(320),
                        getLayerY(130),
                        getLayerWidth(330),
                        getLayerHeight(55)
                ),
                126,
                288,
                Arc2D.OPEN
        ));
    }

    private void setStyle(Graphics2D g2d) {
        g2d.setColor(MAIN_COLOR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));
    }

    private double getLayerX(double originX) {
        return getWidth() * originX / ORIGIN_WIDTH;
    }

    private double getLayerY(double originY) {
        return getHeight() * originY / ORIGIN_HEIGHT;
    }

    private double getLayerWidth(double originWidth) {
        return getWidth() * originWidth / ORIGIN_WIDTH;
    }

    private double getLayerHeight(double originHeight) {
        return getHeight() * originHeight / ORIGIN_HEIGHT;
    }
}
