
/**
 * Beschreiben Sie hier die Klasse KNOTEN.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class KNOTEN
{
    private STADT stadt;
    private boolean besucht;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN
     */
    public KNOTEN(STADT s)
    {
        stadt = s;
    }

    public STADT getStadt(){
        return stadt;
    }
    
    public void setStadt(STADT s){
        stadt = s;
    }
    
    public boolean getBesucht(){
        return besucht;
    }
    
    public void setBesucht(boolean b){
        besucht = b;
    }
    
}
