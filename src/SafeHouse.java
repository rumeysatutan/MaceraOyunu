
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player,"Güvenli Ev"); //name olarak bir deðiþken girmedik güvenli ev yazarak direkt ismi belirledik
	}
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Ýyileþtiniz...");
		System.out.println("Þuan Güvenli Ev adlý yerdesiniz.");
		return true;
		
	}

}
