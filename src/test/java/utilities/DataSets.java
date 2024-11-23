package utilities;

import org.testng.annotations.DataProvider;

public class DataSets {

    @DataProvider(name = "invalideCredentials")
    public static Object[][] invalidUserCredentials() {
        Object[][] data = {
                {"fameloh235@gmail.com", "pass", "Your email or password is incorrect!", ""},
                {"fameloh235@gmail.com", "pass", "Your email or password is incorrect!", ""},
                {"fameloh235@gmail.com", "pass", "Your email or password is incorrect!", ""},
                {"", "", "Please fill out this field."}
        };
        return data;
    }
}
