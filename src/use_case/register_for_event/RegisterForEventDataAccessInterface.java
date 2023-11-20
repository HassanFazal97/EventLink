package use_case.register_for_event;

import entity.user.CommonUser;

public interface RegisterForEventDataAccessInterface {
    CommonUser getUsername(String username);

    void updateUser(CommonUser commonUser);
}
