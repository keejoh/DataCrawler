import java.util.Scanner;
import java.io.InputStream;
import org.json.JSONObject;
public class JSONUtils {
	public static String getJSONStringFromFile(String path) {
		Scanner scanner;
		InputStream in= FileHandle.inputStreamFromUrl(path);
			scanner = new Scanner(in);
		String json = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return json;
	}

	public static boolean objectExists(JSONObject jsonObject,String key) {
		Object o;
		try {
			o = jsonObject.get(key);
		}catch(Exception e) {
			return false;
		}
		return o !=null;
	}
}

