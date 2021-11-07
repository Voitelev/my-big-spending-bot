package ru.voitel.telegram.db.service;

import org.springframework.stereotype.Component;

@Component
public class SendingServiceImpl implements SendingService {
    @Override
    public void saveSpending(Long chatId, String category, Double rate) {
        System.out.println("Записываем расходы");
    }
}
