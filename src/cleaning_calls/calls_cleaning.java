package cleaning_calls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class calls_cleaning
{
  @SuppressWarnings("resource")
public static void main(String[] args)
    throws IOException
  {
    int n = 0;
//    int lb = 0;int rb = 0;int line = 0;
    
    File file = new File(System.getProperty("user.dir") + "/resources/action.c");
    File file2 = new File(System.getProperty("user.dir") + "/resources/removed_unwanted_Script.txt");
    Scanner scan = new Scanner(file).useDelimiter(";");
    while (scan.hasNext())
    {
      n++;
      String s = scan.next();
      if (((!s.contains(".css")) && (!s.contains(".js")) && (!s.contains(".gif")) && (!s.contains(".png")) && (!s.contains(".ico"))) || (s.contains(".jsp")))
      {
        FileWriter fileWritter = new FileWriter(file2, true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(s);
        if (scan.hasNext()) {
          bufferWritter.write(";");
        }
        bufferWritter.close();
        fileWritter.close();
      }
    }
    
    scan.close();
    System.out.print("The Sript is ready at location" + System.getProperty("user.dir")+"/resources/");
    System.out.print("\resources\removed_unwanted_Script.txt");
  }
}
