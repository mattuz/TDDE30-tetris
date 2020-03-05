package se.liu.ida.matge373.tddd78.tetris;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HighscoreList
{

    private List<Highscore> highscores = new ArrayList<>();
    private List<Highscore> lcs = null;
    private         Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();




    public HighscoreList() { //TODO Tom konstruktor.. Gör den ens något?
    }

    public void saveScores() throws IOException, FileNotFoundException
    {

        String jsonHighscore = gson.toJson(highscores);

        try (Writer fileWriter = new FileWriter("Highscores", true)) {
            fileWriter.write(jsonHighscore);
            fileWriter.close(); //TODO SKRIV ÖVER ISTÄLLET
        }


        try (Reader reader = new FileReader("Highscores")) {
            Gson gson1 = new Gson();
            Type collectionType = new TypeToken<List<Highscore>>() {}.getType();
            List<Highscore> lcs = gson.fromJson(reader, collectionType);

        //HighscoreList list = gson.fromJson(reader, HighscoreList.class);
    }
            //Type collectionType = new TypeToken<List<Highscore>>() {}.getType();
            //List<Highscore> lcs = gson.fromJson(jsonHighscore, collectionType);
        //Type collectionType = new TypeToken<Map<String, Highscore>>() {}.getType();
        //Map<String, Highscore> lcs = gson.fromJson(jsonHighscore, collectionType);
            System.out.println(lcs.size());

}



    public void addHighscore(Highscore highscore) throws IOException, FileNotFoundException {
        highscores.add(highscore);
        saveScores();
    }

    public List<Highscore> getLcs() {
        return lcs;
    }

    public List<Highscore> getHighscores() {
        return highscores;
    }

}
