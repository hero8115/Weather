package org.example;

import com.darkprograms.speech.translator.GoogleTranslate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends TelegramLongPollingBot {
    Gson gson = new Gson();
    URL url;

    {
        try {

            url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    URLConnection urlConnection;

    {
        try {
            urlConnection = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BufferedReader bufferedReader;

    {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<Currency> currencyArrayList = gson.fromJson(bufferedReader, new TypeToken<List<Currency>>(){}.getType());

    private Integer havo =0;
    private Integer one =0;
    private Integer two =0;
    private Integer three =0;
    private Integer four =0;
    private Integer five =0;
    private Integer six =0;
    private Integer tarjima = 0;
    private Integer tarjima1 = 0;
    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        try {
            api.registerBot(new Main());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            Message message = update.getMessage();
            if(message.hasText()){
                String text = message.getText();
                SendMessage sendMessage = new SendMessage();
                if(text.equals("/start")){
                    sendMessage.setText("Assalomu Alaykum\nXush kelibsiz!!!\uD83D\uDE01");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
//                    replyKeyboardMarkup.setSelective(true);
                    List<KeyboardRow>keyboardRowList1 = new ArrayList<>();
                    List<KeyboardRow>keyboardRowList2 = new ArrayList<>();
                    KeyboardButton keyboardButton1 =new KeyboardButton();
                    KeyboardButton keyboardButton2 =new KeyboardButton();
                    KeyboardButton keyboardButton3 =new KeyboardButton();
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardRow keyboardRow2 = new KeyboardRow();
                    KeyboardRow keyboardRow3 = new KeyboardRow();
                    keyboardButton1.setText("Ob-havo malumotlari");
                    keyboardButton2.setText("Valyuta Ayirboshlash");
//                    keyboardButton3.setText("Tarjimon");
                    keyboardRow1.add(keyboardButton1);
                    keyboardRow2.add(keyboardButton2);
//                    keyboardRow3.add(keyboardButton3);
                    keyboardRowList1.add(keyboardRow1);
                    keyboardRowList1.add(keyboardRow2);
//                    keyboardRowList1.add(keyboardRow3);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList1);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("Ob-havo malumotlari")) {
                    havo = 1;
                    sendMessage.setText("Joyni tanlang");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("Valyuta Ayirboshlash")) {
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("Valyutani tanlang");
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
//                    replyKeyboardMarkup.setSelective(true);
                    List<KeyboardRow>keyboardRowList1 = new ArrayList<>();
                    List<KeyboardRow>keyboardRowList2 = new ArrayList<>();
                    KeyboardButton keyboardButton1 =new KeyboardButton();
                    KeyboardButton keyboardButton2 =new KeyboardButton();
                    KeyboardButton keyboardButton3 =new KeyboardButton();
                    KeyboardButton keyboardButton4 =new KeyboardButton();
                    KeyboardButton keyboardButton5 =new KeyboardButton();
                    KeyboardButton keyboardButton6 =new KeyboardButton();
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardRow keyboardRow2 = new KeyboardRow();
                    KeyboardRow keyboardRow3 = new KeyboardRow();
                    keyboardButton1.setText("1.SUM --> USD");
                    keyboardButton2.setText("2.USD --> SUM");
                    keyboardButton3.setText("3.SUM --> RUB");
                    keyboardButton4.setText("4.RUB --> SUM");
                    keyboardButton5.setText("5.USD --> RUB");
                    keyboardButton6.setText("6.RUB --> USD");
                    keyboardRow1.add(keyboardButton1);
                    keyboardRow1.add(keyboardButton2);
                    keyboardRow2.add(keyboardButton3);
                    keyboardRow2.add(keyboardButton4);
                    keyboardRow3.add(keyboardButton5);
                    keyboardRow3.add(keyboardButton6);
                    keyboardRowList1.add(keyboardRow1);
                    keyboardRowList1.add(keyboardRow2);
                    keyboardRowList1.add(keyboardRow3);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList1);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(text.equals("1.SUM --> USD")){
                    sendMessage.setText("Summani kiriting : ");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    one = 1;
                } else if (one == 1) {
                    Double one = Double.valueOf(text)/Double.valueOf(currencyArrayList.get(0).getRate());
                    String  onesum = text + " so'm " + one + " dollar";
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(onesum+"\n\n"+"Hohlasangiz boshqa summa kiriting\n\nBoshqa valyutaga otish uchun /start ni bosing");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("2.USD --> SUM")) {
                    sendMessage.setText("Summani kiriting : ");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    two = 2;
                } else if (two ==2 ) {
                    Double two = Double.valueOf(text)*Double.valueOf(currencyArrayList.get(0).getRate());
                    String  twosum = text + " dollar " + two + " so'm";
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(twosum+"\n\n"+"Hohlasangiz boshqa summa kiriting\n\nBoshqa valyutaga otish uchun /start ni bosing");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("3.SUM --> RUB")) {
                    sendMessage.setText("Summani kiriting : ");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    three = 3;
                } else if (three ==3) {
                    Double three = Double.valueOf(text)/Double.valueOf(currencyArrayList.get(2).getRate());
                    String  threesum = text + " so'm " + three + " rubl";
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(threesum+"\n\n"+"Hohlasangiz boshqa summa kiriting\n\nBoshqa valyutaga otish uchun /start ni bosing");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("4.RUB --> SUM")) {
                    sendMessage.setText("Summani kiriting : ");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    four = 4;
                } else if (four ==4) {
                    sendMessage.setChatId(message.getChatId());
                    Double four = Double.valueOf(text)*Double.valueOf(currencyArrayList.get(2).getRate());
                    String  foursum = text + " rubl " + four + " so'm";
                    sendMessage.setText(foursum+"\n\n"+"Hohlasangiz boshqa summa kiriting\n\nBoshqa valyutaga otish uchun /start ni bosing");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("5.USD --> RUB")) {
                    sendMessage.setText("Summani kiriting : ");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    five = 5;
                } else if (five ==5) {
                    Double five = Double.valueOf(text)*Double.valueOf(currencyArrayList.get(0).getRate())/Double.valueOf(currencyArrayList.get(2).getRate());
                    String  fivesum = text + " dollar " + five + " rubl";
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(fivesum+"\n\n"+"Hohlasangiz boshqa summa kiriting\n\nBoshqa valyutaga otish uchun /start ni bosing");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("6.RUB --> USD")) {
                    sendMessage.setText("Summani kiriting : ");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    six = 6;
                } else if (six ==6) {
                    Double six = Double.valueOf(text)*Double.valueOf(currencyArrayList.get(2).getRate())/Double.valueOf(currencyArrayList.get(0).getRate());
                    String  sixsum = text + " rubl " + six + " dollar";
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(sixsum+"\n\n"+"Hohlasangiz boshqa summa kiriting\n\nBoshqa valyutaga otish uchun /start ni bosing");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else  if(havo ==1){
                    try {
                        Gson gson = new Gson();
                        URL url = new URL("https://goweather.herokuapp.com/weather/"+text);
                        URLConnection urlConnection = url.openConnection();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        Weather weather = new Weather();
                        weather = gson.fromJson(bufferedReader, new TypeToken<Weather>(){}.getType());
                        String l = "Bugungi Ob-havo malumotlari --> \n";
                        l+="\nTemperatura : "+weather.getTemperature();
                        l+="\nShamol tezligi : "+weather.getWind();
                        l+="\nHolat : "+weather.getDescription();
                        sendMessage.setChatId(message.getChatId());
                        sendMessage.setText(l);
                        sendMessage.setParseMode(ParseMode.MARKDOWN);
                        execute(sendMessage);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                }
            } else if (text.equals("Tarjimon")) {
                    sendMessage.setText("Kiritilayotgan so'zni tilini tanlang");
                    sendMessage.setChatId(message.getChatId());
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow>keyboardRowList1 = new ArrayList<>();
                    List<KeyboardRow>keyboardRowList2 = new ArrayList<>();
                    KeyboardButton keyboardButton1 =new KeyboardButton();
                    KeyboardButton keyboardButton2 =new KeyboardButton();
                    KeyboardButton keyboardButton3 =new KeyboardButton();
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardRow keyboardRow2 = new KeyboardRow();
                    KeyboardRow keyboardRow3 = new KeyboardRow();
                    keyboardButton1.setText("Uzbek");
                    keyboardButton2.setText("Ingliz");
                    keyboardButton3.setText("Rus");
                    keyboardRow1.add(keyboardButton1);
                    keyboardRow2.add(keyboardButton2);
                    keyboardRow3.add(keyboardButton3);
                    keyboardRowList1.add(keyboardRow1);
                    keyboardRowList1.add(keyboardRow2);
                    keyboardRowList1.add(keyboardRow3);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList1);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    tarjima =1;                    
                } else if (tarjima ==1) {
                    sendMessage.setText("Tarjima qilinishi kerak bo'lgan tilni tanlang");
                    sendMessage.setChatId(message.getChatId());
                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow>keyboardRowList1 = new ArrayList<>();
                    List<KeyboardRow>keyboardRowList2 = new ArrayList<>();
                    KeyboardButton keyboardButton1 =new KeyboardButton();
                    KeyboardButton keyboardButton2 =new KeyboardButton();
                    KeyboardButton keyboardButton3 =new KeyboardButton();
                    KeyboardRow keyboardRow1 = new KeyboardRow();
                    KeyboardRow keyboardRow2 = new KeyboardRow();
                    KeyboardRow keyboardRow3 = new KeyboardRow();
                    keyboardButton1.setText("Uzbek");
                    keyboardButton2.setText("Ingliz");
                    keyboardButton3.setText("Rus");
                    keyboardRow1.add(keyboardButton1);
                    keyboardRow2.add(keyboardButton2);
                    keyboardRow3.add(keyboardButton3);
                    keyboardRowList1.add(keyboardRow1);
                    keyboardRowList1.add(keyboardRow2);
                    keyboardRowList1.add(keyboardRow3);
                    replyKeyboardMarkup.setKeyboard(keyboardRowList1);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    tarjima1 = 1;
                } else if (tarjima1 ==1) {
                    sendMessage.setText("So'zni kiriting");
                    sendMessage.setChatId(message.getChatId());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    }
}
    @Override
    public String getBotUsername() {
        return "t.me/new8115_bot";
    }

    @Override
    public String getBotToken() {
        return "5930924021:AAFG2Mea6mhSD5OxVpslSdpjYhPZDUgWtE8";
    }
}