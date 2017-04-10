package com.revature.caliber.salesforce;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Project: caliber
 *
 * @author d4k1d23
 * @date 1/25/17
 */
@Component
public abstract class Helper {
    private BufferedReader bufferedReader;
    private StringBuilder stringBuilder;

    public String toJsonString (InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        stringBuilder = new StringBuilder();
        String inputString;

        try {
            while ((inputString = bufferedReader.readLine()) != null)
                stringBuilder.append(inputString);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        closeStream();
        return stringBuilder.toString();
    }

    public void closeStream(){
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
