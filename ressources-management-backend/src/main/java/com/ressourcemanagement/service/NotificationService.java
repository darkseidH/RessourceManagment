package com.ressourcemanagement.service;

import com.ressourcemanagement.model.Notification;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void saveNotification(Notification notification) {
        notificationRepository.save(notification);
    }


    public List<Notification> findAllByUser(User user) {
        return notificationRepository.findAllByUser(user);
    }

    public void deleteAll(List<Notification> notifications) {
        notificationRepository.deleteAll(notifications);
    }
}
