import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import helpers.DatabaseHelpers;
import helpers.FileHelpers;
import helpers.OutputHelpers;

public class RoomData {

    private static String userName = "5354";
    private static String password = "devry_student";

    public static boolean saveRoomData(Room room) {
        Boolean success = false;
        PreparedStatement statement = null;
        StringBuilder sqlStr = new StringBuilder();

        try {
            success = openDataBaseConnection();
            if(success)
            {
                //build the SQL query string
                sqlStr.append("INSERT INTO ");
                sqlStr.append("flooring");
                sqlStr.append(" (CustomerName, CustomerAddress, FlooringType, FloorArea, FloorCost)");
                sqlStr.append(" values(?, ?, ?, ?, ?)");

                //get the connection and set the statement to connect to the database/table
                statement = DatabaseHelpers.getConnection().prepareStatement(sqlStr.toString());
                statement.setString(1, room.getCustomerName());
                statement.setString(2, room.getCustomerAddress());
                statement.setString(3, room.getFlooringType());
                statement.setDouble(4, room.getFloorArea());
                statement.setDouble(5, room.getFloorCost());
                
                //execute the query
                statement.executeUpdate();
                success = true;
            }
            
            	//save to file as a redundancy
            	writeRecord(room);
            	success = true;


        }
        catch  (SQLException e) {
        	
        	//something went wrong with database, open up backup file
        	writeRecord(room);
            success = false;
        }
        finally {
            closeDataBaseConnection();
        }
        return success;
    }

    public static ArrayList<Room> readList() {
        Boolean success = false;
        ArrayList<Room> roomList = new ArrayList<Room>();
        PreparedStatement statement = null;
        StringBuilder sqlStr = new StringBuilder();
        ResultSet resultSet;
        boolean success1 = false;
        //String sqlStr = "SELECT CustomerName, CustomerAddress, FlooringType, FloorArea, FloorCost FROM flooring";
        
        
        try {
            success1 = openDataBaseConnection();
            if(success1)
            {
            	sqlStr.append("SELECT * FROM flooring");
              //get the connection and set the statement to connect to the database/table
            	
            	statement = DatabaseHelpers.getConnection().prepareStatement(sqlStr.toString());
            	
                //build ArrayList to return
                ResultSet rs = statement.executeQuery();
                roomList =  new ArrayList<Room>();
                while(rs.next())
                {
                    Room c = new Room(rs.getString(1),rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5));

                    roomList.add(c);
                }
                success1 = true;
            }


        }
        catch  (SQLException e) {
            //something went wrong, read the backup data
        	roomList = null;
        	roomList = readRecords();
        	success1 = false;
        }
        finally {
            closeDataBaseConnection();
        }
        return roomList;
    }

    private static boolean openDataBaseConnection()
    {
        Boolean success = false;
        success = DatabaseHelpers.setConnection(userName, password);
        return success;
    }
    private static void closeDataBaseConnection()
    {
        try {
            DatabaseHelpers.closeConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
  //object serialization
  	public static void writeRecord(Room roomData) {
  		try {
  			StringBuilder str = new StringBuilder();
  			str.append(roomData.getCustomerName() + ",");
  			str.append(roomData.getCustomerAddress() + ",");
  			str.append(roomData.getFlooringType() + ",");
  			str.append(roomData.getFloorArea() + ",");
  			str.append(roomData.getFloorCost());
  			FileHelpers.writeData(str.toString(), "listData.txt");
  		}
  		catch (Exception ex) {
  			String prompt = "Room Data WriteRecord: cannot write to file\n";
  			OutputHelpers.showConsole(prompt);
  		}
  	}
  	
	public static ArrayList<Room> readRecords() {
		
		
		String name ="";
		String address ="";
		String type ="";
		double area = 0 ;
		double cost = 0 ;
		ArrayList<Room> theList = new ArrayList<Room>();
		
		String deliminator = "[,]";
		StringTokenizer row;
		try {
			ArrayList<String> listString = FileHelpers.readList("officeData.txt");
			for(String str : listString) {
				row = new StringTokenizer(str, deliminator);
				name = row.nextToken();
				address = row.nextToken();
				type = row.nextToken();
				area = Double.parseDouble(row.nextToken());
				cost = Double.parseDouble(row.nextToken());
				theList.add(new Room(name, address, type, area, cost));
			}
		}
		catch (Exception ex) {
			String prompt = "Office Data read records: cannot read file\n";
			OutputHelpers.showConsole(prompt);
		}
		return theList;
	}
}
