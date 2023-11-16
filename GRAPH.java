
/**
 * Beschreiben Sie hier die Klasse GRAPH.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GRAPH
{
    //Deklariere zweidimensionales Array mit dem Namen kanten 
    private int kanten[][];
    private int anzahl;
    private KNOTEN[] knoten;
    
    /**
     * Konstruktor für Objekte der Klasse GRAPH
     */
    public GRAPH(int maxKnoten)
    {
        //Initialisiere das zweidim. Array mit der Größe 12 x 12
        kanten = new int[maxKnoten][maxKnoten];
        knoten = new KNOTEN[maxKnoten];
        anzahl = 0;
    }

    public void breitendurchlauf(String startknoten){
        int start = nenneIndexVon(startknoten);
        if(start == -1){
            return;
        }
        //Erstellen der Warteschlange
        WARTESCHLANGE w = new WARTESCHLANGE(anzahl);
        
        for(int i = 0; i<anzahl ; i++){
            //Alle Knoten werden auf besucht = false gesetzt
            knoten[i].setBesucht(false);
        }
        //Startknoten in die Warteschlange einreihen
        w.hintenEinreihen(knoten[start]);
        
        while(!w.istLeer()){
            int index = nenneIndexVon(w.vorneEntnehmen().getStadt().getName());
            System.out.println(knoten[index].getStadt().getName());
            
            for(int i = 0; i<anzahl; i++){
                if(kanten[index][i] == 1 && !knoten[i].getBesucht()){
                    knoten[i].setBesucht(true);
                    System.out.println(knoten[i].getStadt().getName()+" ist besucht.");
                    w.hintenEinreihen(knoten[i]);
                }
            }
            System.out.println("Der Ausgangsknoten"+knoten[index].getStadt().getName()+" ist abgearbeitet");
            
            
            
        }
        
        
    }
    
    public boolean erstelleKante(String von, String nach, int gewicht, boolean ungerichtet){
        int indexVon = nenneIndexVon(von);
        int indexNach = nenneIndexVon(nach);
        if(indexVon >= 0 && indexNach >= 0){
            kanten[indexVon][indexNach] = gewicht;
            if(ungerichtet){
                kanten[indexNach][indexVon] = gewicht;
            }
            return true;
        }
        return false;
    }
    
    /**
     * Man fügt im knoten-Array an die letzte freie Stelle eine neue Stadt ein.
     * Die Methode liefert true, falls das Einfügen funktioniert hat und false, falls
     * das knoten-Array bereits voll ist.
     */
    public boolean erstelleKnoten(STADT s){
        if(anzahl < knoten.length){
            knoten[anzahl] = new KNOTEN(s);
            anzahl++;
            return true;
        }
        return false;
    }
    
    /**
     * Durchsucht das Array knoten nach dem Stadtnamen stadtnamen und gibt den Index
     * im Array zurück.
     * Falls die Stadt im Array nicht existiert, dann gibt -1 zurück;
     */
    public int nenneIndexVon(String stadtname){
        for(int i = 0; i < anzahl; i++){
            if(stadtname.compareToIgnoreCase(knoten[i].getStadt().getName()) == 0 ){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Methode zur Ausgabe der Adjazenzmatrix
     */
    public void matrixAusgeben(){
        for(int r = 0; r < kanten.length; r++){
            for(int s = 0 ; s < kanten.length; s++){
                System.out.print(kanten[r][s]);
            }
            System.out.println();
        }
    }
}
