package Plant_investment;

public class Plant {
	boolean empty;
	int livemonth;
	float value;
	float percent;
	int cycle;
	public Plant(int m, float v, float p, int c) {
		empty = false;
		livemonth = m;
		value = v;
		percent = p;
		cycle = c;
	}
	public Plant() {
		empty = true;
		livemonth = 0;
		value = 0;
		percent = 0;
		cycle = 0;
	}

}
