package services;

import com.management.school.model.Person;
import com.management.school.services.serviceImplementation.PrincipalActions;
import com.management.school.services.serviceImplementation.TeacherActions;
import com.management.school.utilities.PersonData;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.NoPermissionException;

public class PrincipalAcTest {
    PrincipalActions principalActions = new PrincipalActions();


    public PrincipalAcTest() throws NoPermissionException {
        PersonData.setIdList(12);
        Person principal = new Person(12, "Ade", "Teacher", "Male");
        Person student = new Person("Nana", "Student", 25);
        Assert.assertNotNull(principalActions.admitApplicant(principal, student));
    }

    @Test
    public void admitApplicant(){
       
    }
}
