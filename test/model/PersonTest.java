package model;

import com.management.school.model.Person;
import com.management.school.utilities.PersonData;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NoPermissionException;

public class PersonTest {
    Person applicant = new Person("Nana", "Teacher", 30);

    public PersonTest() throws NoPermissionException {
        PersonData.setIdList(11);
        Person teacher = new Person(11, "Ade", "Teacher", "Male");

        Assert.assertEquals(11, teacher.getId());
        Assert.assertEquals("Teacher", teacher.getRole());
        Assert.assertEquals("Male", teacher.getGender());

        teacher.setAddress("aaa");
        Assert.assertEquals("aaa", teacher.getAddress());
    }

    @Test
    public void getApplicantAge(){
        Assert.assertEquals(30, applicant.getApplicantAge());
    }

    @Test
    public void getApplicantRole(){
        Assert.assertEquals("Teacher", applicant.getApplicantRole());
    }

    @Test
    public void getApplicantName(){
        Assert.assertEquals("Nana", applicant.getApplicantName());
    }

}
