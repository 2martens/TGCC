import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Diese Klasse definiert Turtles, die mit einfachen
 * Operationen "bewegt" werden koennen. Die Bewegungen
 * einer Turtle koennen auf einer Zeichenflaeche sichtbar
 * gemacht werden, die Turtle hinterlaesst quasi eine
 * Spur. Die Turtle selbst ist nicht sichtbar.
 * <br><br>
 * Warum gerade eine Turtle, also eine Schildkroete?
 * Hauptsaechlich aufgrund der Programmiersprache LOGO, mit
 * der die Idee der Turtle Graphics bekannt geworden ist.
 * Etwas mehr Hintergrund ist hier zu finden:
 * http://llk.media.mit.edu/projects/circles/turtles.html
 * 
 * @author Original von Alfred Hermes (14.12.2003)
 * @author Simon Gerlach
 * @author Axel Schmolitzky
 * @author Fredrik Winkler
 * @version 22. November 2011
 */
class Turtle
{
    // Position dieser Turtle
    private double _x;
    private double _y;

    // Richtung dieser Turtle
    private double _richtung;
    
    // Die Farbe der Spur, die diese Turtle hinterlaesst
    private Color _farbe;
    
    // Gibt an, ob diese Turtle eine Spur hinterlaesst oder nicht
    private boolean _spurHinterlassen;
    
    // Reaktionszeit einer Turtle auf Befehle
    private int _verzoegerung;
    
    // Moegliche Farbwerte
    private static  HashMap<String, Color> farben;
    private static  Color[] farbArray;

    static
    {
        farben = new HashMap<>();
        farben.put("schwarz", Color.BLACK);
        farben.put("blau", Color.BLUE);
        farben.put("cyan", Color.CYAN);
        farben.put("dunkelgrau", Color.DARK_GRAY);
        farben.put("grau", Color.GRAY);
        farben.put("gruen", Color.GREEN);
        farben.put("hellgrau", Color.LIGHT_GRAY);
        farben.put("magenta", Color.MAGENTA);
        farben.put("orange", Color.ORANGE);
        farben.put("pink", Color.PINK);
        farben.put("rot", Color.RED);
        farben.put("weiss", Color.WHITE);
        farben.put("gelb", Color.YELLOW);
        farbArray = farben.values().toArray(new Color[farben.size()]);
    }

    /**
     * Initialisiert eine neue Turtle auf den Mittelpunkt der Welt.
     * Die Ausrichtung ist nach rechts (0 Grad),
     * und es wird eine schwarze Spur hinterlassen.
     */
    public Turtle()
    {
        this(TurtleWelt.WIDTH / 2, TurtleWelt.HEIGHT / 2);
    }

    /**
     * Initialisiert eine neue Turtle auf einen gegebenen Startpunkt.
     * Die Ausrichtung ist nach rechts (0 Grad),
     * und es wird eine schwarze Spur hinterlassen.
     * @param x die X-Koordinate
     * @param y die Y-Koordinate
     */
    public Turtle(double x, double y)
    {
        _x = x;
        _y = y;
        _richtung = 0;
        _verzoegerung = 1;
        _farbe = Color.BLACK;
        _spurHinterlassen = true;
    }

    /**
     * Bewegt die Turtle vorwaerts in Blickrichtung.
     * @param schritte Anzahl der Pixel, die die Turtle zuruecklegen
     *            soll
     */
    public void geheVor(double schritte)
    {
        double radians = Math.toRadians(_richtung);
        double nextX = _x + Math.cos(radians) * schritte;
        double nextY = _y + Math.sin(radians) * schritte;
        geheZu(nextX, nextY);
    }

    /**
     * Bewegt die Turtle auf einer Linie zu einer neuen Position.
     * @param x X-Koordinate der neuen Position
     * @param y Y-Koordinate der neuen Position
     */
    public void geheZu(double x, double y)
    {
        if (_spurHinterlassen)
        {
            TurtleWelt.globaleWelt.zeichneLinie(_x, _y, x, y, _farbe);
        }
        _x = x;
        _y = y;
        verzoegern();
    }
    
    /**
     * Setzt die Blickrichtung der Turtle.
     * @param winkel 0 = rechts, 90 = unten, 180 = links, 270 = oben
     */
    public void setzeRichtung(double winkel)
    {
        _richtung = winkel;
        verzoegern();
    }

    /**
     * Dreht die Turtle um eine angegebene Winkeldifferenz.
     * @param winkel zu drehende Winkeldifferenz in Grad
     */
    public void drehe(double winkel)
    {
        setzeRichtung(_richtung + winkel);
    }

    /**
     * Laesst die Turtle auf den angegebenen Punkt (x, y) schauen.
     * @param x X-Koordinate
     * @param y Y-Koordinate
     */
    public void schaueAuf(double x, double y)
    {
        double deltaX = x - _x;
        double deltaY = y - _y;
        setzeRichtung(Math.toDegrees(Math.atan2(deltaY, deltaX)));
    }

    /**
     * Setzt die Farbe der Spur, die diese Turtle hinterlaesst.
     * Moegliche Farben sind "schwarz", "blau", "cyan", "dunkelgrau", "grau", "gruen", "hellgrau", "magenta", "orange", "pink", "rot", "weiss", "gelb".
     * @param neueFarbe die neue Spur-Farbe der Turtle
     */
    public void setzeFarbe(String neueFarbe)
    {
        if ((neueFarbe == null) || ((_farbe = farben.get(neueFarbe.toLowerCase())) == null))
        {
            _farbe = Color.BLACK;
        }
    }

    /**
     * Setzt eine der 13 moeglichen Farben.
     * @param farbnummer die Farbummer (0 = schwarz, 12 = gelb)
     */
    public void setzeFarbe(int farbnummer)
    {
        _farbe = farbArray[Math.abs(farbnummer % 13)];
    }
    
    /**
     * Bewegungen der Turtle sind ab sofort unsichtbar.
     */
    public void hinterlasseKeineSpur()
    {
        _spurHinterlassen = false;
    }

    /**
     * Bewegungen der Turtle sind ab sofort sichtbar.
     */
    public void hinterlasseSpur()
    {
        _spurHinterlassen = true;
    }

    /**
     * Setzt die Geschwindigkeit, mit der die Turtle auf Anweisungen reagiert.
     * @param geschwindigkeit von 0 (langsam) bis 10 (schnell)
     */
    public void setzeGeschwindigkeit(int geschwindigkeit)
    {
        if (geschwindigkeit > 10)
        {
            geschwindigkeit = 10;
        }
        if (geschwindigkeit < 0)
        {
            geschwindigkeit = 0;
        }
        _verzoegerung = 10 - geschwindigkeit;
    }

    /**
     * Gibt die X-Position der Turtle zurueck.
     * @return die X-Position
     */
    public double gibX()
    {
        return _x;
    }

    /**
     * Gibt die Y-Position der Turtle zurueck.
     * @return die Y-Position
     */
    public double gibY()
    {
        return _y;
    }

    /**
     * Gibt die Richtung der Turtle zurueck.
     * @return die Richtung
     */
    public double gibRichtung()
    {
        return _richtung;
    }

    /**
     * Abhaengig von der Geschwindigkeit dieser Turtle wird hier kurze Zeit verzoegert.
     */
    private void verzoegern()
    {
        if (_verzoegerung > 0)
        {
            try
            {
                Thread.sleep(_verzoegerung);
            }
            catch (InterruptedException ignore)
            {
            }
        }
    }
}

/**
 * Eine Welt, in der sich Turtles bewegen.
 */
class TurtleWelt
{
    public static  int WIDTH = 500;
    public static  int HEIGHT = 500;
    
    public static  TurtleWelt globaleWelt = new TurtleWelt();
    
    private final  Graphics2D _graphics;
    private final  JFrame _frame;

    /**
     * Initialisiert eine neue TurtleWelt.
     * Privat, da nur die �ffentliche statische globaleWelt verwendet werden soll.
     */
    public TurtleWelt()
    {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        _graphics = image.createGraphics();
        _graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);            
        _graphics.setColor(Color.WHITE);
        _graphics.fillRect(0, 0, WIDTH, HEIGHT);
        
        JPanel panel = new ImagePanel(image);
        panel.addMouseListener(new MouseAdapter()
        {
            @Override
			public void mousePressed(MouseEvent e)
            {
                if (e.getButton() != MouseEvent.BUTTON1)
                {
                    loescheAlleSpuren();
                }
            }
        });

        _frame = new JFrame("Turtle Graphics - the canvas can be cleared by right-clicking on it");
        _frame.add(panel);
        _frame.pack();
        _frame.setResizable(false);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);
    }

    /**
     * Loescht alle Spuren, die Turtles bisher hinterlassen haben.
     */
    public void loescheAlleSpuren()
    {
        _graphics.setColor(Color.WHITE);
        _graphics.fillRect(0, 0, WIDTH, HEIGHT);
        _frame.repaint();
    }

    /**
     * Zeichnet eine farbige Linie von (x1/y1) nach (x2/y2).
     * @param x1 
     * @param y1 
     * @param x2 
     * @param y2 
     * @param farbe 
     */
    public void zeichneLinie(double x1, double y1, double x2, double y2, Color farbe)
    {
        _graphics.setColor(farbe);
        _graphics.drawLine((int)(x1 + 0.5), (int)(y1 + 0.5), (int)(x2 + 0.5), (int)(y2 + 0.5));
        _frame.repaint();
    }
    
    /**
     * Wartet die angegebene Zeit.
     * @param timeout 
     */
    public static void warte(long timeout)
	{
		try
		{
			Thread.sleep(timeout);
		}
		catch (InterruptedException ignore)
		{
		}
	}
}

/**
 * Ein Panel, das lediglich aus einem Bild besteht.
 */
@SuppressWarnings("serial")
class ImagePanel extends JPanel
{
    private final BufferedImage _image;

    /**
     * Initialisiert ein neues ImagePanel mit dem angegebenen Bild.
     * @param image 
     */
    public ImagePanel(BufferedImage image)
    {
        super(null);
        _image = image;
        setPreferredSize(new Dimension(_image.getWidth(), _image.getHeight()));
    }

    /**
     * Zeichnet das ImagePanel.
     */
    @Override
	public void paintComponent(Graphics g)
    {
        g.drawImage(_image, 0, 0, null);
    }
}
