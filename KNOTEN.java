public class KNOTEN
{
    private STADT stadt;
    boolean besucht;
    public KNOTEN(STADT stadt)
    {
        this.stadt = stadt;
        besucht=false;
    }

    public void setzeStadt(STADT stadt){
        this.stadt=stadt;
    }

    public STADT gibStadt(){
        return stadt;
    }
    
    public boolean besucht(){
        return besucht;
    }
    
    public void besuchtSetzen(boolean besucht){
        this.besucht = besucht;
    }
}
