package ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.bot.JavaRushTelegramBot;

@Component
@RequiredArgsConstructor
public class BotInitializer {
    private final JavaRushTelegramBot bot;

    @EventListener({ContextRefreshedEvent.class})
    private void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try{
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}