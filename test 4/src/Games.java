public class Games extends Entertainment {
	private int minAge;

	public Games(Boolean outside,int minAge) {
		super(outside);
		this.minAge = minAge;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	@Override
	public String toString() {
		String result = super.toString();
		result += "\nMinimum Age: " + minAge;
		return result;
	}
}//end Games
