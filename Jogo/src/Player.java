import java.util.Random;
import java.util.Scanner;

public final class Player {
    private String name;
    private double  pv;
    private int forc;
    private int constit;
    private int agil;
    private int destr;
    private Armas arma;
    private Armadura armadura;

    // Salva os valores iniciais para poder reiniciá-los
    private final double initialPV;
    private final int initialForc;
    private final int initialConstit;
    private final int initialAgil;
    private final int initialDestr;

    public static int dado6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public Player(String name, int pv, int constit, int forc, int agil, int destr, Armas arma, Armadura armadura) {
        setName(name);
        setPv(pv);
        setForc(forc);
        setConstit(constit);
        setAgil(agil);
        setDestr(destr);
        setArmas(arma);

        this.pv = dado6() + dado6() + dado6() + constit;

        // Armazena os valores iniciais dos atributos
        initialPV = this.pv;
        initialForc = forc;
        initialConstit = constit;
        initialAgil = agil;
        initialDestr = destr;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setPv(double pv) {
        if (pv > 0) {
            this.pv = pv;
        }
    }

    public double getPv() {
        return pv;  // Apenas retorna o valor atual de PV
    }
    public void setForc(int forc) {
        if (forc > 0) {
            this.forc = forc;
        }
    }

    public int getForc() {
        return forc;
    }

    public void setConstit(int constit) {
        if (constit > 0) {
            this.constit = constit;
        }
    }

    public int getConstit() {
        return constit;
    }

    public void setAgil(int agil) {
        if (agil > 0) {
            this.agil = agil;
        }
    }

    public int getAgil() {
        return agil;
    }

    public void setDestr(int destr) {
        if (destr > 0) {
            this.destr = destr;
        }
    }

    public int getDestr() {
        return destr;
    }

    public void setArmas(Armas arma) {
        this.arma = arma;
    }

    public Armas getArmas() {
        return arma;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    // Função para continuar ou reiniciar o jogo
   

    // Função para reiniciar os status do personagem para os valores iniciais
    public void reiniciarStatus() {
        this.pv = initialPV;
        this.forc = initialForc;
        this.constit = initialConstit;
        this.agil = initialAgil;
        this.destr = initialDestr;
    }

    // Função para exibir os status atuais do personagem
    public void exibirStatus() {
        System.out.println("Status do personagem:");
        System.out.println("Nome: " + name);
        System.out.println("Pontos de Vida: " + pv);
        System.out.println("Força: " + forc);
        System.out.println("Constituição: " + constit);
        System.out.println("Agilidade: " + agil);
        System.out.println("Destreza: " + destr);
    }
    public void DistribuirPontos(int fase) {
        Scanner input = new Scanner(System.in);
    
        // Define os pontos com base na fase
        int pontosIniciais = 0;
        switch (fase) {
            case 1:
                pontosIniciais = 15;  
                break;
            case 2:
                pontosIniciais = 5;   
                break;
            case 3:
                pontosIniciais = 10;  
                break;
            case 4:
                pontosIniciais = 8;
                break;
            default:
                System.out.println("Fase inválida! Reiniciando...");
                return;  
        }
    
        System.out.println("Você possui " + pontosIniciais + " pontos para distribuir.");
        System.out.println("1. Força: " + forc);
        System.out.println("2. Constituição: " + constit);
        System.out.println("3. Agilidade: " + agil);
        System.out.println("4. Destreza: " + destr);
    
        int loop = 1;
    
        while (loop == 1) {
            // Pega os valores atuais dos atributos
            forc = getForc();
            constit = getConstit();
            agil = getAgil();
            destr = getDestr();
    
            int points = pontosIniciais;  // Reinicia os pontos disponíveis para distribuir
    
            // Variáveis temporárias para armazenar os pontos distribuídos
            int tempForc = 0;
            int tempConstit = 0;
            int tempAgil = 0;
            int tempDestr = 0;
    
            boolean pontosValidos = false;
    
            // Loop para a distribuição de pontos
            while (!pontosValidos) {
                // Reinicia os pontos temporários e os pontos totais ao estado original
                points = pontosIniciais;
                tempForc = 0;
                tempConstit = 0;
                tempAgil = 0;
                tempDestr = 0;
    
                // Distribuição de Força
                System.out.println("Pontos de Atributos: " + points);
                System.out.println("Insira a quantidade para Força:");
                tempForc = input.nextInt();
                if (tempForc > points) {
                    System.out.println("Pontos insuficientes! Reiniciando a distribuição...");
                    continue;  // Reinicia a distribuição
                }
                points -= tempForc;
    
                // Distribuição de Constituição
                System.out.println("Pontos de Atributos: " + points);
                System.out.println("Insira a quantidade para Constituição:");
                tempConstit = input.nextInt();
                if (tempConstit > points) {
                    System.out.println("Pontos insuficientes! Reiniciando a distribuição...");
                    continue;  // Reinicia a distribuição
                }
                points -= tempConstit;
    
                // Distribuição de Agilidade
                System.out.println("Pontos de Atributos: " + points);
                System.out.println("Insira a quantidade para Agilidade:");
                tempAgil = input.nextInt();
                if (tempAgil > points) {
                    System.out.println("Pontos insuficientes! Reiniciando a distribuição...");
                    continue;  // Reinicia a distribuição
                }
                points -= tempAgil;
    
                // Distribuição de Destreza
                System.out.println("Pontos de Atributos: " + points);
                System.out.println("Insira a quantidade para Destreza:");
                tempDestr = input.nextInt();
                if (tempDestr > points) {
                    System.out.println("Pontos insuficientes! Reiniciando a distribuição...");
                    continue;  // Reinicia a distribuição
                }
                points -= tempDestr;
    
                // Verifica se os pontos foram distribuídos corretamente
                if (points < 0) {
                    System.out.println("Pontos negativos detectados! Reiniciando a distribuição...");
                } else {
                    pontosValidos = true;  // Saída do loop caso os pontos estejam corretos
                }
            }
    
            // Atribuir os valores temporários aos atributos reais
            forc = tempForc + getForc();
            constit = tempConstit + getConstit();
            agil = tempAgil + getAgil();
            destr = tempDestr + getDestr();
    
            // Exibir os valores finais dos atributos após a distribuição
            System.out.println("Distribuição final de atributos:");
            System.out.println("1. Força: " + forc);
            System.out.println("2. Constituição: " + constit);
            System.out.println("3. Agilidade: " + agil);
            System.out.println("4. Destreza: " + destr);
    
            // Opção para continuar ou não
            System.out.println("Você deseja continuar, ou resetar seus status?");
            System.out.println("1. Continuar");
            System.out.println("2. Resetar");
    
            int opc = input.nextInt();
    
            if (opc == 1) {
                break;  // Sai do loop e finaliza o processo
          } else if (opc == 2) {
            reiniciarStatus();  // Chama a função para reiniciar os status do personagem
            System.out.println("Os status foram reiniciados.");
            exibirStatus();  // Mostra os novos status após o reset
        } else {
            System.out.println("Escolha inválida, tente novamente.");
            // Pergunta novamente se a escolha for inválida
        }
            }
        }
    }
    

        
    
