package CreateTestCases;

import java.io.FileReader;
import java.util.Properties;

public class readProperties {
    public static void getProperties()
    {
        try {
            //To use the properties file we have to import the dependency “import java.util.Properties;” and invoke the properties class
            Properties props = new Properties();
            //String projectpath = System.getProperty("user.dir");
            //To read the file we have to use the Java Filereader and set the path of the properties file.
            FileReader reader = new FileReader("C:/Users/f5597986/IdeaProjects/FirstTest/config/config.properties");
            //Then we have to load the File into the properties using the load method.
            props.load(reader);
            //After that, we can access the data in the properties file by using the getProperty method
            String BrowserOption = props.getProperty("Browser");
            String linkGiven = props.getProperty("URL");
            System.out.println(BrowserOption);
            System.out.println("Here is the URL: "+linkGiven);
            baseClass.BrowserName = BrowserOption;
            baseClass.Url = linkGiven;

        } catch (Exception exp)
        {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
