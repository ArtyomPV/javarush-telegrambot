package ru.prusov.jrtb.telegrambot.javarush_telegrambot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot.JavaRushTelegramBot;
@Slf4j
public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final JavaRushTelegramBot javarushBot;
    @Autowired
    public SendBotMessageServiceImpl(JavaRushTelegramBot javarushBot) {
        this.javarushBot = javarushBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
