package bt.edu.rub.toco_18;

public class Sports {
    private String title;
    private String info;
    private final int imageResources;

    Sports(String title,String info, int imageResources){
        this.title = title;
        this.info = info;
        this.imageResources = imageResources;

    }
    String getTitle(){
        return title;
    }
    String getInfo(){
        return info;
    }
    public int getImageResources(){
        return imageResources;
    }
}
