class Hero extends Character {
    
    private String realName;

    public Hero(String name, String publisher, int inicialLife, int inicialEnergy, int life, int energy, Boolean mimic, Boolean leacher, String realName) {

        super(name, publisher, inicialLife, inicialEnergy, life, energy, mimic, leacher);
        this.realName = realName;
    
    }

    public Class<? extends Hero> getType(){
        return this.getClass();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}