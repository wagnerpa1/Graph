public class GRAPH
{
    private int[][] kanten;
    private KNOTEN knoten[];
    int anzahl;
    int t = 0;
    
    public GRAPH(int maxKnoten)
    {
        kanten=new int[maxKnoten][maxKnoten];
        knoten=new KNOTEN[maxKnoten];
        //kanten[2][7] = 42;
        for(int r=0; r<kanten.length; r++){
            for(int c=0; c<kanten.length; c++){
                kanten[r][c]=-1;
            }
        }
    }

    public void breitendurchauf(String startknoten){
        int s = nenneIndexVon(startknoten);
        if(s==-1){
            return;
        }
        for(int i=0;i<knoten.length;i++){
            knoten[i].besuchtSetzen(false);
        }
        knoten[s].besuchtSetzen(true);
        WARTESCHLANGE w= new WARTESCHLANGE(anzahl);
        w.hintenEinreihen(knoten[s]);
        while(w.istLeer()){
            t = nenneIndexVon(w.vorneEntnehmen().gibStadt().gibName());
            System.out.println(knoten[t].gibStadt().gibName());
            for(int i=0;i<knoten.length;i++){
                if(kanten[t][i]>0 && !knoten[i].besucht){
                    knoten[i].besuchtSetzen(true);
                    System.out.println(knoten[i].gibStadt().gibName() + " ist besucht");
                    w.hintenEinreihen(knoten[i]);
                }
                System.out.println(knoten[t].gibStadt().gibName()+" ist feritg");
            }
        }
        }

    public boolean erstelleKante(String von, String nach, int gewicht, boolean ungerichtet){
        int indexVon=nenneIndexVon(von);
        int indexNach=nenneIndexVon(nach);
        if(indexVon>-1 && indexNach>-1){
            kanten[indexVon][indexNach]= gewicht;
            if(ungerichtet){
                kanten[indexNach][indexVon]= gewicht;
            }
            return true;
        }
        return false;
    }

    public boolean erstelleKnoten(STADT stadt){
        if(anzahl<knoten.length){
            knoten[anzahl]=new KNOTEN(stadt);
            anzahl++;
            return true;
        }else{
            return false;
        }
    }

    public int nenneIndexVon(String stadtname){
        for(int i=0; i<anzahl; i++){
            if(stadtname.compareToIgnoreCase(knoten[i].gibStadt().gibName())==0){
                return i;
            }
        }
        return -1;
    }

    public void matrixAusgeben(){
        for(int r=0; r<kanten.length; r++){
            for(int c=0; c<kanten.length; c++){
                System.out.print(kanten[r][c]+"    ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void matrixAusgebenschön(){
        System.out.print("0 |  ");
        for(int r=1; r<(kanten.length+1); r++){
            System.out.print(r+"  |  ");
        }
        System.out.println();
        for(int r=0; r<kanten.length; r++){
            if(String.valueOf(kanten[r][1]).length()==1){
                System.out.print((r+1)+" |  ");
            }else{
                System.out.print((r+1)+" | ");
            }
            for(int c=0; c<kanten.length; c++){
                if(String.valueOf(kanten[r][1]).length()==1){
                    System.out.print(kanten[r][c]+"  |  ");
                }else{
                    System.out.print(kanten[r][c]+"  | ");
                }
            }
            System.out.println();
            System.out.print("--|");
            for(int i=0; i<kanten.length; i++){
                System.out.print("-----|");
            }
            System.out.println();
        }
    }
}
