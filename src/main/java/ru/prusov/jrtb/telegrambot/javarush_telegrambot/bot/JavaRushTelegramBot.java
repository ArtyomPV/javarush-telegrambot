package ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot.config.TelegramProperties;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    private final TelegramProperties telegramProperties;

    public JavaRushTelegramBot(TelegramProperties telegramProperties) {
        this.telegramProperties = telegramProperties;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            String chatId = update.getMessage().getChatId().toString();
            Message message = update.getMessage();
            SendMessage sendMessage = new SendMessage(chatId, message.getText());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String getBotUsername() {
        return telegramProperties.getUsername();
    }

    @Override
    public String getBotToken() {
        return telegramProperties.getToken();
    }
}
