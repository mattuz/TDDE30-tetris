package se.liu.ida.matge373.tddd78.tetris;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HighscoreList
{

    private List<Highscore> highscores = new ArrayList<>();





    public HighscoreList() {

    }

    public List<Highscore> fileReader() throws FileNotFoundException {
        File newfile = new File(System.getProperty("user.home"));
        JsonReader reader = new JsonReader(new FileReader(newfile));
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Highscore>>()
        {
        }.getType();
        List<Highscore> oldHighscores = gson.fromJson(reader, collectionType);
        return oldHighscores;
    }

    public void iterHighscores() throws IOException, FileNotFoundException {
        if (fileReader() != null) {
            for (Highscore highscore : fileReader()) {
                System.out.println(highscore.getScore());
                addHighscore(highscore);
            }
        }
    }

    public void saveScores() throws IOException, FileNotFoundException
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().setLenient().create();
        String jsonHighscore = gson.toJson(highscores) ;

        try (PrintWriter hiscorefile = new PrintWriter("Highscores")) {
            hiscorefile.write(jsonHighscore);
            hiscorefile.close();
        }
}



    public void addHighscore(Highscore highscore) throws IOException, FileNotFoundException {
        highscores.add(highscore);
        //saveScores();
    }

    public List<Highscore> getHighscores() {
        return highscores;
    }

}
