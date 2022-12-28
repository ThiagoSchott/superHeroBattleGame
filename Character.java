import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

abstract class Character {

    private String name;
    private String publisher;
    private int inicialLife;
    private int inicialEnergy;
    private int life;
    private int energy;
    private Boolean mimic = false;
    private Boolean leacher = false;
    private LinkedList<Power> powerList = new LinkedList<Power>(); 
    
    public Character(String name, String publisher, int inicialLife, int inicialEnergy, int life, int energy, Boolean mimic, Boolean leacher) {
      
        this.name = name;
        this.publisher = publisher;
        this.inicialLife = inicialLife;
        this.inicialEnergy = inicialEnergy;
        this.life = life;
        this.energy = energy;
        this.mimic = mimic;
        this.leacher = leacher;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getInicialLife() {
        return inicialLife;
    }

    public void setPublisher(){
        System.out.println("!asdasd");
    }

    public void setInicialLife(int inicialLife) {
        this.inicialLife = inicialLife;
    }

    public int getInicialEnergy() {
        return inicialEnergy;
    }

    public void setInicialEnergy(int inicialEnergy) {
        this.inicialEnergy = inicialEnergy;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Boolean getMimic() {
        return mimic;
    }

    public void setMimic(Boolean mimic) {
        this.mimic = mimic;
    }

    public Boolean getLeacher() {
        return leacher;
    }

    public void setLeacher(Boolean leacher) {
        this.leacher = leacher;
    }

    public void addPower(Power power){
        this.powerList.add(power);
    }

    public void removePower(Power power){
        int i = this.powerList.indexOf(power);
        this.powerList.remove(i);
    }

    public LinkedList<Power> getPowers(){
        return powerList;
    }

    public void recover(){
        this.life = this.inicialLife;
        this.energy = this.inicialEnergy;
    }

    public void leach(Character enemy){
        this.inicialEnergy += enemy.getEnergy();
        System.out.println("\n" + this.name + " is a leacher and added " + enemy.getName() + "'s energy to himself!");
        System.out.println("Now " + this.name + "'s base Energy Points are " + this.inicialEnergy);
    }

    public void mimic(Character enemy){
        this.powerList = null;
        this.powerList = enemy.getPowers();
        System.out.println("\n" + this.name + " is a mimic and copied all of " + enemy.getName() + "'s powers!");
    }

    public void rest(){
        this.life += 7;
        this.energy += 15;
        System.out.println("\n##############################  ACTION  ##############################\n");
        System.out.println("-> " + this.name + " used his turn to rest!");
        System.out.println("-> " + this.name + " recovered 7 HP and 15 Energy!");
        System.out.println("-> " + this.name + " now has " + this.life + " HP and " + this.energy + " Energy");
    }

    public void attack(Character enemy, Boolean isUser){
        
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int n = 0;

        if(isUser){
            Boolean loop = true;
            while(loop){    
                System.out.println("\n############################  YOUR  TURN  ############################\n");
                System.out.println("It's your turn " + this.name + "! Choose your attack:\n");
                for(int i = 0; i < powerList.size(); i++){
                    System.out.println("(" + (i + 1) + ") -> " + powerList.get(i).getName() + " - Damage: " + powerList.get(i).getDamage() + " | Cost: " + powerList.get(i).getEnergyFee() + " EP");
                }
                System.out.println("(" + (powerList.size() + 1) + ") -> Rest - Recover 7 HP | 15 Energy\n");
                n = (scan.nextInt()) - 1;
                if(n >= 0 && n < powerList.size()){
                    if(this.energy < powerList.get(n).getEnergyFee()){
                        System.out.println("\n##############################  MESSAGE  #############################\n");
                        System.out.println("You don't have enough Energy!! Please rest!! ");
                    }
                    else{
                        loop = false;
                    }
                }
                else if(n == powerList.size()){
                    loop = false;
                }
                else{
                    System.out.println("\n###############################  ERROR  ##############################\n");
                    System.out.println("Type a valid number!! ");
                }
                
            }
        }
        else if(!isUser){
            Boolean tired = false;
            for(int i = 0; i < powerList.size(); i++){
                if(powerList.get(i).getEnergyFee() > this.energy){
                    tired = true;
                }
            }
            if(!tired){
                if(powerList.size() > 0){
                    if(this.energy > 25){
                        n = random.nextInt(0, powerList.size());
                    }
                    else{
                        n = random.nextInt(0, (powerList.size() + 1));
                    }
                    if(n == powerList.size()){
                        System.out.println("\n############################  ENEMY  TURN  ###########################\n");
                        System.out.println("It's " + this.name + "'s turn! \n\nHe chose to rest");
                  
                    }
                    else{
                        System.out.println("\n############################  ENEMY  TURN  ###########################\n");
                        System.out.println("It's " + this.name + "'s turn! \n\nHe chose the attack '" + powerList.get(n).getName() + "'");
                  
                    }
                }
            }
            else{
                n = powerList.size();
                System.out.println("\n############################  ENEMY  TURN  ###########################\n");
                System.out.println("It's " + this.name + "'s turn! \n\nHe chose to rest");
            }
            
        }
        if(n == powerList.size()){
            this.rest();
        }
        else{
            Power power = powerList.get(n);
            this.energy -= power.getEnergyFee();
            enemy.setLife(enemy.getLife() - power.getDamage());
            System.out.println("\n##############################  ACTION  ##############################\n");
            System.out.println("-> " + this.name + " used " + power.getName() + " to attack " + enemy.getName() + "!");
            System.out.println("-> " + power.getName() + " caused " + power.getDamage() + " points of damage!");
            System.out.println("-> " + enemy.getName() + "'s life droped to " + enemy.getLife() + " HP points");
        }
    }
}