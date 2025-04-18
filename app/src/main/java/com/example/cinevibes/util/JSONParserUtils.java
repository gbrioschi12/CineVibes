package com.example.cinevibes.util;

import android.app.ActivityOptions;
import android.content.Context;

import com.example.cinevibes.model.FilmApiResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class JSONParserUtils {
    public Context context;

    public JSONParserUtils(Context context) {
        this.context = context;
    }
    public FilmApiResponse parseJSONFileWithGSon(String filename) throws IOException {
        InputStream inputStream = context.getAssets().open(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

       return new Gson().fromJson(bufferedReader, FilmApiResponse.class);

    }
}
