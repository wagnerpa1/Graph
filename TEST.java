
/**
 * Beschreiben Sie hier die Klasse TEST.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TEST
{
   GRAPH g;

    /**
     * Konstruktor für Objekte der Klasse TEST
     */
    public TEST()
    {
        g = new GRAPH(10);
        g.erstelleKnoten(new STADT("A"));
        g.erstelleKnoten(new STADT("B"));
        g.erstelleKnoten(new STADT("C"));
        g.erstelleKnoten(new STADT("D"));
        g.erstelleKnoten(new STADT("E"));
        g.erstelleKnoten(new STADT("F"));
        g.erstelleKnoten(new STADT("G"));
        g.erstelleKnoten(new STADT("H"));
        g.erstelleKnoten(new STADT("I"));
        g.erstelleKnoten(new STADT("K"));
        
        g.erstelleKante("A", "B", 1, true);
        g.erstelleKante("A", "C", 1, true);
        g.erstelleKante("B", "E", 1, true);
        g.erstelleKante("B", "D", 1, true);
        g.erstelleKante("D", "H", 1, true);
        g.erstelleKante("E", "F", 1, true);
        g.erstelleKante("F", "C", 1, true);
        g.erstelleKante("F", "G", 1, true);
        g.erstelleKante("F", "K", 1, true);
        g.erstelleKante("F", "J", 1, true);
        
        
    }

    
}
