class Power {

    private String name;
    private int damage;
    private int energyFee;
    
    public Power(String name, int damage, int energyFee){
        this.name = name;
        this.damage = damage;
        this.energyFee = energyFee;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getEnergyFee() {
        return energyFee;
    }
    
    public void setEnergyFee(int energyFee) {
        this.energyFee = energyFee;
    }

}