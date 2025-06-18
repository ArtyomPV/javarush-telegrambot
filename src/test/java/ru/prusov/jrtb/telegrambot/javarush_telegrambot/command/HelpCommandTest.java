package ru.prusov.jrtb.telegrambot.javarush_telegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.CommandName.HELP;
import static ru.prusov.jrtb.telegrambot.javarush_telegrambot.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit-level test for HelpCommand")
class HelpCommandTest extends AbstractCommandTest{


    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}