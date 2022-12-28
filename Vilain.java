class Vilain extends Character {
    
    private int evilLevel;

    public Vilain(String name, String publisher, int inicialLife, int inicialEnergy, int life, int energy, Boolean mimic, Boolean leacher, int evilLevel) {

        super(name, publisher, inicialLife, inicialEnergy, life, energy, mimic, leacher);
        this.evilLevel = evilLevel;
    
    }

    public int getEvilLevel() {
        return evilLevel;
    }

    public void setEvilLevel(int evilLevel) {
        this.evilLevel = evilLevel;
    }

}