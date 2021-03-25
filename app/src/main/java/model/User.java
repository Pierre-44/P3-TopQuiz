package model;

/**
 * Created by pmeignen on 23/03/2021.
 */
public class User {
    private String mFirstname;
    private String mFirstName;

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstName) {
        mFirstname = firstName;
    }

    @Override
    public String toString() {
        return "User{" + "mFirstname='" + mFirstname + '\'' +'}';
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFirstName() {
        return mFirstName;
    }
}


