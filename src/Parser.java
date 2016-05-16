import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import rooms.*;


public class Parser {
	
	Set<String> verbs; 
	Set<String> directions;
	Set<String> oneWordCommands;
	
	public Parser (){
		//Initializes list of verbs
		verbs = new HashSet<String>();
		
		directions = new HashSet<String>();
		directions.add("north");
		directions.add("south");
		directions.add("east");
		directions.add("west");
		
		oneWordCommands = new HashSet<String>();
		oneWordCommands.add("save");
		oneWordCommands.add("wait");
		oneWordCommands.add("pun");
		oneWordCommands.add("look");
		oneWordCommands.add("inventory");
		oneWordCommands.add("help");
		oneWordCommands.add("quit");
		
	}
	
	//Precondition: Each verb is on its own line in verbFile
	public Parser (String verbFile) throws FileNotFoundException{
		Scanner in = new Scanner(new File(verbFile));
		verbs = new HashSet<String>();
		while(in.hasNextLine()){
			verbs.add(in.nextLine());
		}
		in.close();
		
		directions = new HashSet<String>();
		directions.add("north");
		directions.add("south");
		directions.add("east");
		directions.add("west");
		
		oneWordCommands = new HashSet<String>();
		oneWordCommands.add("save");
		oneWordCommands.add("wait");
		oneWordCommands.add("pun");
		oneWordCommands.add("look");
		oneWordCommands.add("inventory");
		oneWordCommands.add("help");
		oneWordCommands.add("quit");
		
	}
	
	public boolean isVerb (String str){
		return verbs.contains(str.toLowerCase());
	}
	
	public boolean isNoun (String str, Room rm, Inventory inv){
		return rm.containsItem(str) || inv.containsItem(str) 
				|| str.equalsIgnoreCase("me") || directions.contains(str)
				|| str.equalsIgnoreCase("phone");
	}
	
	public String getCommand(Scanner in, Room rm, Inventory inv){
		String cmd[] = in.nextLine().toLowerCase().split(" ");
		
		//Checks for one word commands
		if(cmd.length == 1){
			if(oneWordCommands.contains(cmd[0])){
				return cmd[0];
			} else {
				return "NA";
			}
		}
		
		//Makes noun from cmd
		String noun = "";
		for(int i = 1; i < cmd.length; i++){
			noun = noun + " " + cmd[i];
		}
		noun = noun.trim();
		
		//Checks if the command is legal
		if(isVerb(cmd[0]) && isNoun(noun, rm, inv)) { 
			return cmd[0] + " " + noun; 
		} else {
			return "NA"; 
		}
	}
	
	
}
