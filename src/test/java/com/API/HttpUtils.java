package com.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Basic Class to process HTTP Request
 */
public class HttpUtils
{
    public static class HttpResponse
    {
        private final int mResponseCode;
        private final String mContent;
        private final String mErrorContent;
        private final Map<String, List<String>> mResponseHeaders;

        private HttpResponse( int responseCode,
                              String content,
                              String errorContent,
                              Map<String, List<String>> responseHeaders )
        {
            mResponseCode = responseCode;
            mContent = content;
            mErrorContent = errorContent;
            mResponseHeaders= responseHeaders;
        }

        public int getResponseCode()
        {
            return mResponseCode;
        }

        public String getContent()
        {
            return mContent;
        }

        public String getErrorContent()
        {
            return mErrorContent;
        }

        public Map<String, List<String>> getResponseHeaders()
        {
            return mResponseHeaders;
        }
    }

    public static HttpResponse getHttpContent( String urlString ) throws IOException
    {
        final URL url = new URL( urlString );
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        final int responseCode = connection.getResponseCode();
        final String content;
        if ( responseCode == HttpURLConnection.HTTP_OK )
            content = readAllLinesFromStream( connection.getInputStream() );
        else
            content = "";

        final InputStream errorStream = connection.getErrorStream();
        final String errorContent;
        if ( errorStream != null )
            errorContent = readAllLinesFromStream( errorStream );
        else
            errorContent = "";

        return new HttpResponse( responseCode, content, errorContent, connection.getHeaderFields() );
    }

    public static String readAllLinesFromStream( InputStream input )
    {
        BufferedReader output = new BufferedReader( new InputStreamReader( input ) );
        return output.lines().collect( Collectors.joining( System.lineSeparator() ) );
    }
}

