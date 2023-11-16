
/**
 * Beschreiben Sie hier die Klasse KUNDENWARTESCHLANGE.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class WARTESCHLANGE
{
    private int anzahl;
    private int max_anzahl;
    private KNOTEN[] knoten;

    /**
     * Konstruktor für Objekte der Klasse KUNDENWARTESCHLANGE
     */
    public WARTESCHLANGE(int länge)
    {
        anzahl = 0;
        max_anzahl = länge;
        knoten = new KNOTEN[länge];

    }

    /**
     * Reiht neue Kunden in die Warteschlange ein.
     * @return: True, falls der Kunde eingereiht werden konnte
     *          False, falls der Kunde nicht eingereiht werden konnte
     */
    public boolean hintenEinreihen(KNOTEN k){
        if(istVoll()){
            return false;
        } else {
            knoten[anzahl] = k;
            anzahl++;
            return true;
        }
    }

    public boolean istLeer(){
        if(anzahl == 0){
            return true;
        } else {
            return false;
        }

    }

    public boolean istVoll(){
        if(anzahl == max_anzahl){
            return true;
        } else {
            return false;
        }

    }

    public int nenneAnzahl(){
        return anzahl;
    }

    public KNOTEN vorneEntnehmen(){
        KNOTEN temp = knoten[0];
        for(int i = 0; i<max_anzahl-1; i++){
            knoten[i] = knoten[i+1];
        }
        anzahl--;
        knoten[anzahl] = null;
        return temp;
    }

}
