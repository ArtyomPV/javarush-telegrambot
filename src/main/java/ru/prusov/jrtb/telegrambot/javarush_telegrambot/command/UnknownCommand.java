package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.service.SendBotMessageService;

public class UnknownCommand implements Command{
    private final SendBotMessageService service;

    public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    public UnknownCommand(SendBotMessageService service) {
        this.service = service;
    }

    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
