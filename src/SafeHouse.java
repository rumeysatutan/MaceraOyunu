
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player,"G�venli Ev"); //name olarak bir de�i�ken girmedik g�venli ev yazarak direkt ismi belirledik
	}
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("�yile�tiniz...");
		System.out.println("�uan G�venli Ev adl� yerdesiniz.");
		return true;
		
	}

}
