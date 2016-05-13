import rooms.Hallway;
import rooms.Room;
import rooms.YourRoom;


public class Map {
	private Room[][] gameMap;
	private int xCoord;
	private int yCoord;
	
	public Map(){
		//Initialize Game Map
				gameMap = new Room[5][5];
				for(int i = 0; i < gameMap[0].length; i++){
					for(int j = 0; j < gameMap.length; j++){
						gameMap[i][j] = null;
					}
				}
				
				//Set rooms
				gameMap[0][3] = new YourRoom("Your Room");
				gameMap[1][3] = new Hallway("Hallway");
				gameMap[1][2] = new Hallway("Hallway");
				gameMap[1][1] = new Hallway("Hallway");
				
				xCoord = 3;
				yCoord = 0;
	}
	
	public boolean go(Room curRoom, String direction) throws Exception{
		
		direction = direction.toLowerCase();
		
		if(curRoom.directions.get(direction)){
			if (direction.equals("north")) { yCoord--; }
			else if (direction.equals("east")) { xCoord++; }
			else if (direction.equals("south")) { yCoord++; }
			else { xCoord--; };
			return true;
			
		} else {
			System.out.println("You can't travel through walls.");
			return false;
		}
	}
	
	public Room getCurRoom(){
		return gameMap[yCoord][xCoord];
	}
}
