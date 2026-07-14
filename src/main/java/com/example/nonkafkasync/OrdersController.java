package com.example.nonkafkasync;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    // 동기 처리: 주문 저장 + 사장님 알림 발송을 모두 마친 후 응답
    @PostMapping("/orders/sync")
    public String createOrderSync(@RequestBody OrdersRequestDto request) {
        Orders order = ordersService.createOrderSync(request);
        return "주문 생성 완료 - orderId: " + order.getId();
    }
}
