package ru.voitel.telegram.db.service;

public interface SendingService {
    void saveSpending(Long chatId, String category, Double rate);
}
