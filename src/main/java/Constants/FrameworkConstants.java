package Constants;

public final class FrameworkConstants
{
    private FrameworkConstants(){

    }
    private static final String chromeDriverPath="System.getProperty(\"user.dir\")+\"/Drivers/chrome_proxy.exe\"";
     public static String getChromeDriverPath()
     {
         return chromeDriverPath;
     }

}
