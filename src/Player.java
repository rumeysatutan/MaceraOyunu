import java.util.Scanner;

public class Player {
	private int damage,healthy,money,rHealthy;
	private String name,cName;
	private Inventory inv;
	Scanner scan=new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv=new Inventory();
	}
	
	public void selectCha() {
		switch(chaMenu()) {
		case 1: 
			initPlayer("Samuray",5,21,15);
			break;
		case 2: 
			initPlayer("Ok�u",7,18,20);
			break;
		case 3: 
			initPlayer("��valye",8,24,5);
			break;
		default:
			initPlayer("Samuray",5,21,15);
			break;
		}
		System.out.println("Karakter:"+getcName()+"\t Hasar:"+getDamage()+"\t Sa�l�k:"+getHealthy()+"\t Para"+getMoney());
		
		
		
	}
	public void initPlayer(String cName,int dmg,int hlthy,int mny) {
		setcName(cName);
		setDamage(dmg);
		setHealthy(hlthy);
		setMoney(mny);
		setrHealthy(hlthy); 
	}
	
	public int chaMenu() {
		System.out.println("L�tfen bir krakter se�iniz: ");
		System.out.println("1- Samuray \t Hasar:5\t sa�l�k:21\t Para:15");
		System.out.println("2- Ok�u \t Hasar:7\t sa�l�k:18\t Para:20");
		System.out.println("3- ��valye \t Hasar:8\t sa�l�k:24\t Para:5");
		System.out.println("Se�iminiz:");
		int chaID=scan.nextInt();
		
		while(chaID<1||chaID>3) {
			System.out.print("L�tfen ge�erli bir de�er giriniz");
			chaID=scan.nextInt();
			
		}
		return chaID;
		
	}
	public int getTotalDamage() {
	return this.getDamage()+this.getInv().getDamage();	
	} 

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
	
	
	
}
