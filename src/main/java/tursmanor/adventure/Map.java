package tursmanor.adventure;

import tursmanor.adventure.rooms.*;

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
				
				//Some room descriptions
				String leftHall = "The second floor hallway is adorned with a CARPET. \n" +
						"There is a bathroom to the WEST. Your parent's room is NORTH.";
				String centerHall = "The second-floor hallway is adorned with a CARPET \n" +
						"and a painting of some flowers. It continues to the EAST and WEST.\n" +
						" There is a closet to the NORTH. ";
				String rightHall = "The second floor hallway is adorned with a CARPET. \n" +
						"It continues to the WEST. To the EAST is a staircase leading \n" +
						"leading to the living room. To the NORTH is your room.";
				
				//Set rooms
				gameMap[0][1] = new ParentsRoom("Your Parents' Room");
				gameMap[0][2] = new Closet("Closet");
				gameMap[0][3] = new YourRoom("Your Room");
				gameMap[1][0] = new Bathroom("Bathroom");
				gameMap[1][1] = new Hallway("Hallway", leftHall);
				gameMap[1][2] = new Hallway("Hallway", centerHall);
				gameMap[1][3] = new Hallway("Hallway", rightHall);
				gameMap[1][4] = new LivingRoom("Living Room");
				gameMap[2][4] = new DiningRoom("Dining room");
				gameMap[3][4] = new Kitchen("Kitchen");
				gameMap[4][4] = new Basement("Basement");
				
				//Set starting position
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
	public Room getRoom(int xCoord, int yCoord){
		return gameMap[yCoord][xCoord];
	}
}
