package com.notificationservice.notification.service;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DaprService {

    private static final Logger log = LoggerFactory.getLogger(DaprService.class);


    @Autowired
    private DaprClient daprClient;



    public Mono<Void> getNotification(CloudEvent<String> cloudEvent){
        //daprClient.subscribeConfiguration();
      return Mono.fromRunnable(()->{
                     log.info(cloudEvent.getData());
              }

      );
    }
}
