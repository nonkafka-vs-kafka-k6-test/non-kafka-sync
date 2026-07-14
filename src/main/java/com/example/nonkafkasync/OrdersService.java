package com.example.nonkafkasync;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final NotificationService notificationService;

    /**
     * 동기 처리 버전
     * 주문 저장 + 사장님 알림 발송까지 모두 마친 후 응답 반환
     */
    @Transactional
    public Orders createOrderSync(OrdersRequestDto request) {
        Orders order = Orders.builder()
                .id(UUID.randomUUID().toString())
                .userId(request.getUserId())
                .amount(request.getAmount())
                .createdAt(LocalDateTime.now())
                .status("CREATED")
                .notificationSent(false)
                .build();

        ordersRepository.save(order);

        // 알림 발송 동기 처리 (여기서 응답이 지연)
        notificationService.sendOrderNotification(order.getId());

        order.setNotificationSent(true);
        order.setNotificationSentAt(LocalDateTime.now());

        return order;
    }
}
