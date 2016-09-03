package com.android.saturday.restclient;


import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class LoggingInterceptor implements Interceptor {

    public static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;

        Request request = chain.request();

        StringBuilder httpLogger = new StringBuilder();

        // keep the nano time while sending the request
        long t1 = System.nanoTime();

        String requestLog = String.format("Sending Request %s", request.url());
        if (request.method().compareToIgnoreCase("post") == 0) {
            requestLog = "\n" + requestLog + "\n" + bodyToString(request);
        }

        //append the into the builder
        httpLogger.append("Request--->").append("\n").append(requestLog);


        // Request customization: add request headers
        Request.Builder requestBuilder = request.newBuilder()
                .header("Api-Key", "b9fvndswukvbndzchakwcyd9")
                .method(request.method(), request.body());

        response = chain.proceed(requestBuilder.build());

        // again keep the nano time when the response come back
        long t2 = System.nanoTime();

        //String responseLog = String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers());
        String responseLog = String.format("Received response for %s in %.1fms%n", response.request().url(), (t2 - t1) / 1e6d);

        if (response.code() < HttpURLConnection.HTTP_INTERNAL_ERROR) {
            String bodyString = response.body().string();

            //append the into the builder
            httpLogger.append("\n\n").append("Response<------").append("\n").append(responseLog).append("RawData :").append("\n").append(bodyString);

            //print the http request and response
            Logger.e(httpLogger.toString());

            // we need to rewrite the response body other wise the actual response will not extract by the
            // response handler in to the application
            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        } else {
            String bodyString = "{\n" + "  \"message\": \"Internal Server Error.\"\n" + "}";
            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }
    }
}
