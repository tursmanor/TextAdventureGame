import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import rooms.*;


public class Parser {
	
	Set<String> verbs; 
	
	public Parser (){
		//Initializes list of verbs
		verbs = new HashSet<String>();
		
	}
	
	//Precondition: Each verb is on its own line in verbFile
	public Parser (String verbFile) throws FileNotFoundException{
		Scanner in = new Scanner(new File(verbFile));
		verbs = new HashSet<String>();
		while(in.hasNextLine()){
			verbs.add(in.nextLine());
		}
		in.close();
	}
	
	public boolean isVerb (String str){
		return verbs.contains(str.toLowerCase());
	}
	
	public boolean isNoun (String str, Room rm, Inventory inv){
		return rm.containsItem(str) || inv.containsItem(str) || str.equalsIgnoreCase("me");
	}
	
	public String getCommand(Scanner in, Room rm, Inventory inv){
		String cmd[] = in.nextLine().toLowerCase().split(" ");
		
		//Checks for one word commands
		if(cmd.length == 1){
			if(cmd[0].equals("pun") || cmd[0].equals("wait") || 
					cmd[0].equals("quit") || cmd[0].equals("look") || cmd[0].equals("inventory")){
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
