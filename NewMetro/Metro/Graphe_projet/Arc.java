
public class Arc
{
    public int distance;
    public String nomArc;


    public Arc()
    {
        this.distance = 0;
        this.nomArc="";
    }

    public Arc(int distance, String nomArc)
    {
        this.distance = distance;
        this.nomArc= nomArc;
    }


    public void setDistance(int distance)
    {
        this.distance = distance;
    }



    public void setArc(String nomArc)
    {
        this.nomArc = nomArc;
    }



    public int getDistance()
    {
        return this.distance;
    }



    /**
     *
     */
    public String getArc()
    {
        return this.nomArc;
    }

    public String affichage()
    {
        return this.distance+" "+this.nomArc;
    }
}
