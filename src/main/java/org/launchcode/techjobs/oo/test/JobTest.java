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
    //test 1
    public void testSettingJobId() {
        //create Job objects
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    // test 2
    public void testJobConstructorSetsAllFields() {
        //declare & initialize Job object
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        //test that constructor assigns correct class & value for each field
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job.getName(),"Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    // test 3
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
    // test 4
    public void testToStringStartsAndEndsWithNewLine() {
        // job object
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals('\n', job.toString().charAt(0));
        assertEquals('\n', job.toString().charAt(job.toString().length() - 1));

//        String stringJob = job.toString();
//        char firstChar = stringJob.charAt(0);
//        char lastChar = stringJob.charAt(stringJob.length() - 1);
//
//        assertEquals("\n", Character.toString(firstChar));
//        assertEquals("\n", Character.toString(lastChar));
    }

    @Test
    // test 5
    public void testToStringContainsCorrectLabelsAndData() {
        // Create a Job object with specific values
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals('\n' +
                "ID: " + job.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                '\n', job.toString());
    }

    @Test
    // test 6
    public void testToStringHandlesEmptyField() {
        // Create a Job object with empty name
        Job job = new Job("", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency(""));

        assertEquals('\n' +
                "ID: " + job.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Desert" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available" +
                '\n', job.toString());

        // Test that toString handles empty field
//        String jobExpectedString = "\n" +
//                "ID: _____\n" +
//                "Name: Data not available\n" +
//                "Employer: ACME\n" +
//                "Location: Desert\n" +
//                "Position Type: Quality control\n" +
//                "Core Competency: Persistence\n" +
//                "\n";
//        assertEquals(jobExpectedString, job.toString());
//        assertEquals("OOPS! This job does not seem to exist.", job.toString());
    }

}
