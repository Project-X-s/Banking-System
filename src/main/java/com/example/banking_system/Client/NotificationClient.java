package com.example.banking_system.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.banking_system.Module.Transition;

@FeignClient(
    name = "NotificationClient",
    url = "${client-notification-service.url}"
)

public interface NotificationClient {
    
    @PostMapping
    ResponseEntity<Void> sendNotification(@RequestBody Transition transition);
}
