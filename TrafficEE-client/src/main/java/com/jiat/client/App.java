package com.jiat.client;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class App {
    public static void main(String[] args) {

                try {
                    InitialContext context = new InitialContext();
                    TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("myTopicConnectionFactory");

                    TopicConnection connection = factory.createTopicConnection();
                    connection.start();

                    TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

                    Topic topic = (Topic) context.lookup("myTopic");
                    TopicSubscriber subscriber = session.createSubscriber(topic);

                    subscriber.setMessageListener(new MessageListener() {
                        @Override
                        public void onMessage(Message message) {

                            try {
                                String m = message.getBody(String.class);
                                System.out.println(m);
                            } catch (JMSException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

                    while (true){

                    }

            }catch (Exception e) {
                    throw new RuntimeException(e);
                }

        }
    }

