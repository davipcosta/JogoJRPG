public class Armadura {
    private int defense;

    public Armadura()
    {
        this.defense = 0;

    }

    public Armadura(int defense)
    {
        this.defense = defense;
    }

    public void setdefense(int defense)
    {
        if(defense>0)
        {
            this.defense=defense;
        }
    }

    public int getdefenseConst()
    {
        return defense;
    }

    public static double ArmaduraSimples(int constituicao, int defenseConst){
        double ArmaduraLeve = defenseConst + (1.5*constituicao);
        return ArmaduraLeve;
    }

    public static double ArmaduraMedia(int constituicao, int defenseConst){
        double ArmaduraMedia = defenseConst + (1.5*constituicao);
        return ArmaduraMedia;
    }

    public static double ArmaduraPesada(int constituicao, int defenseConst){
        double ArmaduraPenseda = defenseConst + (1.5*constituicao);
        return ArmaduraPenseda;
    }
}