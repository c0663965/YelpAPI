package YelpData;

public class Restaurant {
    
    private String NAME;
    private String MENU;
    private String PHONE;
    private String ADDRESS;
    private String POSTAL_CODE;
    private double LATITUDE;
    private double LONGITUDE;
    private String MOBILE_URL;
    private String RATING;
    private String RATING_IMAGE_URL;
    private String SNIPPET_TEXT;

    public Restaurant() {
        NAME="";
        MENU="";
        PHONE="";
        ADDRESS="";
        POSTAL_CODE="";
        LATITUDE=0.0;
        LONGITUDE=0.0;
        MOBILE_URL="";
        RATING="";
        RATING_IMAGE_URL="";
        SNIPPET_TEXT="";
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getMENU() {
        return MENU;
    }

    public void setMENU(String MENU) {
        this.MENU = MENU;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(String POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }

    public double getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(double LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public double getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(double LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getMOBILE_URL() {
        return MOBILE_URL;
    }

    public void setMOBILE_URL(String MOBILE_URL) {
        this.MOBILE_URL = MOBILE_URL;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = RATING;
    }

    public String getRATING_IMAGE_URL() {
        return RATING_IMAGE_URL;
    }

    public void setRATING_IMAGE_URL(String RATING_IMAGE_URL) {
        this.RATING_IMAGE_URL = RATING_IMAGE_URL;
    }

    public String getSNIPPET_TEXT() {
        return SNIPPET_TEXT;
    }

    public void setSNIPPET_TEXT(String SNIPPET_TEXT) {
        this.SNIPPET_TEXT = SNIPPET_TEXT;
    }
}