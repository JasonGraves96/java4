import java.util.ArrayList;

public class Entertainment {
private boolean outside;
public Entertainment(boolean outside) {
	super();
	this.outside = outside;
}
public boolean isOutside() {
	return outside;
}
public void setOutside(boolean outside) {
	this.outside = outside;
}
@Override
public String toString() {
	return "\n\nThis happened outside: " + outside;
}
}//end Entertainment