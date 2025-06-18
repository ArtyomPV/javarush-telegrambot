package ru.prusov.jrtb.telegrambot.javarush_telegrambot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot.JavaRushTelegramBot;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private JavaRushTelegramBot javaRushTelegramBot;

    @BeforeEach
    public void init(){
        javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaRushTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        // given
        String chatId = "test_chatId";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

       //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(javaRushTelegramBot).execute(sendMessage);
    }
}