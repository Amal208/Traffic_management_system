package ejb.message;

import ejb.remote.TrafficRoot;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.*;

import javax.naming.InitialContext;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myTopic")
        }
)
public class MessageReceiver implements MessageListener {
    public static String msg;
    @Override
    public void onMessage(Message message) {
        try {
            msg = message.getBody(String.class);
//            ObjectMessage objectMessage = (ObjectMessage) message.getBody(Object.class);
            System.out.println(msg);

            InitialContext context = new InitialContext();
            TrafficRoot root =(TrafficRoot) context.lookup("java:global/ear/app/TrafficRootBean");
            root.vehicleCount(msg);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



