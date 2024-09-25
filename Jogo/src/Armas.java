import java.util.Random;

public class Armas {
    private String category;
   private int constDamage;

  

    public Armas()
    {
        this.category = " ";
        this.constDamage = 0;
    }

    public Armas(String category, int constDamage)
    {
        this.category = category;
        this.constDamage = constDamage;
    }

    public void setCategory(String category)
    {
        if(category.length()>0) {
            this.category = category;
        } 
    }

    public String getCategory()
    {
        return category;
    }

    public void setconstDamage(int constDamage)
    {
        if(constDamage>0)
        {
            this.constDamage=constDamage;
        }
    }

    public int getconstDamage(){
        return constDamage;
    }

    // Função para sortear um número entre 1 e 4
    public static int dado4() {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }

    // Função para sortear um número entre 1 e 6
    public static int dado6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Função para sortear um número entre 1 e 12
    public static int dado12() {
        Random random = new Random();
        return random.nextInt(12) + 1;
    }

    public static double ArmaLeve1(int destreza, int constDamage) {
        double danoArmaLeve = constDamage + dado4() + dado4() + dado4() + destreza;
        return danoArmaLeve;
    }

    public static double ArmaLeve(int destreza, int constDamage, Magia magia){
        double danoArmaLeve = constDamage + dado4() + dado4() + dado4() + destreza;
        if (magia != null) {
            danoArmaLeve = magia.amplificarDanoLeve(danoArmaLeve);
        }
        return danoArmaLeve;
    }
    public static double ArmaPesada1(int forca, int constDamage) {
        double danoArmaLeve = constDamage + dado4() + dado4() + dado4() + forca;
        return danoArmaLeve;
    }

    public static double ArmaPesada(int forca, int constDamage, Magia magia){
        double danoArmaPesada = constDamage + dado12() + (1.5*forca);
        if (magia != null) {
            danoArmaPesada = magia.amplificarDanoPesado(danoArmaPesada);
        }
        return danoArmaPesada;
    }
}