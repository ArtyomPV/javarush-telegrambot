package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.prusov.jrtb.telegrambot.javarush_telegrambot.service.SendBotMessageService;

import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.CommandName.*;

public class HelpCommand implements Command{
    private final SendBotMessageService service;
    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"

            + "<b>Начать\\закончить работу с ботом</b>\n"
            + "%s - начать работу со мной\n"
            + "%s - приостановить работу со мной\n\n"
            + "%s - получить помощь в работе со мной\n",
    START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService service) {
        this.service = service;
    }

    @Override
    public void execute(Update update) {
        service.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
