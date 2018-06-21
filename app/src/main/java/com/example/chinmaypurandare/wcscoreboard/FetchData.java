package com.example.chinmaypurandare.wcscoreboard;


import android.os.AsyncTask;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String dataFixtures = "";
    String dataParsed = "";
    String singleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://api.football-data.org/v1/competitions/467/fixtures?matchday=2");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String Line ="";
            while(Line != null){
                Line= bufferedReader.readLine();
                dataFixtures = dataFixtures + Line;
            }
            JSONArray MA = new JSONArray(dataFixtures);
            for (int i=0;i<MA.length();i++)
            {
                JSONObject MO = (JSONObject) MA.get(i);
                singleParsed =  MO.get("homeTeamName") + "vs" + MO.get("awayTeamName")+"\n" +
                                MO.get("status")+ "\n" +
                                MO.get("homeTeamName") + "  " + MO.get("goalsHomeTeam") +"\n" +
                                MO.get("homeTeamName") + "  " + MO.get("goalsHomeTeam") +"\n" ;
                dataParsed = dataParsed + singleParsed +"\n" ;
            }

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        //MainActivity.match.setText(this.dataParsed);
        // yet to be able to proper;y show json data
        MainActivity.match.setText(this.dataFixtures);
    }
}

