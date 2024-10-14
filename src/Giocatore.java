public class Giocatore {

    private String nome;

    private boolean capitano;

    private int goal;

    public Giocatore(String nome, boolean capitano, int goal) {
        setNome(nome);
        setCapitano(capitano);
        setGoal(goal);
    }

    public Giocatore() {
        setNome(nome);
        setCapitano(capitano);
        setGoal(goal);
    }

    public Giocatore(String nome) {
        setNome(nome);
        this.capitano = true;
        this.goal = 350;
    }

    public Giocatore(int goal) {
        this.nome = "Angel Di Maria";
        this.capitano = true;
        setGoal(goal);
    }

    public String getNome(){
        return nome;
    }

    public boolean getCapitano(){
        return capitano;
    }

    public int getGoal(){
        return goal;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCapitano(boolean capitano){
        this.capitano = capitano;
    }

    public void setGoal(int goal){
        this.goal = goal;
    }
}