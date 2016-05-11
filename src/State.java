import rooms.Room;

//DEPRECATED
public class State {
	
	int turns;
	Room[][] GameMap;
	
	public State (){
		//Initialize Game Map
		GameMap = new Room[5][5];
		for(int i = 0; i < GameMap[0].length; i++){
			for(int j = 0; j < GameMap.length; j++){
				GameMap[i][j] = null;
			}
		}
		
		//Set rooms
		//GameMap[1][0] = new Room("Bathroom");
		//GameMap[0][1] = new Room("Parent's Room");
		//GameMap[0][2] = new Room("Closet");
	}
}
