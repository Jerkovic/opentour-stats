package models;

public class Player {

    private String country;
    private String firstname;
    private String lastname;
    private String gender;
    private String id;
    private String metaId;
    private String name;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetaId() {
        return metaId;
    }

    public void setMetaId(String metaId) {
        this.metaId = metaId;
    }

    public String getName() {
        return name.replace("(46+)", "").replace("(OT)", "").trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "country='" + country + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", metaId='" + metaId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public String toFormatted() {
        return
                firstname + ' ' +
                lastname.toUpperCase();

    }
}
