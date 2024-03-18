package org.soais.constants;

public final class FrameworkConstants
{
    private FrameworkConstants(){

    }

    private static final String chromeDriverPath=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
    private static final String edgeDriverPath=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
    private static final String ConfigPropertyPath=System.getProperty("user.dir")+"/src/test/resources/Configuration/Config.properties";
     public static String getChromeDriverPath()
     {
         return chromeDriverPath;
     }
     public static String getEdgeDriverPath()
     {
         return edgeDriverPath;
     }
    public static String getConfigPropertyPath()
    {
        return ConfigPropertyPath;
    }

}
