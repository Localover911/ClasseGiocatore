import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Quanti giocatori vuoi nella tua squadra: ");
        int n = in.nextInt();
        Giocatore[] squadra;
        squadra = new Giocatore[n];

        int count = 0;
        boolean input = false;

        do {

            System.out.println("1- Aggiungere un giocatore alla squadra, controllando che non ci sia più di un capitano");
            System.out.println("2- Visualizzare tutti i giocatori della squadra");
            System.out.println("3- Modificare i dati di un giocatore a scelta");
            System.out.println("4- Cancellare un giocatore dalla squadra ");
            System.out.println("5- Visualizzare i giocatori che hanno realizzato più di 5 goal.");
            System.out.println("6- Visualizzare il nome del capitano");
            System.out.println("7- Assegnare il ruolo di capitano in modo casuale se non ancora presente");
            System.out.println("0- Esci dal campo");

            int scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    for (int i = 0; i < count; i++) {
                        System.out.println("Aggiungi il nome del giocatore: ");
                        String nome = in.next();
                        System.out.println("Scegli se è capitano o meno (true/false): ");
                        boolean capitano = in.nextBoolean();
                        System.out.println("Goal: ");
                        int goal = in.nextInt();
                        if(goal<0){
                            goal=0;
                        }
                        AggiungiGiocatore(squadra, nome, capitano, goal, count);
                    }
                    count++;
                    break;
                case 2:
                    VisualizzaRosa(squadra,count);
                    break;
                case 3:
                    System.out.println("Modifica dei dati di un giocatore, inserisci il nome da sostituire: ");
                    String nome = in.next();
                    System.out.println("Inserisci se è capitano o meno (true/false): ");
                    String capitano = in.next();
                    System.out.println("Ora cambia i goal: ");
                    String goal = in.next();
                    System.out.println("Ora puoi modificare il nome del giocatore: ");
                    String newnome = in.next();
                    System.out.println("Cambia se è capitano o meno (true/false): ");
                    String newcapitano = in.next();
                    System.out.println("Inserisci il prezzo da sostituire: ");
                    String newgoal = in.next();
                    ModificaGiocatore(Giocatore[] squadra,nome,capitano,goal,newnome,newcapitano,newgoal);
                    break;
                case 4:
                    if (count==0){
                        System.out.println("Non ci sono auto nel concessionario, inseriscine una");
                        break;
                    }
                    int RicercaDaEliminare=-1;
                    System.out.println("Inserisci il nome del giocatore da eliminare: ");
                    nome = in.next();
                    System.out.println("Ora inserisci se è capitano o meno (true/false): ");
                    capitano = in.next();
                    System.out.println("Ora inserisci i goal: ");
                    goal = in.next();

                    for (int i = 0; i < count; i++){
                        if (arrayMarca[i].equalsIgnoreCase(marca) && arrayModello[i].equalsIgnoreCase(modello) && arrayPrezzo[i].equalsIgnoreCase(prezzo)){
                            RicercaDaEliminare=i;
                            break;
                        }
                    }
                    if (RicercaDaEliminare==-1){
                        System.out.println("Non è presente un'auto con questi dati");
                    }
                    count = EliminaGiocatore(squadra,RicercaDaEliminare,count);
                case 0:
                    input = true;
                    System.out.println("Programma terminato");
                    break;
            }
        }while (!input);
    }

    public static void AggiungiGiocatore(Giocatore[] squadra, String nome, boolean capitano, int goal, int count){
        squadra[count] = new Giocatore(nome, capitano, goal);
    }
    public static void VisualizzaRosa(Giocatore[] squadra, int count){
        for (int i = 0; i < count; i++){
            System.out.println("Giocatore: " + squadra[i].getNome() + " Capitano:" + squadra[i].getCapitano() + " Goal:" + squadra[i].getGoal());
        }
    }
    public static int VisualizzaCapitano(String[]arrayMarca,String[]arrayModello, String marca, String modello){
        int posizione = -1;
        for (int i = 0; i < arrayMarca.length; i++){
            if (marca.equalsIgnoreCase(arrayMarca[i]) && modello.equalsIgnoreCase(arrayModello[i])){
                posizione = i;
            }
        }
        return posizione;
    }
    public static int EliminaGiocatore(Giocatore[] squadra, int ricercadaeliminare, int count){
        for (int i = ricercadaeliminare; i < count; i++){
            squadra[i] = squadra[i+1];
            squadra[i] = squadra[i+1];
            squadra[i] = squadra[i+1];
        }
        count = count-1;
        return count;
    }
    public static void ModificaGiocatore(Giocatore[] squadra, String nome, String capitano, String goal, String newnome, String newcapitano, String newgoal){
        for (int i = 0; i < squadra.length; i++){
            if(nome.equalsIgnoreCase(String.valueOf(squadra[i]))){
                squadra[i]=newnome;
            }
            if(capitano.equalsIgnoreCase(String.valueOf(squadra[i]))){
                squadra[i]=newcapitano;
            }
            if(goal.equalsIgnoreCase(String.valueOf(squadra[i]))){
                squadra[i]=newgoal;
            }
        }
    }
}