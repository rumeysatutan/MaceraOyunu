
public abstract class BattleLoc extends Location //abstract tan�mlamam�z�n sebebi burdan nesne olu�turmak istememek
{
	protected Obstacle obstacle;
	protected String award;
	
	BattleLoc(Player player, String name,Obstacle obstacle,String award){
		super(player);
		this.obstacle=obstacle;
		this.name=name;
		this.award=award;
	}
	public boolean getLocation() {
		int obsCount=obstacle.count(); //ka� tane canavar ��kaca��n� belirleyen fonk. �a��r�yoruz.
		System.out.println("�uan buradas�n�z: "+this.getName());
		System.out.println("Dikkatli ol! Burada "+obsCount+" tane "+obstacle.getName()+" ya��yor!");
		System.out.print("<S>ava� veya <K>a�");
		String selCase=scan.nextLine();
		selCase=selCase.toUpperCase();//yaz�lan  harfi b�y�k harfe �eviriyor
		if(selCase.equals("S")) {
			
			if(combat(obsCount)) { //combat(obsCount)==true ile ayn� i�lemi ger�ekle�tiriyor.
				System.out.println(this.getName()+" b�lgesindeki t�m d��manlar� temizlediniz! ");
				
				if(this.award.equals("Food")&& player.getInv().isFood()==false) { //e�er food kazand�ysa ve kullan�c�n�n inventorysinde food yoksa �art� koyduk.
					System.out.println(this.award+" Kazand�n�z! ");	
					player.getInv().setFood(true);	
				}
				else if(this.award.equals("Water")&& player.getInv().isWater()==false) { //e�er food kazand�ysa ve kullan�c�n�n inventorysinde food yoksa �art� koyduk.
					System.out.println(this.award+" Kazand�n�z! ");	
					player.getInv().setWater(true);	
				}
				else if(this.award.equals("FireWood")&& player.getInv().isFirewood()==false) { //e�er food kazand�ysa ve kullan�c�n�n inventorysinde food yoksa �art� koyduk.
					System.out.println(this.award+" Kazand�n�z! ");	
					player.getInv().setFirewood(true);	
				}
				return true;
			}
			if(player.getHealthy()<=0) {
				System.out.println("�ld�n�z !");
				return false;
			}
			
		}
		return true;
	}
	public boolean combat(int obsCount) {
		for(int i=0;i<obsCount;i++) {
			int defObsHealth=obstacle.getHealth();
			playerStarts();
			enemyStarts(); 
			while(player.getHealthy()>0 && obstacle.getHealth()>0) {
				System.out.print("<V>ur veya <K>a�: ");
				String selCase=scan.nextLine();
				selCase=selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Siz vurdunuz!");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage()); //Canavar�n can�n� azaltt�k.
					afterHit();
					if(obstacle.getHealth()>0) {
						System.out.println();
						System.out.println("Canavar size vurdu");
						player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
						afterHit();	}
					
				}else
					{
					return false;
				}
			}
			if(obstacle.getHealth()<player.getHealthy()) {
				System.out.println("D��man� yendiniz!");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("G�ncel Paran�z: "+player.getMoney());
				obstacle.setHealth(defObsHealth);
			}else {
				return false;
			}
			System.out.println("--------------------------");
		}
		return true;
	}
	public void playerStarts() {
		System.out.println("Oyuncu De�erleri\n --------");
		System.out.println("Can :"+player.getHealthy());
		System.out.println("Hasar:"+player.getTotalDamage());
		System.out.println("Para:"+player.getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah:"+player.getInv().getwName());	
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Z�rh:"+player.getInv().getaName());	
		}
	}
	public void enemyStarts() {
		System.out.println("\n" +obstacle.getName()+"De�erleri/n--------");
		System.out.println("Can:"+obstacle.getDamage());
		System.out.println("Hasar:"+obstacle.getDamage());
		System.out.println("�d�l:"+obstacle.getAward());
		
	}
	public void afterHit() {
		System.out.println("Oyuncu can�: "+player.getHealthy());
		System.out.println(obstacle.getName()+" Can�: "+obstacle.getHealth());
		System.out.println();
		
		
	}
	
	
}
