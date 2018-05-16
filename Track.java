
/**
 * The Track Class is built to allow us hold information for each 
   instance of a track.Also contains getter & setter methods to alter 
   the state of each instance.
 * @author Shane Conway & Nathan Flanagan
 * @ID 17170451 & 0409715
 * @Date 29/11/2017
 */
public class Track{
    //Initial Setup of variables and functions needed
    private String trackName;
    private String artistName;
    private int releaseDate;
    private String trackDuration;
    
    public String convertDuration(int duration){
        int min = duration/60;
        int secDouble = (duration%60)/10;
        int secSingle = (duration%60)%10;
        return ""+min+":"+secDouble+secSingle;
    }
    
    //Constructer - only 1 --- for example track without duration is not possible
    public Track(String name,String artist,int released,int duration){
        trackName=name;
        artistName=artist;
        releaseDate=released;
        trackDuration=convertDuration(duration);
    }
    
    //toSting function
    public void trackToString(){
        System.out.printf("Track Name: %s - Artist Name: %s - Realeased: %d - Track Duration: %s\n",trackName,artistName,releaseDate,trackDuration);
    }
    
    public String trackToStringReturn(){
        return "Track Name: "+trackName+" - Artist Name: "+artistName+" - Realeased: "+releaseDate+" - Track Duration: "+trackDuration;
    }
    
    //Setter functions
    public void setTrackName(String name){
        trackName=name;
    }

    public void setTrackArtist(String artist){
        artistName=artist;
    }
    
    public void setTrackYear(int released){
        releaseDate=released;
    }
    
    public void setTrackDuration(int duration){
        trackDuration=convertDuration(duration);
    }
    
    //Getter functions
    public String getTrackName(){
        return trackName;
    }
    
     public String getTrackArtist(){
        return artistName;
    }
    
     public int getTrackYear(){
        return releaseDate;
    }
    
     public String getTrackDuration(){
        return trackDuration;
    } 
}
