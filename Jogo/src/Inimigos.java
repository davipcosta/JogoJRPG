public final class Inimigos {
    private String name;
    private double pv;
    private int forca;
    private int defense;
    private int agil;

    public Inimigos(String name, double pv, int forca, int defense, int agil){
        setinimigoName(name);
        this.pv = pv;
        setinimigoForca(forca);
        this.defense= defense;
        this.agil=agil;
    }


    public void setinimigoName(String name)
    {
        if(name.length()>0) {
            this.name = name;
        } 
    }

    public void setinimigoPv(double pv)
    {
        if(pv>0){
            this.pv=pv;
        }
    }

    public void setinimigoDefense(int defense)
    {
        if(defense>0){
            this.defense=defense;
        }
    }

    public void setinimigoForca(int forca)
    {
        if(forca>0){
            this.forca=forca;
        }
    }
    public void setinimigoAgil(int agil)
    {
        if(agil>0){
            this.agil=agil;
        }
    }

    public String getinimigoName(){
        return name;
    }
    public double getinimigoPv(){
        return pv;
    }
    public int getinimigoForca(){
        return forca;
    }

    public int getinimigoDefense(){
        return defense;
    }
    public int getinimigoAgil(){
        return agil;
    }
}