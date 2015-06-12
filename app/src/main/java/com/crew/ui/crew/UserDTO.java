package com.crew.ui.crew;

/**
 * Created by hyeon-seob on 15. 6. 12..
 */
public class UserDTO {
    private static int userId = 0;
    private static String facebookId = null;
    private static String name = null;
    private static String email = null;

    public void setUserId(int _userId) { userId = _userId; }
    public void setFacebookId(String _facebookId) { facebookId = _facebookId; }
    public void setName(String _name) { name = _name; }
    public void setEmail(String _email) { email = _email; }
    public int getUserId() { return userId; }
    public String getfacebookId() { return facebookId; }
    public String getName() { return name; }
    public String getEmail() { return email; }

}
