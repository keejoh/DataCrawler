//Imports the necessary libraries
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class compareSocialRecommendations {
//creates the necessary datafields
private String name;
private JSONArray fbGroups;
private ArrayList<String> twFriends;
//default contructor
public compareSocialRecommendations(){
	
}
//Creates an object that stores the corresponding Facebook and Twitter data
public compareSocialRecommendations(String name,JSONArray fbGroups,ArrayList<String>twFriends) {
	this.name=name;
	this.fbGroups=fbGroups;
	this.twFriends=twFriends;
}
//Returns the Facebook groups from the given user and displays it on console 
public void getFbPages() {
		for (int i = 0; i < fbGroups.length(); i++) {
			JSONObject names = fbGroups.getJSONObject(i);
			System.out.println(names.get("name"));
		}
 }
//Returns the Twitter friends from the given user and displays it on console
public void getTWFriends() {
	for(int i=0;i<twFriends.size();i++)
	System.out.println(twFriends.get(i));
}
//Returns the user in questions name
public String getName() {
	return this.name;
	
}
}
