package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;



/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        //create Job objects
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //declare & initialize Job object
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        //test that constructor assigns correct class & value for each field
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job.getName(),"Product Tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        // two Job objects with same fields
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        // test that equals returns false with dif IDs
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        // job object
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String stringJob = job.toString();
        char firstChar = stringJob.charAt(0);
        char lastChar = stringJob.charAt(stringJob.length() - 1);

        assertEquals("\n", Character.toString(firstChar));
        assertEquals("\n", Character.toString(lastChar));
    }
}
