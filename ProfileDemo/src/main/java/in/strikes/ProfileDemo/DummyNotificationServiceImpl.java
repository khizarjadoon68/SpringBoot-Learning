package in.strikes.ProfileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyNotificationServiceImpl implements NotificationService {


    @Override
    public String send() {

        //Dummy Notification

        return "Here is a Dummy Notification";
    }

}
