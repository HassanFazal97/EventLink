package entity.user;

import java.util.List;

public interface User {

    String getFirstName();

    String getLastName();

    String getUsername();

    String getPassword();

    List<String> getTags();
}
