import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MainClass {
    public static void main(String[] args) throws JsonProcessingException, UnsupportedEncodingException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://matrix-api.awign.com/api/v2/projects/602cc3985accab3b961e3552/leads");
        post.addHeader("access-token","PLEASE_ADD_IT_REMOVED_FOR_SECURITY");
        post.addHeader("client","PLEASE_ADD_IT_REMOVED_FOR_SECURITY");
        post.addHeader("uid","PLEASE_ADD_IT_REMOVED_FOR_SECURITY");
        post.addHeader("X-CLIENT_ID","PLEASE_ADD_IT_REMOVED_FOR_SECURITY");
        post.addHeader("Content-Type","application/json");


        ModerationData data = ModerationData.builder()
                .name("ReportedVideoJob")
                .videoId("awz462EGMualqZ4RUZ")
                .videoUrl("https://cdnm.mitron.tv/upload/video/MyZmlJLNmtwdj93c709.mp4")
                .reasonType("Sexual content")
                .reasonSubType("")
                .reason("")
                .build();

        Lead lead = Lead.builder().moderationData(data).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(lead);
        System.out.println("Request is : " + requestJson);
        StringEntity userEntity = new StringEntity(requestJson);
        post.setEntity(userEntity);
        HttpResponse response = null;
        try {
            response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("Status Code is : " + statusCode);
            if (statusCode != 201)
            {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
