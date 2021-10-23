
public class Board extends Games {
private String name;
private int maximum;
private boolean dice;
private boolean cards;
public Board(String name, Boolean outside,int minAge, int maximum, boolean dice, boolean cards) {
	super(outside, minAge);
	this.name = name;
	this.maximum = maximum;
	this.dice = dice;
	this.cards = cards;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMaximum() {
	return maximum;
}
public void setMaximum(int maximum) {
	this.maximum = maximum;
}
public boolean isDice() {
	return dice;
}
public void setDice(boolean dice) {
	this.dice = dice;
}
public boolean isCards() {
	return cards;
}
public void setCards(boolean cards) {
	this.cards = cards;
}
@Override
public String toString() {
	String result = super.toString();
	result += "\nName: " + name + "\nMaximum Players: " + maximum +  "\nUses dice? " + dice + "\nUses cards? " + cards;
	return result;
}

}//end Board
