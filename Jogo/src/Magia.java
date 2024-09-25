public class Magia {
    private int poderMagico;  // Poder mágico da luz

    public Magia(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        if (poderMagico > 0) {
            this.poderMagico = poderMagico;
        }
    }

    // Aumenta o dano de uma arma leve pela magia da luz
    public double amplificarDanoLeve(double danoArmaLeve) {
        double bonus = (poderMagico * 0.2);  // Magia aumenta 20% do poder mágico
        return danoArmaLeve + bonus;
    }

    // Aumenta o dano de uma arma pesada pela magia da luz
    public double amplificarDanoPesado(double danoArmaPesada) {
        double bonus = (poderMagico * 0.3);  // Magia aumenta 30% do poder mágico
        return danoArmaPesada + bonus;
    }
}

