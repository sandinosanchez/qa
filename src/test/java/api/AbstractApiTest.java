package api;

public abstract  class AbstractApiTest {

    private String url;

    public AbstractApiTest(){
        url = "https://www.potterapi.com/v1/";
    }

    public String getUrl() {
        return url;
    }



}
