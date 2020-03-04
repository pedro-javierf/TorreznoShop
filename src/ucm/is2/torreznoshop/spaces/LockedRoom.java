package ucm.is2.torreznoshop.spaces;

public class LockedRoom extends Door {

	private boolean canUnlock;
	LockedRoom(Room r1, Room r2, int x, int y, boolean canUnlock) {
		super(r1, r2, x, y);
		this.canUnlock = canUnlock;
		// TODO Auto-generated constructor stub
	}
	public boolean isCanUnlock() {
		return canUnlock;
	}
	public void setCanUnlock(boolean canUnlock) {
		this.canUnlock = canUnlock;
	}

}
