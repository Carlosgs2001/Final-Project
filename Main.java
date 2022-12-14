import java.lang.Math;
import java.util.ArrayList;

/**
 *
 * @author carlp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Hero> heroes = new ArrayList<>();
        // Hero Creation
        Hero troll = new Hero("Troll Warlord", 800, 800, 300, 300, 49);
        Hero pamtom = new Hero("Phantom Assasin", 700, 700, 150, 150, 40);
        Hero anti = new Hero("Anti-Mage", 750, 750, 250, 250, 45);
        Hero invokr = new Hero("Invoker", 600, 600, 800, 800, 30);
        Hero lina = new Hero("Lina", 650, 650, 700, 700, 40);

//////////////////////////////////////////Troll///////////////////////////////////////////////////////////       
        Ability aby1 = new Ability("Axe Throw", troll.getAtkpwr(), 70, 2);
        Ability aby2 = new Ability("Whirlwind Axes", troll.getAtkpwr(), 90, 2);
        Ability aby3 = new Ability("Lifesteal", troll.getAtkpwr(), 0, 1);
        aby3.setLstal(true);
        Ability aby4 = new Ability("Troll Rage", troll.getAtkpwr(), 0, 3);
        aby4.setLstal(true);
        aby4.setUltimate(true);

        troll.addAbility(aby1);
        troll.addAbility(aby2);
        troll.addAbility(aby3);
        troll.addAbility(aby4);

////////////////////////////////////////////Phamtom/////////////////////////////////////////////////////////////
        Ability paby1 = new Ability("Phantom Dagger", pamtom.getAtkpwr(), 15, 2);
        Ability paby2 = new Ability("Double Strike", pamtom.getAtkpwr(), 0, 2);
        Ability paby3 = new Ability("Evasion", 0, 0, 0);
        paby3.setShield(true);
        Ability paby4 = new Ability("Critical Strike", pamtom.getAtkpwr(), 100, 5);
        paby4.setUltimate(true);

        pamtom.addAbility(paby1);
        pamtom.addAbility(paby2);
        pamtom.addAbility(paby3);
        pamtom.addAbility(paby4);
////////////////////////////////////////////AntiMage/////////////////////////////////////////////////////////////
        Ability Aaby1 = new Ability("Mana Burn", anti.getAtkpwr(), 15, 1);
        Aaby1.setMstal(true);
        Ability Aaby2 = new Ability("Blink Strike", anti.getAtkpwr(), 50, 2);
        Aaby2.setMstal(true);
        Ability Aaby3 = new Ability("Throw Weapons", anti.getAtkpwr(), 100, 2);
        Aaby3.setMstal(true);
        Ability Aaby4 = new Ability("Mana Void", anti.getAtkpwr(), 150, 5);
        Aaby4.setMstal(true);
        Aaby4.setUltimate(true);

        anti.addAbility(Aaby1);
        anti.addAbility(Aaby2);
        anti.addAbility(Aaby3);
        anti.addAbility(Aaby4);
////////////////////////////////////////////Invoker/////////////////////////////////////////////////////////////
        Ability Iaby1 = new Ability("Cold Snap", invokr.getAtkpwr(), 50, 2);
        Ability Iaby2 = new Ability("Sun Strike", invokr.getAtkpwr(), 100, 4);
        Ability Iaby3 = new Ability("Deafening Blast", invokr.getAtkpwr(), 150, 6);
        Ability Iaby4 = new Ability("Cataclysm", invokr.getAtkpwr(), 200, 10);
        Iaby4.setUltimate(true);

        invokr.addAbility(Iaby1);
        invokr.addAbility(Iaby2);
        invokr.addAbility(Iaby3);
        invokr.addAbility(Iaby4);
////////////////////////////////////////////Lina/////////////////////////////////////////////////////////////
        Ability Laby1 = new Ability("Dragon Slave", lina.getAtkpwr(), 50, 2);
        Ability Laby2 = new Ability("Lava Blaze", lina.getAtkpwr(), 90, 3);
        Ability Laby3 = new Ability("Rain of Fire", lina.getAtkpwr(), 200, 6);
        Ability Laby4 = new Ability("Lightning Blast", lina.getAtkpwr(), 300, 8);
        Iaby4.setUltimate(true);

        lina.addAbility(Laby1);
        lina.addAbility(Laby2);
        lina.addAbility(Laby3);
        lina.addAbility(Laby4);
////////////////////////////////////////////adding ot the list/////////////////////////////////////////////////////////////
        heroes.add(troll);
        heroes.add(pamtom);
        heroes.add(anti);
        heroes.add(invokr);
        heroes.add(lina);
        int j = 1;
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println("Heroes possition " + (j++) + " name: " + heroes.get(i).getName() + "\n");
        }
        j = 1;
        for (int i = 0; i < heroes.size(); i++) {
            /////for begins////

            System.out.println("\n|||Round|||: " + j++);

            int ran = (int) (Math.random() * 5);
            int ran1 = (int) (Math.random() * 5);
            if (ran == ran1) {
                System.out.println("The Hero: " + heroes.get(ran).getName() + " can't fight Himself \n");
            }
            if (heroes.get(ran).isAlive() && heroes.get(ran1).isAlive()) {
                if (ran != ran1) {
                    System.out.println("The Hero: " + heroes.get(ran).getName() + " VS The Hero: " + heroes.get(ran1).getName() + "\n");

                    while (true) {
                        if (heroes.get(ran).isAlive()) {
                            heroes.get(ran).attackN(heroes.get(ran), heroes.get(ran1));
                            if (heroes.get(ran1).isAlive()) {
                                heroes.get(ran1).attackN(heroes.get(ran1), heroes.get(ran));
                            }
                            if (!heroes.get(ran1).isAlive()) {
                                heroes.get(ran).levelUp(heroes.get(ran));
                                System.out.println("Hero " + heroes.get(ran).getName() + " leveled up to " + heroes.get(ran).getLevl());
                                break;

                            } else if (!heroes.get(ran).isAlive()) {
                                heroes.get(ran1).levelUp(heroes.get(ran1));
                                System.out.println("Hero " + heroes.get(ran1).getName() + " leveled up to " + heroes.get(ran1).getLevl());

                                break;
                            }
                        }

                    }
                    System.out.println("Bettle End");
                }
            } else {
                if (!heroes.get(ran).isAlive()) {
                    System.out.println("The hero " + heroes.get(ran).getName() + " has been Previously defeated");
                }
                if (!heroes.get(ran1).isAlive()) {
                    System.out.println("The hero " + heroes.get(ran1).getName() + " has been Previously defeated");
                }

            }
        }
        /////for ends////
        System.out.println("\n||||Tournament End|||||");
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).isAlive()) {
                if (heroes.get(i).getLevl() != 1) {
                    System.out.println("The Survivors of the tournament are: " + heroes.get(i).getName() + " with level " + heroes.get(i).getLevl());
                } 
            }

        }
    }

}