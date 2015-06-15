package util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dongjun on 15. 6. 15..
 */
public class Server {

    static public String SERVER_ADDRESS = "http://166.104.245.89/Crew/DB";
    static public String WITH_USER = "&user_id=";

    static public String USER_API = "/User/User.php?query=";
    static public String INSERT_FACEBOOK_ID = "insertUser&facebookId=";
    static public String SEARCH_WITH_FACEBOOK_ID = "searchUser&facebookId=";

    static public String MAIN_API = "/MAIN";
    static public String M_DOING = "/CallTodayDoing.php?user_id=";
    static public String M_NOTICE = "/CallCrewNotice.php?user_id=";

    static public String CREW_API = "/Crew";
    static public String CREW_MAIN = "/Crew_main.php?user_id=";

    static public String CREW_DETAIL = "/Crew_detail.php?query=";
    static public String C_DOING = "showDoing&groups_id=";
    static public String C_NOTICE = "callNotice&groups_id=";

    static public String MEMBER = "/show_member.php?query=";
    static public String M_SHOW = "showM&groups_id=";


    static public String getStringFromUrl(String url) {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet post = new HttpGet(url);
        HttpResponse response;
        StringBuilder total = new StringBuilder();
        try {
            response = httpclient.execute(post);
            HttpEntity ht = response.getEntity();
            BufferedHttpEntity buf = new BufferedHttpEntity(ht);
            InputStream is = buf.getContent();

            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total.toString();
    }

}
