package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.service.SendBotMessageService;

public class StopCommand implements Command{
    private final SendBotMessageService service;

    public static final String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService service) {
        this.service = service;
    }


    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
