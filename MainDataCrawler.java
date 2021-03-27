//imports the necessary libraries
import java.util.Scanner;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;

public class MainDataCrawler {

	public static void main(String[] args) {
		//creates a string that stores the url that calls the Facebook API
		String URLString = "Place your api key here ";
		//creates a reference variable that will hold the Facebook API data as a string
		String jsonData = "";
		//creates a URL object and scanner that reads and writes data from the url and stores it in 'jsonData' all within a try catch block to catsh potential IO and URL errors.
		
		try {
			java.net.URL url = new java.net.URL(URLString);
			Scanner input = new Scanner(url.openStream());
			while (input.hasNext()) {
				jsonData = input.nextLine();
				
			}
			input.close();
		} catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		} catch (java.io.IOException ex) {
			System.out.println("IO Errors");
		}
	
		//creates a JSONOBject from the data in jsonData  
		JSONObject jsonAPIData = new JSONObject(jsonData);
		//creates a JSONArray that grabs the desired data from jsonAPIData 
		JSONArray jsonArray = jsonAPIData.getJSONObject("groups").getJSONArray("data");
		//Sets the necessary data fields from the twitter4j library to be able to call the Twitter API
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("")
				.setOAuthConsumerSecret("place appropriate keys here")
				.setOAuthAccessToken("place appropriate keys here")
				.setOAuthAccessTokenSecret("place appropriate keys here");
		TwitterFactory tf = new TwitterFactory(cb.build());
		//creates the Twitter object necessary to manipulate the Twitter API data
		Twitter twitter = tf.getInstance();
		//creates an ArrayList of string type that stores the Twitter friends from the given user. 
		ArrayList<String> twFriends = new ArrayList<String>();
		//Grabs the ID's of the given user's friends and grabs the equivalent user name corresponding to the id and stores them in 'twFriends'
		try {
			IDs myFriends;
			myFriends = twitter.getFriendsIDs("User ID here", -1);
			for (long id : myFriends.getIDs()) {
				User user = twitter.showUser(id);
				twFriends.add(user.getName());

			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//creates a 'compareSocialRecommendations' object that stores the user's Facebook groups(jsonArray variable) and Twitter friends (twFriends variable) 
		compareSocialRecommendations compareUsers = new compareSocialRecommendations("Profile Name Here", jsonArray, twFriends);
		//prints the user's name, Facebook groups, and Twitter friends
		System.out.println("The user data we are looking at is from "+ compareUsers.getName()+ " and the groups they are in are as follows: ");
		compareUsers.getFbPages();
		System.out.println("The same users twitter friends are the following:");
		compareUsers.getTWFriends();
	}

}
