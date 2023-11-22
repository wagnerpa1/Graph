public class WARTESCHLANGE
{
    private int anzahl;
    private int maxAnzahl;
    private KNOTEN[] knoten;

    public WARTESCHLANGE(int länge)
    {
        maxAnzahl=länge;
        anzahl=0;
        knoten=new KNOTEN[länge];
    }
    
    public boolean istLeer(){
        return anzahl==0;
    }
    
    public boolean istVoll(){
        return anzahl==maxAnzahl;
    }
    
    public int nanneAnzahl(){
        return anzahl;
    }
    
    public boolean hintenEinreihen(KNOTEN k){
        if(this.istVoll()){
            return false;
        }
        else{
            knoten[anzahl]=k;
            anzahl++;
            return true;
        }
    }
    
    public KNOTEN vorneEntnehmen(){
        KNOTEN temp=knoten[0];
        knoten[0]=null;
        anzahl--;
        for(int i=0;i<knoten.length-1;i++){
            knoten[i]=knoten[i+1];
        }
        knoten[anzahl]=null;
        return temp;
    }
}

