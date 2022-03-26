package http.httptask1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpTask1 {
    
    public static ObjectMapper mapper = new ObjectMapper();
    
    public static CloseableHttpResponse getHttpResponse(String url) throws IOException {
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(30000)
                .setRedirectsEnabled(false)
                .build())
                .build()
                .execute(new HttpGet(url));
    }
    
    public static void main(String[] args) throws IOException {
        String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        mapper.readValue(
                getHttpResponse(url).getEntity().getContent(), 
                new TypeReference<List<Fact>>() {})
                .stream()
                .filter(f -> f.getUpVotes() != null)
                .filter(f -> f.getUpVotes() > 0)
                .forEach(System.out::println);
    }
}
