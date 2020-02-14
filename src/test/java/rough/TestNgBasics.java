package rough;

import org.testng.annotations.*;

public class TestNgBasics {

    //TestNg Annotations sequence
/*
    @BeforeSuite -- setup system property for chrome
    @BeforeTest -- launchBrowser
    @BeforeClass -- login to app
    @BeforeMethod -- enter URL
    @Test -- google logo test
    @AfterMethod -- logout from app
    @BeforeMethod -- enter URL
    @Test --- Google Title Test
    @AfterMethod -- logout from app
    @BeforeMethod -- enter URL
    @Test -- search test
    @AfterMethod -- logout from app
    @AfterClass -- Close Browser
    @AfterTest -- deleteAllCookies
    @AfterSuite -- close the Web driver session

===============================================
    Default Suite
    Total tests run: 3, Failures: 0, Skips: 0
            ===============================================
*/


    //Pre-conditions annotations -- starting with @Before
    @BeforeSuite //1
    public void setUp() {
        System.out.println("@BeforeSuite -- setup system property for chrome");
    }

    @BeforeTest //2
    public void launchBrowser() {
        System.out.println("@BeforeTest -- launchBrowser");
    }


    @BeforeClass //3
    public void login() {
        System.out.println("@BeforeClass -- login to app");
    }


    /*
     * @BeforeMethod
     * @Test -1
     * @AfterMethod
     *
     * @BeforeMethod
     * @Test -2
     * @AfterMethod
     *
     * @BeforeMethos
     * @Test -3
     * @AfterMethod
     *
     */


    @BeforeMethod //4
    public void enterURL() {
        System.out.println("@BeforeMethod -- enter URL");
    }


    //test cases--starting with @Test
    @Test //5
    public void googleTitleTest() {
        System.out.println("@Test --- Google Title Test");
    }

    @Test
    public void searchTest() {
        System.out.println("@Test -- search test");
    }

    @Test
    public void googleLogoTest() {
        System.out.println("@Test -- google logo test");
    }


    //post conditions -- starting with @After
    @AfterMethod //6
    public void logOut() {
        System.out.println("@AfterMethod -- logout from app");
    }

    @AfterClass //7
    public void closeBrowser() {
        System.out.println("@AfterClass -- Close Browser");
    }

    @AfterTest //8
    public void deleteAllCookies() {
        System.out.println("@AfterTest -- deleteAllCookies");
    }

    @AfterSuite
    public void quitSession() {
        System.out.println("@AfterSuite -- close the Web driver session");
    }
}
