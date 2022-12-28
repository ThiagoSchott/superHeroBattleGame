class Battle {

    private Character userChar;
    private Character enemy;
    private Character winner;

    public Battle(Character userChar, Character enemy){

        this.userChar = userChar;
        this.enemy = enemy;

    }

    public void fight(){
        Boolean loop = true;
        int round = 1;
        userChar.recover();
        enemy.recover();
        System.out.println("\n##############################  MESSAGE  #############################\n");
        System.out.println(userChar.getName() + " VS " + enemy.getName() + "\n");
        if( ! userChar.getPublisher().equals(enemy.getPublisher())){
            System.out.println("CROSS-OVER battle between " + userChar.getPublisher() + " and " + enemy.getPublisher() + "!\n");
        }
        else{
            if(userChar.getPublisher().equals("DC Comics") && enemy.getPublisher().equals("DC Comics")){
                System.out.println("\nThis is a " + enemy.getPublisher() + " battle!\n");
            }
            if(userChar.getPublisher().equals("Marvel") && enemy.getPublisher().equals("Marvel")){
                System.out.println("\nThis is a " + enemy.getPublisher() + " battle!\n");
            }
        }
        if( ! userChar.getClass().equals(enemy.getClass())){
            System.out.println("Classic battle between good and evil!");
        }
        if(userChar.getClass().equals(Vilain.class) && enemy.getClass().equals(Vilain.class)){
            System.out.println("A dispute for power in the Evil realms!");
        }
        if(userChar.getClass().equals(Hero.class) && enemy.getClass().equals(Hero.class)){
            System.out.println("Why are Heros fighting? Maybe one of them turned evil!");
        }
        if(userChar.getMimic()){
            userChar.mimic(enemy);
            if(enemy.getPowers().size() < 1){
                Power punch = new Power("Punch", 4, 4);
                userChar.addPower(punch);
            }
        }
        if(enemy.getMimic()){
            enemy.mimic(userChar);
            if(userChar.getPowers().size() < 1){
                Power punch = new Power("Punch", 4, 4);
                enemy.addPower(punch);
            }
        }
        while(loop){
            System.out.println("\n##############################  ROUND " + round + "  #############################\n");
            System.out.println("\n" + userChar.getName() + "'s current stats:\n\n - HP Points: " + userChar.getLife() + "\n - Energy Points: " + userChar.getEnergy());
            System.out.println("\n" + enemy.getName() + "'s current stats:\n\n - HP Points: " + enemy.getLife() + "\n - Energy Points: " + enemy.getEnergy());
            if(userChar.getLife() <= 0){
                loop = false;
                System.out.println("\n##############################  MESSAGE  #############################\n");
                System.out.println("SHIT!!! You Lost!\n");
                System.out.println(enemy.getName() + " has defeated " + userChar.getName() + "!");
                if(enemy.getLeacher()){
                    enemy.leach(userChar);
                }
                this.winner = enemy;
            }
            else{
                userChar.attack(enemy, true);
                if(enemy.getLife() <= 0){
                    loop = false;
                    System.out.println("\n##############################  MESSAGE  #############################\n");
                    System.out.println("CONGRATS!!! You Won!\n");
                    System.out.println(userChar.getName() + " has defeated " + enemy.getName() + "!");
                    if(userChar.getLeacher()){
                        userChar.leach(enemy);    
                    }
                    this.winner = userChar;
                }
                else{
                    enemy.attack(userChar, false);
                }
            }
            round++;
        }
    }

    public Character getUserChar() {
        return userChar;
    }
    
    public void setUserChar(Character userChar) {
        this.userChar = userChar;
    }
    
    public Character getEnemy() {
        return enemy;
    }
    
    public void setEnemy(Character enemy) {
        this.enemy = enemy;
    }

    public Character getWinner() {
        return winner;
    }

    public void setWinner(Character winner) {
        this.winner = winner;
    }

    

}