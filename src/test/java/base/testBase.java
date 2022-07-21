package base;

import org.junit.After;
import org.junit.Before;

public class testBase {

    protected base.basePage basePage;

    @Before
    public void setup() {
        basePage = new basePage();
    }

    @After
    public void cleanup() {
        basePage.cleanup();
    }


}
