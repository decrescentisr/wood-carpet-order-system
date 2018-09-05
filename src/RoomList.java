import java.util.ArrayList;

public class RoomList {
	
	public static ArrayList<Room> List() {
		
		ArrayList<Room> theList = null;
		theList = RoomData.readList();

		return theList;
	}
	
}
