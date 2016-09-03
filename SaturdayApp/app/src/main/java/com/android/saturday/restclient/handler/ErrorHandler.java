package com.android.saturday.restclient.handler;


import android.text.TextUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.nio.charset.Charset;
import retrofit.Response;

public class ErrorHandler {

    public static ErrorResponse buildError(String errorJson) {
        String errorJsonObject = errorJson;
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(errorJsonObject, ErrorResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ErrorResponse buildError(Response response) {
        try {
            //extract the error message from the error body
            String errorMessage = new String(response.errorBody().bytes(), Charset.defaultCharset());
            // verify it should not null or empty
            if (!TextUtils.isEmpty(errorMessage)) {
                Logger.d(String.format("Message :%s", errorMessage));

                // Mapping the response json with POJO
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(errorMessage, ErrorResponse.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
