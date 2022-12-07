package CreateBaseClass;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Properties;

public class getProperties {


    public static void main(String[] args)
    {
        readProperties();
        writeProperties();
        readProperties();
    }
    static Properties props = new Properties();


        public static void readProperties()
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
                String Browser = props.getProperty("Browser");
                System.out.println(Browser);


            } catch (Exception exp) {
                System.out.println(exp.getMessage());
                System.out.println(exp.getCause());
                exp.printStackTrace();
            }

        }
        public static void writeProperties()
        {
            try
            {
            OutputStream write = new FileOutputStream("C:/Users/f5597986/IdeaProjects/FirstTest/config/config.properties");
            props.setProperty("Browser","Firefox");
            props.store(write,null);
                System.out.println(write);

            }
                catch(Exception exp)
    {

    }


    }
}
