
public abstract class NormalLoc extends Location {

	NormalLoc(Player player,String name) {
		super(player);
		this.name=name;
	}
	public boolean getLocation() {
		return true; //safe house ve ma�azaya gitti�inde can yanmad��� i�in true d�nd�r�yoruz.
	}
}
