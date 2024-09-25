import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public static void Clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public static int dado4() {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }

    public static int dado6() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public static int dado12() {
        Random random = new Random();
        return random.nextInt(12) + 1;
    }   

    public static void main (String args[]) throws InterruptedException
    {
        Scanner input;
        Scanner nome;
        int opc;
        
        
        while(true){
        input = new Scanner(System.in);
        nome = new Scanner(System.in);
        Texto texto = new Texto();
        Pocao pocaoCura = new Pocao(0);      
        
        String name;
        Random rand = new Random();      

        System.out.println("\t\t\t\t\t\t1) Jogar\t2) História\t3) Sair");
        System.out.println("\n\n");
        opc = input.nextInt();
        
        if(opc==1){
        Clear();
        while(true){

    
        Texto.Tutorial();   
        //Input nome
        System.out.println("Após uma grande dor de cabeça, e pequenos flashs de memória, uma das suas maiores lembranças é seu nome, e qual seria?");
        name = nome.nextLine();
        Player player = new Player(name,0, 0,0,0,0,new Armas(),new Armadura());
        
        double playerPV;                   
        playerPV = player.getPv();
        player.setPv(playerPV);
    

        Clear();
    
        //Atribuir pontos
        System.out.println("Olá "+player.getName()+"! Como deseja distribuir seu pontos?");       
        player.DistribuirPontos(1);
        
        Clear();
               
        Armas katana = new Armas("(Armas leve)\n", 8); 
        Armas adaga = new Armas("(Arma Leve)\n", 8);
        Armas espadalonga = new Armas("(Arma pesada)", 8); 
        System.out.println("Escolha sua arma:");
        System.out.println("1. Katana "+katana.getCategory()+"2. Adaga "+adaga.getCategory()+"3. Espada Longa "+espadalonga.getCategory());
        int escolhaArmas = input.nextInt();
        
        Clear();
        
        //->Definição do dano da Armas
        double danoplayer =0, danoplayerLeve=0, danoplayerPesado =0;
        
        if (escolhaArmas == 1) {
            // Cálculo do dano para arma leve (katana)
            danoplayerLeve = Armas.ArmaLeve1(player.getDestr(), katana.getconstDamage());
            System.out.println("Você irá causar:");
            System.out.println(danoplayerLeve + " de dano.");
            danoplayer += danoplayerLeve;
        } else if (escolhaArmas == 2) {
            // Cálculo do dano para arma leve (adaga)
            danoplayerLeve = Armas.ArmaLeve1(player.getDestr(), adaga.getconstDamage());
            System.out.println("Você irá causar:");
            System.out.println(danoplayerLeve + " de dano.");
            danoplayer += danoplayerLeve;
        } else if (escolhaArmas == 3) {
            // Cálculo do dano para arma pesada (foice)
            danoplayerPesado = Armas.ArmaPesada1(player.getForc(), espadalonga.getconstDamage());
            System.out.println("Você irá causar:");
            System.out.println(danoplayerPesado + " de dano.");
            danoplayer += danoplayerPesado;
        }
    
        System.out.println("1) Continue");
        opc = input.nextInt();
        Clear();

        //Escolher Armadura
        Armadura capuznegro = new Armadura(7);
        Armadura cavaleiro = new Armadura(7);
        Armadura capaamanha = new Armadura(7);
        System.out.println("Agora escolha sua armadura:");
        System.out.println("1) Capuz Negro   2) Armadura de Cavaleiro   3) Capa do Amanhã");
        int escolhaArmadura = input.nextInt();

        Clear();

        //Definição Armadura
        double defenseplayer =0;
        if (escolhaArmadura==1) {
            defenseplayer = Armadura.ArmaduraSimples(player.getConstit(),capuznegro.getdefenseConst());
            System.out.println("Ao vestir esse capuz, você possui "+defenseplayer+" de defesa.");
        }else if (escolhaArmadura==2) {
            defenseplayer = Armadura.ArmaduraMedia(player.getConstit(), cavaleiro.getdefenseConst());
            System.out.println("Ao vestir essa armadura, você possui "+defenseplayer+" de defesa.");
        }else if (escolhaArmadura==3) {
            defenseplayer = Armadura.ArmaduraPesada(player.getConstit(), capaamanha.getdefenseConst());
            System.out.println("Ao vestir essa capa, você possui "+defenseplayer+" de defesa.");
        }      

        System.out.println("1) Continue");
        opc = input.nextInt();
        Clear();
        
        double pv = playerPV;
        //Exibição dos status do player
        System.out.println("Status de "+player.getName());
        System.out.println("PV: "+playerPV);
        System.out.println("Defesa: "+defenseplayer);
        System.out.println("Dano: " +danoplayer);
        System.out.println("Agilidade: " +player.getAgil());

        System.out.println("1) Continue");
        opc = input.nextInt();
        Clear();

        
        int cura = 3, curainimigo =3, curaboss = 3, curainimigo2 =3;
        //Lista de Inimigos combate 1
        List<Inimigos> inimigos1 = new ArrayList<>(); 
        inimigos1.add(new Inimigos("O Adorador da Morte", 70, 2, 50,2));
        inimigos1.add(new Inimigos("A Alma Corrompida", 60, 1, 50, 3));
        inimigos1.add(new Inimigos("INIMIGO 3", 90, 2, 50, 1));
        Inimigos inimigo = inimigos1.get(rand.nextInt(inimigos1.size()));

        double inimigoPV;                   
        inimigoPV = inimigo.getinimigoPv();
        inimigo.setinimigoPv(inimigoPV);  
       
        System.out.println(player.getName()+" se depara a uma floresta sombria e fria, onde a luz mal penetra. Gritos de ajuda ecoam entre as sombras, enquanto raízes e vegetação criam um labirinto traiçoeiro com diversos animais mortos no caminho.");
        System.out.println("Marcas estranhas nas árvores pulsam com uma energia obscura, intensificando a sensação de que algo maligno o observa. Após isso, de repente seu primeiro inimigo aparece, e ele será " +inimigo.getinimigoName());
        
        System.out.println("1) Continuar");
        opc = input.nextInt();
        Clear();

       while (true) {
    int agir;       
    // Combate para agilidade do player maior
    if (player.getAgil() > inimigo.getinimigoAgil()) {
        System.out.println(player.getName() + " é mais rápido e inicia atacando!");
        System.out.println(inimigo.getinimigoName() + " [PV: " + inimigoPV + "]  ");
        System.out.println(name + " [PV: " + playerPV + "] ");

        System.out.println("1) Atacar     2) Defender     3) Usar poção");
        agir = input.nextInt();

        if (agir == 1) {
            double danototal = inimigo.getinimigoDefense() - danoplayer;
            inimigoPV -= danototal;
            if (danototal < 0) danototal = 0;
            System.out.println("Você causou: " + danototal + " de dano");

        } else if (agir == 2) {
            double defensetotal = defenseplayer * 2;
            System.out.println("Sua defesa aumentou para: " + defensetotal);

        } else if (agir == 3) {
            if (cura > 0) {
                int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                playerPV += curaTotal;
                cura--;
                System.out.println("Você curou: " + curaTotal + " de vida");
            } else {
                System.out.println("Você não possui mais nenhuma poção");
            }
        }
        else{
            System.out.println("Esta não é uma opção válida");
            break;
        }

        // Verificação se o inimigo morreu
        if (inimigoPV <= 0) {
            System.out.println("O inimigo foi derrotado!");
            break;
        }

        System.out.println(" ");
        System.out.println("Turno do " + inimigo.getinimigoName());
        System.out.println(" ");

        int escolhaInimigo = rand.nextInt(3) + 1;
        if (escolhaInimigo == 1) {
            double danoInimigo = dado6() + dado6() + dado6() + inimigo.getinimigoForca();
            if (danoInimigo < 0) danoInimigo = 0;
            danoInimigo =  defenseplayer - danoInimigo;
            playerPV -= danoInimigo;
            System.out.println("Seu inimigo causou: " + danoInimigo + " de dano");
        } else if (escolhaInimigo == 2) {
            double def = inimigo.getinimigoDefense() * 2;
            System.out.println("Defesa inimiga aumentada para: " + def);
        } else if (escolhaInimigo == 3) {
            if (curainimigo > 0) {
                int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                inimigoPV += curaTotal;
                curainimigo--;
                System.out.println("O inimigo curou " + curaTotal + " de vida");
            } else {
                System.out.println("O inimigo tenta se curar mas ele não tem mais nenhuma poção!");
            }
        }

        if (playerPV <= 0) {
            System.out.println("GAME OVER");
            System.out.println("Aperte qualquer tecla para continuar");
            break;
        }

    } else if (player.getAgil() <= inimigo.getinimigoAgil()) {
        System.out.println(inimigo.getinimigoName() + " é mais rápido e inicia atacando!");
        System.out.println(inimigo.getinimigoName() + " [PV: " + inimigoPV + "] ");
        System.out.println(name + " [PV: " + playerPV + "] ");

        int escolhaInimigo = rand.nextInt(3) + 1;
        if (escolhaInimigo == 1) {
            double danoInimigo = dado6() + dado6() + dado6() + inimigo.getinimigoForca();
            danoInimigo = defenseplayer - danoInimigo;
            playerPV -= danoInimigo;
            System.out.println("Seu inimigo causou dano de: " + danoInimigo);
        } else if (escolhaInimigo == 2) {
            int def = inimigo.getinimigoDefense() * 2;
            System.out.println("Defesa aumentada para: " + def);
        } else if (escolhaInimigo == 3) {
            if (curainimigo > 0) {
                int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                inimigoPV += curaTotal;
                curainimigo--;
                System.out.println("O inimigo curou " + curaTotal + " de vida");
            } else {
                System.out.println("O inimigo tenta se curar mas ele não tem mais nenhuma poção!");
            }
        }

        if (inimigoPV <= 0) {
            System.out.println("O inimigo foi derrotado!");
            break;
        }

        System.out.println(" ");
        System.out.println("Turno do " + player.getName());
        System.out.println(" ");
        System.out.println(inimigo.getinimigoName() + " [PV: " + inimigoPV + "]  ");
        System.out.println(name + " [PV: " + playerPV + "] ");

        System.out.println("1) Atacar     2) Defender     3) Usar poção");
        agir = input.nextInt();

        if (agir == 1) {
            double danototal = inimigo.getinimigoDefense() - danoplayer;
            inimigoPV -= danototal;
            System.out.println("Você causou: " + danototal + " de dano");
        } else if (agir == 2) {
            double totaldefense = defenseplayer * 2;
            System.out.println("Sua defesa aumentou para: " + totaldefense);
        } else if (agir == 3) {
            if (cura > 0) {
                int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                playerPV += curaTotal;
                cura--;
                System.out.println("Você curou: " + curaTotal + " de PV");
            } else {
                System.out.println("Você não tem mais cura");
            }
        }

        if (inimigoPV <= 0 || playerPV <= 0) {
            break;
        }
    }

    if (playerPV <= 0) {
        System.out.println("GAME OVER");
        System.out.println("Aperte qualquer tecla para continuar");
        break;
    }
}

        Clear();
        if (playerPV > 0) {
            System.out.println("Você finaliza o inimigo e ganha mais pontos para distribuir, ou mantém o seu inimigo vivo e o deixa fugir, qual sua escolha?");
            System.out.println("1. Deixar ele fugir");
            System.out.println("2. Finalizar o inimigo");
            opc = input.nextInt();
        inimigoPV=0;
        }

        if (inimigoPV <= 0 && opc == 1) {
            System.out.println("Você foi generoso e deixou seu inimigo fugir, e com isso, sentiu uma força misteriosa fluindo dentro de você...");
            System.out.println(player.getName() + " subiu para o nível 2!");
            System.out.println(player.getName() + " recebeu mais 5 pontos para atributos!");
        
            player.DistribuirPontos(2);
        
            // Nova PV do player
            System.out.println("PV de " + player.getName() + " aumentou!");
            playerPV = pv + player.getConstit();
            System.out.println("Seus novos PV são: " + playerPV);
        
            // Escolha da nova arma
            System.out.println("Novas armas podem ser escolhidas!");
            Armas laminaradiante = new Armas("(Arma Leve)\n", 20);
            Armas dragonslayer = new Armas("(Arma Pesada)\n", 20);
            Armas justica = new Armas("(Arma Pesada)", 20);
            System.out.println("Escolha sua nova arma:");
            System.out.println("1) Lâmina Radiante " + laminaradiante.getCategory() + "2) Dragon Slayer " + dragonslayer.getCategory() + "3) Espada da Justiça " + justica.getCategory());
            int escolhaArmas2 = input.nextInt();
        
            // Ativar magia de luz, já que o jogador escolheu o caminho 1
            Magia magiaDeLuz = new Magia(10);  
        
            // Definição do dano da nova arma com a magia de luz
            double danoplayerLeve2 = 0, danoplayerPesado2 = 0;
            if (escolhaArmas2 == 1) {
                danoplayerLeve2 = Armas.ArmaLeve(player.getDestr(), laminaradiante.getconstDamage(), magiaDeLuz);
                System.out.println("Você causa:");
                System.out.println(danoplayerLeve2 + " de dano com a magia de luz\n");
                danoplayer = danoplayerLeve2;
            } else if (escolhaArmas2 == 2) {
                danoplayerPesado2 = Armas.ArmaPesada(player.getForc(), dragonslayer.getconstDamage(), magiaDeLuz);
                System.out.println("Você causa:");
                System.out.println(danoplayerPesado2 + " de dano com a magia de luz\n");
                danoplayer = danoplayerPesado2;
            } else if (escolhaArmas2 == 3) {
                danoplayerPesado2 = Armas.ArmaPesada(player.getForc(), justica.getconstDamage(), magiaDeLuz);
                System.out.println("Você causa:");
                System.out.println(danoplayerPesado2 + " de dano com a magia de luz\n");
                danoplayer = danoplayerPesado2;
            }
        
        } else if (inimigoPV <= 0 && opc == 2) {
            System.out.println("Você assassinou o inimigo de forma fria...");
            System.out.println(player.getName() + " subiu para o nível 2!");
            System.out.println(player.getName() + " recebeu mais 8 pontos para atributos!");
        
            player.DistribuirPontos(4);
        
            // Nova PV do player
            System.out.println("PV de " + player.getName() + " aumentou!");
            playerPV = pv + player.getConstit();
            System.out.println("Seus novos PV são: " + playerPV);
        
            // Escolha da nova arma
            System.out.println("Novas armas podem ser escolhidas!");
            Armas lamina = new Armas("(Arma Leve)\n", 15);
            Armas dragonslayer = new Armas("(Arma Pesada)\n", 15);
            Armas foice = new Armas("(Arma Pesada)", 15);
            System.out.println("Escolha sua nova arma:");
            System.out.println("1) Lâmina Espectral " + lamina.getCategory() + "2) Dragon Slayer " + dragonslayer.getCategory() + "3) Foice do Vazio" + foice.getCategory());
            int escolhaArmas2 = input.nextInt();
        
            // Sem magia de luz, caminho 2
            // Definição do dano da nova arma sem a magia de luz
            double danoplayerLeve2 = 0, danoplayerPesado2 = 0;
            if (escolhaArmas2 == 1) {
                danoplayerLeve2 = Armas.ArmaLeve(player.getDestr(), lamina.getconstDamage(), null);  // Sem magia de luz
                System.out.println("Você causa:");
                System.out.println(danoplayerLeve2 + " de dano\n");
                danoplayer = danoplayerLeve2;
            } else if (escolhaArmas2 == 2) {
                danoplayerPesado2 = Armas.ArmaPesada(player.getForc(), dragonslayer.getconstDamage(), null);  // Sem magia de luz
                System.out.println("Você causa:");
                System.out.println(danoplayerPesado2 + " de dano\n");
                danoplayer = danoplayerPesado2;
            } else if (escolhaArmas2 == 3) {
                danoplayerPesado2 = Armas.ArmaPesada(player.getForc(), foice.getconstDamage(), null);  // Sem magia de luz
                System.out.println("Você causa:");
                System.out.println(danoplayerPesado2 + " de dano\n");
                danoplayer = danoplayerPesado2;
            }
        }
        //Lista de Inimigos combate 2
        List<Inimigos> inimigos2 = new ArrayList<>();
        inimigos2.add(new Inimigos("O Cérbero", 200, 4, 100,3));
        inimigos2.add(new Inimigos("O Ceifador", 250, 5, 100, 2));
        Inimigos inimigo2 = inimigos2.get(rand.nextInt(inimigos2.size()));

        double inimigoPV2;                   
        inimigoPV2 = inimigo2.getinimigoPv();
        inimigo2.setinimigoPv(inimigoPV2);
        

        cura = 3;

        //Combate 2
        System.out.println(player.getName()+ " entra em uma mina silenciosa e macabra, onde a escuridão é densa e o cheiro de mofo predomina. Esqueletos estão espalhados pelo chão, alguns presos a ferramentas, sugerindo uma enorme tragédia.");
        System.out.println("O silêncio é perturbador, com ecos de gotas d'água, enquanto "+player.getName()+" sente a presença de algo assustador o observando.");
        System.out.println("Aparece no local " +inimigo2.getinimigoName()+ " com sua presença aterrorizante, se prepare!\n");

        System.out.println("1) Continue");
        opc = input.nextInt();
        Clear();

        while (true) {

            
            
            int agir2;   
            
            
            //Combate para agilidade do player maior
            if (player.getAgil() > inimigo2.getinimigoAgil()) {
                System.out.println(player.getName() + " é mais rápido e inicia atacando!");
                System.out.println(inimigo2.getinimigoName() + " [PV: " + inimigoPV2 + "]  ");
                System.out.println(name + " [PV: " + playerPV + "]  ");
                System.out.println("1) Atacar   2) Defender   3) Curar\n");
                agir2 = input.nextInt();
        
                if (agir2 == 1) {
           
                    double danototal = inimigo2.getinimigoDefense() - danoplayer;
                    inimigoPV2 -= danototal;
                    if (danototal < 0) danototal = 0;
                    System.out.println("\nVocê causou: " + danototal + " de dano");
        
                    // Verifica se o inimigo morreu logo após o ataque
                    if (inimigoPV2 <= 0) {
                        System.out.println("\nO inimigo foi derrotado!");
                        break; // Sai do loop já que o inimigo foi derrotado
                    }
        
                } else if (agir2 == 2) {
                    double defensetotal = defenseplayer * 2;
                    System.out.println("\nSua defesa aumentou para: " + defensetotal);
                } else if (agir2 == 3) {
                    if (cura > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        playerPV += curaTotal;
                        cura--;
                        System.out.println("\nVocê curou: " + curaTotal + " de PV");
                    } else {
                        System.out.println("\nVocê não possui mais cura");
                    }
                }
        
                // Turno do inimigo, mas só acontece se ele ainda estiver vivo
                System.out.println(" ");
                System.out.println("Turno do Inimigo");
                System.out.println(" ");
                int escolhaInimigo2 = rand.nextInt(3) + 1;
        
                if (escolhaInimigo2 == 1) {
                    double danoInimigo2 = dado6() + dado6() + dado6() + inimigo2.getinimigoForca();
                    double danoInimigo2total = defenseplayer - danoInimigo2;
                    if (danoInimigo2total < 0) danoInimigo2total = 0;
                    playerPV -= danoInimigo2total;
                    System.out.println("Seu inimigo causou dano de: " + danoInimigo2total);
                } else if (escolhaInimigo2 == 2) {
                    int def2 = inimigo2.getinimigoDefense() * 2;
                    System.out.println("Defesa inimiga aumentada para: " + def2);
                } else if (escolhaInimigo2 == 3) {
                    if (curainimigo2 > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        inimigoPV2 += curaTotal;
                        curainimigo2--;
                        System.out.println("O inimigo curou " + curaTotal + " de PV");
                    } else {
                        System.out.println("O inimigo tenta se curar, mas ele não tem mais cura");
                    }
                }
        
                if (playerPV <= 0 || inimigoPV2 <= 0) {
                    break; // Se o jogador ou o inimigo morrer, o loop é interrompido
                }
        
            } else { // Combate quando a agilidade do inimigo é maior
                System.out.println(inimigo2.getinimigoName() + " é mais rápido e inicia atacando!");
                System.out.println(inimigo2.getinimigoName() + " [PV: " + inimigoPV2 + "]   ");
                System.out.println(name + " [PV: " + playerPV + "]  ");
        
                int escolhaInimigo2 = rand.nextInt(3) + 1;
        
                if (escolhaInimigo2 == 1) {
                    double danoInimigo2 = dado6() + dado6() + dado6() + inimigo2.getinimigoForca();
                    double danoInimigo2total = defenseplayer - danoInimigo2;
                    if (danoInimigo2total < 0) danoInimigo2total = 0;
                    playerPV -= danoInimigo2total;
                    System.out.println("Seu inimigo causou dano de: " + danoInimigo2total);
                } else if (escolhaInimigo2 == 2) {
                    int def2 = inimigo2.getinimigoDefense() * 2;
                    System.out.println("Defesa inimiga aumentada para: " + def2);
                } else if (escolhaInimigo2 == 3) {
                    if (curainimigo2 > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        inimigoPV2 += curaTotal;
                        curainimigo2--;
                    } else {
                        System.out.println("O inimigo tenta se curar, mas ele não tem mais cura");
                    }
                }
        
                // Verifica se o inimigo foi derrotado após a ação do inimigo
                if (inimigoPV2 <= 0) {
                    System.out.println("O inimigo foi derrotado!");
                    break; // Sai do loop se o inimigo for derrotado
                }
        
                // Turno do jogador
                System.out.println("Seu turno: ");
                System.out.println(inimigo2.getinimigoName() + " [PV: " + inimigoPV2 + "] ");
                System.out.println(name + " [PV: " + playerPV + "]  ");
                System.out.println("1) Atacar   2) Defender   3) Curar");
                agir2 = input.nextInt();
        
                if (agir2 == 1) {
                    double danototal = inimigo2.getinimigoDefense() - danoplayer;
                    inimigoPV2 -= danototal;
                    if (danototal < 0) danototal = 0;
                    System.out.println("Você causou: " + danototal + " de dano");
        
                    // Verifica se o inimigo foi derrotado
                    if (inimigoPV2 <= 0) {
                        System.out.println("O inimigo foi derrotado!");
                        break; // Sai do loop já que o inimigo foi derrotado
                    }
        
                } else if (agir2 == 2) {
                    double defensetotal = defenseplayer * 2;
                    System.out.println("Sua defesa aumentou para: " + defensetotal);
                } else if (agir2 == 3) {
                    if (cura > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        playerPV += curaTotal;
                        cura--;
                        System.out.println("Você curou: " + curaTotal + " de PV");
                    } else {
                        System.out.println("Você não tem mais cura");
                    }
                }
        
                if (playerPV <= 0 || inimigoPV2 <= 0) {
                    break; // Se o jogador ou o inimigo morrer, o loop é interrompido
                }
            }
        }

        if(playerPV<=0)
        {

            System.out.println("GAME OVER");
            System.out.println("Aperte qualquer tecla para continuar");

           break; 
        }

        cura = 0;

        
        //Pós combate 2
        if (inimigoPV2<=0) 
        {
            System.out.println("Parabéns! Você concluiu o segundo combate");
            System.out.println("Subiu para o nível 3!");
            System.out.println("Mais 10 pontos para atributos!");

            player.DistribuirPontos(3);

            //Nova PV player
            System.out.println("\nSeus P.V aumentaram!");
            playerPV = pv + player.getConstit();
            System.out.println("Seus novos P.V são de: "+playerPV);

            //Escolha da nova Armas
            System.out.println("\nNovos equipamentos podem ser escolhidos!");
            Armadura esperanca = new Armadura( 15); 
            Armadura bersek = new Armadura( 15);
            Armadura escuridao = new Armadura( 15); 
            System.out.println("Agora escolha sua nova armadura:");
            System.out.println("1) Armadura da Esperança 2) Armadura do Berserk 3) Armadura da Escuridão");
            int escolhaArmadura2 = input.nextInt();         

            //->Definição do dano da nova Armas
             defenseplayer=0;
            if (escolhaArmadura2==1) {
                defenseplayer = Armadura.ArmaduraSimples(player.getConstit(), esperanca.getdefenseConst());
                System.out.println("Sua armadura aumenta sua defesa para "+defenseplayer);
                         
            }else if (escolhaArmadura2==2) {
                defenseplayer = Armadura.ArmaduraMedia(player.getConstit(), bersek.getdefenseConst());
                System.out.println("Sua armadura aumenta sua defesa para "+defenseplayer);
                
            }else if (escolhaArmadura2==3) {
                defenseplayer = Armadura.ArmaduraPesada(player.getConstit(), escuridao.getdefenseConst());
                System.out.println("Sua armadura aumenta sua defesa para "+defenseplayer);
                
            }

        }

        cura = 3;
        //Combate Boss
        Inimigos boss = new Inimigos("A Morte", 250, 6, 100, 4 );

        double bossPV;                   
        bossPV = boss.getinimigoPv();
        boss.setinimigoPv(bossPV);
        

        //diálogo antes da batalha contra o boss
        System.out.println("Após uma longa jornada repleta de desafios e decisões difíceis, "+player.getName()+ " finalmente chega a seu destino final, encontrando a própria morte em pessoa.");
        System.out.println("1) Continuar");
        opc = input.nextInt();
        Clear();

        while (true) {
            
            int agir3;   
            
            if (player.getAgil() > boss.getinimigoAgil()) {
                System.out.println(player.getName() + " é mais rápida e inicia atacando!");
                System.out.println(boss.getinimigoName() + " [PV: " + bossPV + "] ");
                System.out.println(name + " [PV: " + playerPV + "] ");
                System.out.println("1) Atacar   2) Defender   3) Curar");
                agir3 = input.nextInt();
                
                if (agir3 == 1) {
                    double danototal =boss.getinimigoDefense() - danoplayer;
                    bossPV -= danototal;
                    System.out.println("Você causou: " + danototal + " de dano");
        
                    // Verifica se o boss foi derrotado logo após o ataque
                    if (bossPV <= 0) {
                        System.out.println("A " +boss.getinimigoName()+ " foi derrotada!");
                        break; // Sai do loop já que o boss foi derrotado
                    }
                } else if (agir3 == 2) {
                    double defensetotal = defenseplayer * 2;
                    System.out.println("Sua defesa aumentou para: " + defensetotal);
                } else if (agir3 == 3) {
                    if (cura > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        playerPV += curaTotal;
                        cura--;
                        System.out.println("Você curou " + curaTotal + " de PV");
                    } else {
                        System.out.println("Você não possui mais cura");
                    }
                }
        
                // Turno do boss, mas só acontece se ele ainda estiver vivo
                System.out.println("Turno do Inimigo:");
                int escolhaInimigo3 = rand.nextInt(3) + 1;
        
                if (escolhaInimigo3 == 1) {
                    double danoBoss = dado6() + dado6() + dado6() + boss.getinimigoForca();
                    double danoBosstotal = defenseplayer - danoBoss;
                    playerPV -= danoBosstotal;
                    System.out.println("Seu inimigo causou dano de: " + danoBosstotal);
                } else if (escolhaInimigo3 == 2) {
                    int def3 = boss.getinimigoDefense() * 2;
                    System.out.println("Inimigo aumentou a defesa para: " + def3);
                } else if (escolhaInimigo3 == 3) {
                    if (curaboss > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        bossPV += curaTotal;
                        curaboss--;
                        System.out.println("Inimigo curou " + curaTotal + " de PV");
                    } else {
                        System.out.println("Inimigo tenta se curar, mas ele não tem mais cura");
                    }
                }
        
                if (bossPV <= 0 || playerPV <= 0) {
                    break; // Sai do loop se o boss ou o jogador morrer
                }
            } 
            // Combate quando a agilidade do boss é maior
            else if (player.getAgil() <= boss.getinimigoAgil()) {
                System.out.println(boss.getinimigoName() + " é mais rápido e inicia atacando!");
                System.out.println(boss.getinimigoName() + " [PV: " + bossPV + "] ");
                System.out.println(name + " [PV: " + playerPV + "] ");
        
                int escolhaInimigo3 = rand.nextInt(3) + 1;
        
                if (escolhaInimigo3 == 1) {
                    double danoBoss = dado6() + dado6() + dado6() + boss.getinimigoForca();
                    double danoBosstotal = defenseplayer - danoBoss;
                    playerPV -= danoBosstotal;
                    System.out.println("Seu inimigo causou dano de: " + danoBosstotal);
                } else if (escolhaInimigo3 == 2) {
                    int def3 = boss.getinimigoDefense() * 2;
                    System.out.println("o seu inimigo teve a defesa aumentada para: " + def3);
                } else if (escolhaInimigo3 == 3) {
                    if (curaboss > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        bossPV += curaTotal;
                        curaboss--;
                        System.out.println("Inimigo curou " + curaTotal + " de PV");
                    } else {
                        System.out.println("Inimigo tenta se curar, mas ele não tem mais cura");
                    }
                }
        
                // Verifica se o boss foi derrotado após a ação
                if (bossPV <= 0) {
                    System.out.println("O boss foi derrotado!");
                    break; // Sai do loop se o boss for derrotado
                }
        
                // Turno do jogador
                System.out.println("Seu turno, " + player.getName() + ":");
                System.out.println(boss.getinimigoName() + " [PV: " + bossPV + "] ");
                System.out.println(name + " [PV: " + playerPV + "] ");
                System.out.println("1) Atacar   2) Defender   3) Curar");
                agir3 = input.nextInt();
        
                if (agir3 == 1) {
                    double danototal = boss.getinimigoDefense() - danoplayer;
                    bossPV -= danototal;
                    System.out.println("Você causou: " + danototal + " de dano");
        
                    // Verifica se o boss foi derrotado
                    if (bossPV <= 0) {
                        System.out.println("O boss foi derrotado!");
                        break; // Sai do loop já que o boss foi derrotado
                    }
                } else if (agir3 == 2) {
                    double defensetotal = defenseplayer * 2;
                    System.out.println("A defesa aumentou para: " + defensetotal);
                } else if (agir3 == 3) {
                    if (cura > 0) {
                        int curaTotal = Pocao.usarPocao(pocaoCura.getPontos());
                        playerPV += curaTotal;
                        cura--;
                        System.out.println("Você curou " + curaTotal + " de PV");
                    } else {
                        System.out.println("Você não tem mais cura");
                    }
                }
        
                if (bossPV <= 0 || playerPV <= 0) {
                    break; // Sai do loop se o boss ou o jogador morrer
                }
            }
        }

        if(playerPV<=0)
        {
            Clear();
           System.out.println("Você falha em sua missão e não consegue superar a Morte, sendo envolvido em suas sombras e transformado em um novo ceifador. Assim, você se torna a própria Morte, ficando eternamente preso no mundo dos mortos.");
            System.out.println("Aperte qualquer tecla para continuar");
           break; 
        } if(bossPV<=0){
            Clear();
            System.out.println("Após a Morte ter sido derrotada pela primeira vez, decide se afastar cumprindo sua promessa, o deixa livre para retornar ao mundo dos vivos. Você volta, trazendo um novo entendimento sobre a vida e a morte, tentando melhorar e compensar todos os erros que fez no passado.");
            System.out.println("Obrigado por jogar!");

            System.out.println("\nDigite 1 para voltar ao menu.");
            opc = input.nextInt();

             break;


        }

    }
        
        }else if(opc == 2){  

            Clear();
            texto.Historia();
            System.out.println("Digite 1 para continuar");

            opc = input.nextInt();

            if(opc == 1)
            {
                
            }

            
        }else if(opc==3){

            break;
              
        }    
      
       
    }
    input.close();
    nome.close();           
}
}
