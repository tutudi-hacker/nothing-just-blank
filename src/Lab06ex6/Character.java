package Lab06ex6;

public class Character {
    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void move() {
        System.out.println(this.name + " moves across the battlefield.");
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " takes " + damage + " damage! Remaining HP: " + this.health);
    }

    public static void main(String[] args) {
        Spell fireball = new Spell("Fireball", 45);
        Weapon greatsword = new Weapon("Greatsword", 30);

        Wizard wizard = new Wizard("Merlin", 100, fireball);
        Warrior warrior = new Warrior("Arthur", 150, greatsword);

        wizard.move();
        wizard.castSpell();
        warrior.takeDamage(45);

        System.out.println();

        warrior.move();
        warrior.attack();
        wizard.takeDamage(30);
    }
}

class Spell {
    private String spellName;
    private int damage;

    public Spell(String spellName, int damage) {
        this.spellName = spellName;
        this.damage = damage;
    }

    public String getSpellName() {
        return this.spellName;
    }

    public int getDamage() {
        return this.damage;
    }
}

class Weapon {
    private String weaponName;
    private int damage;

    public Weapon(String weaponName, int damage) {
        this.weaponName = weaponName;
        this.damage = damage;
    }

    public String getWeaponName() {
        return this.weaponName;
    }

    public int getDamage() {
        return this.damage;
    }
}

class Wizard extends Character {
    private Spell spell;

    public Wizard(String name, int health, Spell spell) {
        super(name, health);
        this.spell = spell;
    }

    public void castSpell() {
        System.out.println(this.name + " casts " + this.spell.getSpellName() + " for " + this.spell.getDamage() + " damage!");
    }
}

class Warrior extends Character {
    private Weapon weapon;

    public Warrior(String name, int health, Weapon weapon) {
        super(name, health);
        this.weapon = weapon;
    }

    public void attack() {
        System.out.println(this.name + " swings " + this.weapon.getWeaponName() + " for " + this.weapon.getDamage() + " damage!");
    }
}
