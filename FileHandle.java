/**
 * 
 */

/**
 * @author keejo
 *
 */
import java.io.InputStream;
public class FileHandle {

 public static InputStream inputStreamFromUrl (String path) {
 try {
	 InputStream inputStream = FileHandle.class.getResourceAsStream(path);
	 return inputStream;
 }catch(Exception e) {
	 e.printStackTrace();
 }
 	return null;
 }
 }
