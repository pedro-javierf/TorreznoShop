package ucm.is2.torreznoshop.elements;

import java.util.Random;

import ucm.is2.torreznoshop.spaces.Room;

public class Boss extends NPC {
	private String threat1;
	private String threat2;
	private String threat3;
	private String deadText;
	private int attackIdx;

	public Boss(String name, int hp, int money, Room startingRoom, int xpos, int posy, int attack) {
		super(name, hp, money, startingRoom, xpos, posy);
		attackIdx = attack;
	}
	
	public void attack(Player p) {
		System.out.println(chooseThreatMsg());
		p.setHP(p.getHP()-attackIdx);
	}
	
	public String getThreat1() {
		return threat1;
	}

	public void setThreat1(String threat1) {
		this.threat1 = threat1;
	}

	public String getThreat2() {
		return threat2;
	}

	public void setThreat2(String threat2) {
		this.threat2 = threat2;
	}

	public String getThreat3() {
		return threat3;
	}

	public void setThreat3(String threat3) {
		this.threat3 = threat3;
	}

	public String getDeadText() {
		return deadText;
	}

	public void setDeadText(String deadText) {
		this.deadText = deadText;
	}

	private String chooseThreatMsg() {
		Random r = new Random();
		int option = r.nextInt(4);
		
		switch(option) {
		case 0:
			return "Boss: You shouldn't have come all the way here...";
		case 1:
			return threat1;
		case 2:
			return threat2;
		case 3:
			return threat3;
		default:
			return "Boss: TAKE THIS!";
		}
	}

}
