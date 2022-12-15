public class Planet {
    // P >int> <int> <int> <float> <int> <string>
    //lastnosti
    public int ime;
    public int x;
    public int y;
    public float velikost;
    public int stLadij;
    public String color;


    //konstruktor
    public Planet (String[] t){
        this.ime= Integer.parseInt(t[1]);
        this.x= Integer.parseInt(t[2]);
        this.y= Integer.parseInt(t[3]);
        this.velikost=Float.parseFloat(t[4]);
        this.stLadij=Integer.parseInt(t[5]);
        this.color=t[6];
    }

    public String getColor(){
        return this.color;
    }

    public int getIme(){
        return this.ime;
    }


}
