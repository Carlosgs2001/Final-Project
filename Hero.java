import java.util.ArrayList;
import java.lang.Math;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author carlp
 */
public class Hero {
    
    String name;
    int maxHp;
    float HitPoints;
    int maxMana;
    int Mana;
    int Atkpwr;
    boolean alive = true;
    int levl = 1;
    int defense = 5;
    ArrayList<Ability> abilities = new ArrayList<>();
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getMaxHp() {
        return maxHp;
    }
    
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    
    public float getHitPoints() {
        return HitPoints;
    }
    
    public void setHitPoints(float HitPoints) {
        this.HitPoints = HitPoints;
    }
    
    public int getMana() {
        return Mana;
    }
    
    public void setMana(int Mana) {
        this.Mana = Mana;
    }
    
    public int getMaxMana() {
        return maxMana;
    }
    
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    
    public int getAtkpwr() {
        return Atkpwr;
    }
    
    public void setAtkpwr(int Atkpwr) {
        this.Atkpwr = Atkpwr;
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public int getLevl() {
        return levl;
    }
    
    public void setLevl(int levl) {
        this.levl = levl;
    }
    
    public int getDefense() {
        return defense;
    }
    
    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    public void addAbility(Ability ablt) {
        abilities.add(ablt);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Hero(String name, int maxHp, float HitPoints, int maxMana, int Mana, int Atkpwr) {
        this.name = name;
        this.maxHp = maxHp;
        this.HitPoints = HitPoints;
        this.maxMana = maxMana;
        this.Mana = Mana;
        this.Atkpwr = Atkpwr;
    }
    
    public Hero() {
        
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void levelUp(Hero lero) {
        if (lero.isAlive()) {
            int lvl = lero.getLevl();
            lero.setLevl(lvl + 1);
            float hit = lero.getHitPoints() + 25;
            int hitm = lero.getMaxHp() + 25;
            int mant = lero.getMana() + 10;
            int manM = lero.getMaxMana() + 10;
            int att = lero.getAtkpwr() + 3;
            int def = lero.getDefense() + 1;
            lero.setAtkpwr(att);
            lero.setHitPoints(hit);
            lero.setMaxHp(hitm);
            lero.setMana(mant);
            lero.setMaxMana(manM);
            lero.setDefense(def);
            
            if (lero.getMana() > lero.getMaxMana()) {
                lero.setMana(lero.getMaxMana());
            }
            if (lero.getHitPoints() > lero.getMaxHp()) {
                lero.setHitPoints(lero.getMaxHp());
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public float useabi(Hero lero) {
        
        float dam = 0;
        int mana = 0;
        if (lero.getMana() > 0) {
            if (levl < 6) {
                int ran = (int) (Math.random() * (3 - 1 + 1) + 1);
                
                dam = abilities.get(ran).dmgab(lero.getAtkpwr());
                mana = abilities.get(ran).getManacost();
                int mana1 = lero.getMana() - mana;
                lero.setMana(mana1);
                System.out.println("The Hero " + lero.getName() + " uses the ability " + abilities.get(ran).getName());
                System.out.println("The Hero " + lero.getName() + " has " + lero.getMana() + " Mana Points left");
                if (abilities.get(ran).isLstal()) {
                    float hit = abilities.get(ran).dmgab(lero.getAtkpwr());
                    float nhp = lero.getHitPoints() + hit;
                    lero.setHitPoints(nhp);
                    if (lero.HitPoints > lero.maxHp) {
                        lero.HitPoints = lero.maxHp;
                    }
                }
                if (abilities.get(ran).isMstal()) {
                    int hit = lero.getMana() + lero.getAtkpwr();
                    int nman = lero.getMana() + hit;
                    lero.setMana(nman);
                }
                if (abilities.get(ran).isShield()) {
                    int def = lero.getDefense() + 50;
                    lero.setDefense(def);
                }
            } else {
                int ran = (int) (Math.random() * (4 - 1 + 1) + 1);
                dam = abilities.get(ran).dmgab(lero.getAtkpwr());
                mana = abilities.get(ran).getManacost();
                int mana1 = lero.getMana() - mana;
                lero.setMana(mana1);
                
                if (abilities.get(ran).isLstal()) {
                    float hit = abilities.get(ran).dmgab(lero.getAtkpwr());
                    float nhp = lero.getHitPoints() + hit;
                    lero.setHitPoints(nhp);
                    if (lero.HitPoints > lero.maxHp) {
                        lero.HitPoints = lero.maxHp;
                    }
                }
                if (abilities.get(ran).isMstal()) {
                    int hit = lero.getMana() + lero.getAtkpwr();
                    lero.setMana(hit);
                    int nman = lero.getMana() + hit;
                    lero.setMana(nman);
                }
                if (abilities.get(ran).isShield()) {
                    int def = lero.getDefense() + 50;
                    lero.setDefense(def);
                }
            }
        }
        System.out.println("And did " + dam + " Damage.");
        return dam;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////  

//////////////////////////////////////////////////////////////////////////////////////////////////////////  
    public void attackN(Hero taker, Hero reciv) {
        
        float ablt = taker.useabi(taker);
        int damg = taker.getAtkpwr();
        float tdam = damg - reciv.getDefense();
        
        System.out.println("The Hero " + taker.getName() + " Attacked the Hero " + reciv.getName() + " Doing " + tdam + " as Base damage");
        
        System.out.println("The Hero " + taker.getName() + " has " + taker.getHitPoints() + " Health left");
        
        float dm1g = reciv.getHitPoints() - ablt;
        reciv.setHitPoints(dm1g - tdam);
        
        if (reciv.getHitPoints() <= 0) {
            reciv.setAlive(false);
            reciv.setHitPoints(0);
            System.out.println("Hero " + reciv.getName() + " has been defeated");
        } else if (taker.getHitPoints() <= 0) {
            taker.setAlive(false);
            taker.setHitPoints(0);
            System.out.println("Hero " + reciv.getName() + " has been defeated");
        }
        System.out.println("The Hero " + reciv.getName() + " has " + reciv.getHitPoints() + " Health Points left");
        
    }
    
}