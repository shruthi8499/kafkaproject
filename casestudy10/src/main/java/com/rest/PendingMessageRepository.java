package com.rest;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PendingMessageRepository extends JpaRepository<PendingMessage, Long> {
    List<PendingMessage> findByClientId(String clientId);
}
