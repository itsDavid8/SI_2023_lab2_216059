import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    void everyBranchTest(){
        {
        /*
        testCase1:
            input:  user=null,
                    allUsers=X
            expected:   RuntimeException
         */
            User user = null;
            List<User> allUsers = null;
            Exception ex;
            ex = assertThrows ( RuntimeException.class, () -> SILab2.function ( user, allUsers ) );
            assertEquals ( ex.getMessage ( ), "Mandatory information missing!" );
        }
        {
        /*
        testCase2:
            input:  user=[null, "123", "ds@gmail.com"],
                    allUsers={["ds@gmail.com",X,"ds@gmail.com"],["temp",X,"t@gmail.com"]}
            expected:   false
         */
            User user = new User ( null, "123", "ds@gmail.com" );
            List<User> allUsers = new ArrayList<> (  );
            allUsers.add ( new User("ds@gmail.com", null, "ds@gmail.com") );
            allUsers.add ( new User("temp",null,"t@gmail.com") );
            assertFalse ( SILab2.function ( user, allUsers ) );
        }
        {
            /*
            testCase3:
                input:  user=["temp","abc23fg#ijk","ds@gmailcom"]
                        allUsers=X
                expected:   false
             */
            User user = new User ( "temp", "abc23fg#ijk", "ds@gmailcom" );
            List<User> allUsers = null;
            assertFalse ( SILab2.function ( user, allUsers ) );
        }
        {
         /*
            testCase4:
                input:  user=["temp","abc23 fg#ijk","ds@gmailcom"]
                        allUsers=X
                expected:   false
          */
            User user = new User ( "temp", "abc23 fg#ijk", "ds@gmailcom" );
            List<User> allUsers = null;
            assertFalse ( SILab2.function ( user, allUsers ) );
        }
        {
            /*
            testCase5:
                input:  user=["temp","abc23fgijk","ds@gmailcom"]
                        allUsers=X
                expected:   false
             */
            User user = new User ( "temp", "abc23fgijk", "ds@gmailcom" );
            List<User> allUsers = null;
            assertFalse ( SILab2.function ( user, allUsers ) );
        }
    }
    @Test
    void multipleConditionTest(){
        {
            /*
            testCase1:
                input: user=null
                       user.getPassword()=X
                       user.getEmail()=X
                expected:   RuntimeException
             */
            User user = null;
            Exception ex;
            ex = assertThrows ( RuntimeException.class, () -> SILab2.function ( user, null ) );
            assertEquals ( ex.getMessage ( ), "Mandatory information missing!" );
        }
        {
            /*
            testCase2:
                input: user=[notNull]
                       user.getPassword()=null
                       user.getEmail()=X
                expected:   RuntimeException
             */
            User user = new User("I'm irrelevant :( sadface_emoji", null, "again");
            Exception ex;
            ex = assertThrows ( RuntimeException.class, () -> SILab2.function ( user, null ) );
            assertEquals ( ex.getMessage ( ), "Mandatory information missing!" );
        }
        {
            /*
            testCase3:
                input: user=[notNull]
                       user.getPassword()=[notNull]
                       user.getEmail()=null
                expected:   RuntimeException
             */
            User user = new User("I'm irrelevant :( sadface_emoji", "my cat typed this:)", null);
            Exception ex;
            ex = assertThrows ( RuntimeException.class, () -> SILab2.function ( user, null ) );
            assertEquals ( ex.getMessage ( ), "Mandatory information missing!" );
        }
        {
            /*
            testCase4:
                input:  user=["small_unprofessional","I_Got_Bored_abc23fg#ijk","ds@gmailcom"]
                        allUsers=X
                expected:   false
             */
            User user = new User ( "small_unprofessional", "I_Got_Bored_abc23fg#ijk", "ds@gmailcom" );
            List<User> allUsers = null;
            assertFalse ( SILab2.function ( user, allUsers ) );
        }
    }
}