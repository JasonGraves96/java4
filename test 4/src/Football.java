
public class Football extends Games {
private String homeName;
private String awayName;
private int homeScore;
private int awayScore;
public Football(Boolean outside,int minAge, String homeName, String awayName, int homeScore, int awayScore) {
	super(outside, minAge);
	this.homeName = homeName;
	this.awayName = awayName;
	this.homeScore = homeScore;
	this.awayScore = awayScore;
}
public String getHomeName() {
	return homeName;
}
public void setHomeName(String homeName) {
	this.homeName = homeName;
}
public String getAwayName() {
	return awayName;
}
public void setAwayName(String awayName) {
	this.awayName = awayName;
}
public int getHomeScore() {
	return homeScore;
}
public void setHomeScore(int homeScore) {
	this.homeScore = homeScore;
}
public int getAwayScore() {
	return awayScore;
}
public void setAwayScore(int awayScore) {
	this.awayScore = awayScore;
}
@Override
public String toString() {
	String result = super.toString();
	result += "\n" + homeName + ": " + homeScore + "\n" + awayName + ": " + awayScore;
	
	return result;
}

}//end Football
