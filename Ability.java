public class Ability {

    String name;
    
    int manacost;
    float mult;
    boolean Ultimate = false;
    boolean shield = false;
    boolean lstal = false;
    boolean mstal = false;
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    public int getManacost() {
        return manacost;
    }

    public void setManacost(int manacost) {
        this.manacost = manacost;
    }

    public float getMult() {
        return mult;
    }

    public void setMult(int mult) {
        this.mult = mult;
    }

    public boolean isUltimate() {
        return Ultimate;
    }

    public void setUltimate(boolean Ultimate) {
        this.Ultimate = Ultimate;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public boolean isLstal() {
        return lstal;
    }

    public void setLstal(boolean lstal) {
        this.lstal = lstal;
    }

    public boolean isMstal() {
        return mstal;
    }

    public void setMstal(boolean mstal) {
        this.mstal = mstal;
    }

    
    
    public Ability(String name, int heroDm, int manacost, float mult) {
        this.name = name;
        
        this.manacost = manacost;
        this.mult = mult;
    }
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public float dmgab(int bdam) {
        float multy=this.mult;
       
        return bdam * multy;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void type(boolean ispass, boolean islstal, boolean ismanstl, boolean isUlt) {

        this.shield = ispass;
        this.lstal = islstal;
        this.mstal = ismanstl;
        this.Ultimate = isUlt;

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
}