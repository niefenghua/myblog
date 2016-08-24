package com.z.model;

public class Buser {
    private Integer uid;
    private String name;
    private String password;
    private String nickname;
    private String securityquestion;
    private String securityanswer;

    public Buser(){

    }
    public Buser(String name,String password){
        this.name = name;
        this.password = password;

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSecurityquestion() {
        return securityquestion;
    }

    public void setSecurityquestion(String securityquestion) {
        this.securityquestion = securityquestion;
    }

    public String getSecurityanswer() {
        return securityanswer;
    }

    public void setSecurityanswer(String securityanswer) {
        this.securityanswer = securityanswer;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buser buser = (Buser) o;

        if (uid != buser.uid) return false;
        if (name != null ? !name.equals(buser.name) : buser.name != null) return false;
        if (password != null ? !password.equals(buser.password) : buser.password != null) return false;
        if (nickname != null ? !nickname.equals(buser.nickname) : buser.nickname != null) return false;
        if (securityquestion != null ? !securityquestion.equals(buser.securityquestion) : buser.securityquestion != null)
            return false;
        if (securityanswer != null ? !securityanswer.equals(buser.securityanswer) : buser.securityanswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (securityquestion != null ? securityquestion.hashCode() : 0);
        result = 31 * result + (securityanswer != null ? securityanswer.hashCode() : 0);
        return result;
    }
}
