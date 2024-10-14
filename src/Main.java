import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String nome;
        boolean capitano;
        int goal;


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

                    System.out.println("Aggiungi il nome del giocatore: ");
                    nome = in.next();
                    System.out.println("Scegli se è capitano o meno (true/false): ");
                    capitano = in.nextBoolean();
                    System.out.println("aggiungi il numero di goal: ");
                    goal = in.nextInt();
                    if (goal < 0) {
                        goal = 0;
                    }
                    AggiungiGiocatore(squadra, nome, capitano, goal, count);
                    count = count + 1;
                    break;


                case 2:
                    VisualizzaRosa(squadra, count);
                    break;


                case 3:
                    System.out.println("Di quale giocatore vuoi cambiare i dati?: ");
                    nome = in.next();
                    System.out.println("Modifica il nome:");
                    String newnome = in.next();
                    System.out.println("Decidi se è capitano (true/false):");
                    boolean newcapitano = in.nextBoolean();
                    System.out.println("Modifica il numero di goal:");
                    int newgoal = in.nextInt();
                    ModificaGiocatore(squadra, nome, newnome, newcapitano, newgoal, count);
                    break;


                case 4:
                    if (count == 0) {
                        System.out.println("Non ci sono auto nel concessionario, inseriscine una");
                        break;
                    }
                    int RicercaDaEliminare = -1;
                    System.out.println("Inserisci il nome del giocatore da eliminare: ");
                    nome = in.next();

                    for (int i = 0; i < count; i++) {
                        if (nome.equalsIgnoreCase(String.valueOf(squadra[i].getNome()))) {
                            RicercaDaEliminare = i;
                        }
                    }

                    count = EliminaGiocatore(squadra, RicercaDaEliminare, count);

                case 5:
                    visualizzaVgoal(squadra, count);


                case 6:
                    visualizzacapitano(squadra, count);

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

    public static void ModificaGiocatore(Giocatore[] squadra, String nome, String newnome, boolean newcapitano, int newgoal, int count){
        for (int i = 0; i < count; i++){
            if(nome.equalsIgnoreCase(squadra[i].getNome())){
                squadra[i].setNome(newnome);

                squadra[i].setCapitano(newcapitano);

                squadra[i].setGoal(newgoal);
            }
        }
    }

    public static void visualizzaVgoal(Giocatore[] squadra, int count) {
        for (int i = 0; i < count; i++) {
            if (squadra[i].getGoal() >= 5) {
                System.out.println(squadra[i].getNome() + "con:" + squadra[i].getGoal() + "goal");
            }
        }
    }

    public static void visualizzacapitano(Giocatore[] squadra, int count) {
        for (int i = 0; i < count; i++) {
            if (squadra[i].getCapitano() == true) {
                System.out.println("il capitano è: " + squadra[i].getNome() );
            }
        }
    }


}