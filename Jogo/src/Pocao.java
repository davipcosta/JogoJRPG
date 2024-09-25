import java.util.Random;

public class Pocao {
    private int pontos;


    public Pocao(int pontos)
    {
        setPontos(pontos);
    }

    public void setPontos(int pontos) {
        if(pontos>0){
            this.pontos = pontos;
        }

        
    }


    public int getPontos() {
        return pontos;
    }

    public static int dado6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static int usarPocao( int pontos) {
        
        
            pontos = dado6() + dado6() + dado6();
            return pontos;
           
}
}