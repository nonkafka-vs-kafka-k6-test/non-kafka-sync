package com.example.nonkafkasync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    /**
     * 사장님에게 "새 주문 도착" 알림 전송
     * 실제 푸시 발송 서버(FCM 등) 연동 대신, 지연 시간만 흉내
     */
    public void sendOrderNotification(String orderId) {
        try {
            Thread.sleep(1000); // 알림 발송에 걸리는 시간 시뮬레이션 (1초)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("🔔 사장님 알림 발송 완료 - orderId: {}", orderId);
    }
}
