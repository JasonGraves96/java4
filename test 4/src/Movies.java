import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Movies extends Entertainment {
private String title;
private int year;
private int star;
public Movies(Boolean outside, String title, int year, int star) {
	super(outside);
	this.title = title;
	this.year = year;
	this.star = star;
}
@Override
public String toString() {
	String result = super.toString();
	result += "\nTitle: " + title + "\nYear: " + year + "\nRating: " + star + "\n";
	return result;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getStar() {
	return star;
}
public void setStar(int star) {
	this.star = star;
}
}//end Movies