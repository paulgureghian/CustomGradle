package com.udacity.gradle.builditbigger;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class EndpointsAsyncTaskTest {

    EndpointsAsyncTask asyncTask = new EndpointsAsyncTask();

    @Test
    public void AsyncTaskTest() throws Exception {

        String result = asyncTask.execute().get(60, TimeUnit.SECONDS);

        assertNotNull(result);
        assertTrue("Test Failed",result.length() > 0);
    }
    @org.junit.Test
    public void testDoInBackground() throws Exception {
    }
    @org.junit.Test
    public void testOnPostExecute() throws Exception {
    }
}