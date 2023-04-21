import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EchoBot extends TelegramLongPollingBot
{
    @Override
    public String getBotUsername()
    {
        return "OlzhasEchoBot";
    }

    @Override
    public String getBotToken()
    {
        return "5325500503:AAETX_3AAKSNKCPxP3OIGcfaQ335O0Z8pig";
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        System.out.println(update.getMessage().getText());

        if (update.hasMessage() && update.getMessage().hasText())
        {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());


            if(update.hasMessage() && update.getMessage().getText().equals("Hello World!")){
//                message.setChatId(update.getMessage().getChatId().toString());
                message.setText("Hi my guy!");
            }

            if(update.getMessage().getText().equals("/hello"))
            {
                message.setText("Hello " + update.getMessage().getFrom().getFirstName());
            }

            if(update.getMessage().getText().equals("/full_name"))
            {
                message.setText("You're full name is " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
            }

            try
            {
                execute(message);

            } catch (TelegramApiException e)
            {
                e.printStackTrace();
            }
        }
    }
}
