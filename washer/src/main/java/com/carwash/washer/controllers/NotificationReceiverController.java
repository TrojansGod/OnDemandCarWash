//package com.carwash.washer.controllers;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import com.carwash.washer.Config.MQConfig;
//import com.carwash.washer.models.Notification;
//
//@Component
//@CrossOrigin()
//public class NotificationReceiverController {
//
//    @RabbitListener(queues = MQConfig.QUEUE)
//    public void listener(Notification message) {
//        System.out.println(message);
//    }
//
//}