package art.evalevi.telegrambot.webhooktgbot.config;

import art.evalevi.telegrambot.webhooktgbot.bot.MyTelegramBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Getter
@Setter
@Configuration
public class BotConfig {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.path}")
    private String botPath;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(getBotPath()).build();
    }

    @Bean
    public MyTelegramBot myTelegramWebhookBot(SetWebhook setWebhookInstance) {
        MyTelegramBot bot = new MyTelegramBot(setWebhookInstance);
        bot.setBotToken(getBotToken());
        bot.setBotUsername(getBotUsername());
        bot.setBotPath(getBotPath());

        return bot;
    }
}
