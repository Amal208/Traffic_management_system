package com.jiat.client;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import static com.jiat.client.TMS_UI.codinates;

public class Publisher {
    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("myTopicConnectionFactory");

            TopicConnection connection = factory.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = (Topic) context.lookup("myTopic");

            TopicPublisher publisher = session.createPublisher(topic);

            TextMessage message = session.createTextMessage();

            message.setText(String.valueOf(codinates));
            publisher.send(message);

//            publisher.publish(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
