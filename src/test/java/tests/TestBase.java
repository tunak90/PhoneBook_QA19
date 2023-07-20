package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //   WebDriver wd;
    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)

    public void setUp() throws IOException {
        app.init();
    }


    @AfterSuite(alwaysRun = true)
//    public void tearDown() {
//        wd.quit();
//
//    }
    public void stop() {
  //      app.tearDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method method){
        logger.info("Start test" + method.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void end(){
        logger.info("===============================================");
    }

}

