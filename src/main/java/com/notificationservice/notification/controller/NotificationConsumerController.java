package com.notificationservice.notification.controller;

import com.notificationservice.notification.constant.DaprConfigurationConstants;
import com.notificationservice.notification.service.DaprService;
import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class NotificationConsumerController implements DaprConfigurationConstants {

    private static final Logger log = LoggerFactory.getLogger(NotificationConsumerController.class);
    @Autowired
    private DaprService daprService;

    @Topic(name = EMPLOYEE_ADD_NOTIFICATION_TOPIC, pubsubName = PUB_SUB)
    @PostMapping(value = EMPLOYEE_NOTIFICATION_ROUTE, consumes = MediaType.ALL_VALUE)
    public Mono<Void> employeeAddNotification(@RequestBody(required = false) CloudEvent<String> cloudEvent) {
        log.info("Employee add notification method call");
        return daprService.getNotification(cloudEvent);
    }

    @Topic(name = SCHEDULER_NOTIFICATION_TOPIC, pubsubName = PUB_SUB)
    @PostMapping(value = SCHEDULER_NOTIFICATION_ROUTE, consumes = MediaType.ALL_VALUE)
    public Mono<Void> schedulerNotification(@RequestBody(required = false) CloudEvent<String> cloudEvent){
        log.info("scheduler notification method call");
        return daprService.getNotification(cloudEvent);
    }

}
