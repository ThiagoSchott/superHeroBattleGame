import java.util.Scanner;
import java.util.LinkedList;

class Main {

    public Character chooseCharacter(){
        
        return null;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        LinkedList<Hero> heroList = new LinkedList<Hero>(); 
        LinkedList<Vilain> vilainList = new LinkedList<Vilain>(); 
        Battle battle = null;
        // Heros:
        Hero fenix = new Hero("Fenix", "Marvel Comics", 120, 100, 120, 100, false, false, "Jean Gray");
        Hero superman = new Hero("Superman", "DC Comics", 100, 70, 100, 70, false, false, "Clark Kent");
        Hero spiderman = new Hero("Spider Man", "Marvel Comics", 80, 50, 80, 50, false, false, "Peter Parker");
        Hero mimic = new Hero("Mimic", "Marvel Comics", 70, 50, 70, 50, true, false, "Calvin Montgomery Rankin");
        // Vilains:
        Vilain greenGoblin = new Vilain("Green Goblin", "Marvel Comics", 80, 60, 80, 60, false, false, 70);
        Vilain doctorOctopus = new Vilain("Doctor Octopus",  "Marvel Comics", 70, 40, 70, 40, false, false, 70);
        Vilain superSkrull = new Vilain("Super Skrull", "Marvel Comics", 90, 60, 90, 60, true, false, 100);
        Vilain parasite = new Vilain("Parasite", "DC Comics", 90, 70, 90, 70, false, true, 70);
        Vilain superdoom = new Vilain("Superdoom", "DC Comics", 95, 65, 95, 65, false, false, 50);
        // Powers:
        Power eletricCharge = new Power("Eletric Charge", 6, 7);
        Power pumpkinGranade = new Power("Pumpkin Granade", 6, 5);
        Power lazerVision = new Power("Lazer Vision", 5, 5);
        Power superBreath = new Power("Super Breath", 4, 4);
        Power tentacles = new Power("Tentacles", 6, 4);
        Power superPunch = new Power("Super Punch", 8, 6);
        Power punch = new Power("Punch", 4, 4);
        Power spideyKick = new Power("Spidey Kick", 6, 6);   
        Power webShot = new Power("Web Shot", 5, 5);
        Power fenixBlast = new Power("Fenix Blast", 12, 34);
        // Adding powers:
        fenix.addPower(fenixBlast);
        superman.addPower(lazerVision);
        superman.addPower(superBreath);
        superman.addPower(superPunch);
        superdoom.addPower(superPunch);
        superdoom.addPower(superBreath);
        superdoom.addPower(lazerVision);
        spiderman.addPower(spideyKick);
        spiderman.addPower(webShot);
        greenGoblin.addPower(pumpkinGranade);
        greenGoblin.addPower(punch);
        doctorOctopus.addPower(tentacles);
        parasite.addPower(eletricCharge);
        parasite.addPower(punch);

        heroList.add(spiderman);
        heroList.add(mimic);
        heroList.add(superman);
        heroList.add(fenix);        
        vilainList.add(greenGoblin);
        vilainList.add(superSkrull);
        vilainList.add(doctorOctopus);
        vilainList.add(parasite);
        vilainList.add(superdoom);


        Boolean loop = true;

        while(loop){

            Character userChar = null;
            Character enemy = null;
            Boolean loop2 = true;

            while(loop2){
                System.out.println("\n###############################  MENU  ###############################\n");
                System.out.println("Choose your Character: \n\nHeros:\n");
                for(int i = 0; i < heroList.size(); i++){
                    System.out.println("(" + (i + 1) + ") -> " + heroList.get(i).getName());
                }
                System.out.println("\nVilains:\n");
                for(int i = 0; i < vilainList.size(); i++){
                    System.out.println("(" + (i + 1 + heroList.size()) + ") -> " + vilainList.get(i).getName());
                }
                System.out.println();
                int a = scan.nextInt();
                if(a > 0 && a <= (heroList.size() + vilainList.size())){
                    if(a > heroList.size()){
                        a -= heroList.size();
                        userChar = vilainList.get(a - 1);
                    }else{
                        userChar = heroList.get(a - 1);
                    }
                    loop2 = false;
                }else{
                    System.out.println("\n###############################  ERROR  ##############################\n");
                    System.out.println("Type a valid number!! ");
                }
                
            }

            System.out.println("\n###############################  MENU  ###############################\n");
            System.out.println("Choose which mode you want to play: \n\n(1) -> 1v1 Fight \n(2) -> Hero Campain \n(3) -> Vilain Campain \n(4) -> End Game\n");
            int x = scan.nextInt();
            
            switch(x){

                case 1:
                    loop2 = true;
                    while(loop2){
                        System.out.println("\n###############################  MENU  ###############################\n");
                        System.out.println("Choose your Enemy: \n\nHeros:\n");
                        for(int i = 0; i < heroList.size(); i++){
                            System.out.println("(" + (i + 1) + ") -> " + heroList.get(i).getName());
                        }
                        System.out.println("\nVilains:\n");
                        for(int i = 0; i < vilainList.size(); i++){
                            System.out.println("(" + (i + 1 + heroList.size()) + ") -> " + vilainList.get(i).getName());
                        }
                        System.out.println();
                        int a = scan.nextInt();
                        if(a > 0 && a <= (heroList.size() + vilainList.size())){
                            if(a > heroList.size()){
                                a -= heroList.size();
                                enemy = vilainList.get(a - 1);
                            }else{
                                enemy = heroList.get(a - 1);
                            }
                            loop2 = false;
                        }else{
                            System.out.println("\n###############################  ERROR  ##############################\n");
                            System.out.println("Type a valid number!! ");
                        }
                    }
                    battle = new Battle(userChar, enemy);
                    battle.fight();
                    break;

                case 2:
                    System.out.println("\n##############################  MESSAGE  #############################\n");
                    System.out.println("Welcome to the Hero Campaing!");
                    System.out.println("\nIn this mode, you will have to defeat all the vilains in order to win!");
                    System.out.println("\nGood luck, you'll need it!");
                    for( Vilain vilain : vilainList ){
                        System.out.println("\nPrepare to fight " + vilain.getName() + "!");
                        battle = new Battle(userChar, vilain);
                        battle.fight();
                        if(battle.getWinner() == vilain){
                            break;
                        }
                    }
                    System.out.println("\nWell done! You have defeated all the Vilains!");
                    System.out.println("\nCongratiulations on finishing the Hero Campaing!");
                    break;

                case 3:
                    System.out.println("\n##############################  MESSAGE  #############################\n");
                    System.out.println("Welcome to the Vilain Campaing!");
                    System.out.println("\nIn this mode, you will have to defeat all the Heros in order to win!");
                    System.out.println("\nGood luck, you'll need it!");
                    for( Hero hero : heroList ){
                        System.out.println("\nPrepare to fight " + hero.getName() + "!");
                        battle = new Battle(userChar, hero);
                        battle.fight();
                        if(battle.getWinner() == hero){
                            break;
                        }
                    }    
                    System.out.println("\nWell done! You have defeated all the Heros!");
                    System.out.println("\nCongratiulations on finishing the Vilain Campaing!");                
                    break;

                case 4:
                    loop = false;
                    System.out.println("\nBye bye!!\n");
                    break;

                default:
                    System.out.println("\n###############################  ERROR  ##############################\n");
                    System.out.println("Type a valid number!! ");
                
                    
            }
        }
    }
}