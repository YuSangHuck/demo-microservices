package com.demo.notification.service;

import com.demo.clients.notification.NotificationRequest;
import com.demo.notification.domain.Notification;
import com.demo.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("demo")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build());
    }
}
