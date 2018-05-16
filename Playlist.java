
/**
 * The Playlist Class is built to allow us hold information for each 
   instance of a playlist. Also contains getter & setter methods to alter 
   the state of each instance.
 * @author Shane Conway & Nathan Flanagan
 * @ID 17170451 & 0409715
 * @Date 29/11/2017
 */

import java.util.Arrays;
public class Playlist{
    private Track[] playlistTracks;
    private String playlistName;
    private int utilisation=0; 
    
    //Playlist Constructers
    //1 - Empty playlist created and no name given to it.
    public Playlist(){
       playlistTracks = new Track[100];
       playlistName = "Unknown";
    }
    
    //2 - Empty playlist created and a name is given to it.
    public Playlist(String name){
       playlistTracks = new Track[100];
       playlistName = name;
    }
    
    //3 - A playlist created with a name and tracks given to it.
    public Playlist(String name, Track[] tracks){
       playlistTracks = new Track[100];
       playlistName = name;
       
       if(tracks.length<=100){
           utilisation = tracks.length;
           for(int i=0;i<tracks.length;i++){
               playlistTracks[i] = tracks[i];
           }
       }else{
           System.out.println("Playlist created but no tracks added as playlist limit is 100 tracks\n");
       }
    }
    
    //toSting function
    public void playlistToString(){
       int space = 100 - utilisation;
       System.out.printf("Playlist Name:%s - Number of Tracks:%d - Availible Space:%d\n\n",playlistName,utilisation,space);
    }
    
    //Add functions
     public boolean add(Track name){
       if(utilisation<100){
           playlistTracks[utilisation] = name;
           utilisation++;
           System.out.printf("Track: '%s' added!\n\n",name.getTrackName());
           return true;
        }else{
           System.out.println("Track could not be added as playlist capacity reached.\n");
           return false;
        }
    }
    
    public boolean add(String name,String artist,int released,int duration){
       if(utilisation<100){
           Track newTrack = new Track(name,artist,released,duration);
           playlistTracks[utilisation] = newTrack;
           utilisation++;
           System.out.printf("Track: '%s' added!\n\n",name);
           return true;
        }else{
           System.out.println("Track could not be added as playlist capacity reached.\n");
           return false;
        }
    }
    
    //Remove function
     public boolean remove(int trackPos){
       int arrayPos = trackPos-1;
       if(utilisation!=0){
           if(trackPos>=0 && trackPos<=utilisation){
               Track[] copyPlaylist = Arrays.copyOf(playlistTracks,utilisation);
               Track removeTrack = playlistTracks[arrayPos];
               for(int i=arrayPos;i<utilisation;i++){
                   playlistTracks[i]=playlistTracks[i+1];
               }
               utilisation--;
               removeTrack = copyPlaylist[arrayPos];
               System.out.printf("Track: '%s' removed!\n\n",removeTrack.getTrackName());
               return true;
           }else{
               System.out.println("This track does not exist and cannot be removed.\n");
               return false;
           }
       }else{
            System.out.println("The playlist is empty.\n");
            return false;
       }
    }
    
    //ShowList function
    public boolean showList(){
        if(utilisation!=0){
           System.out.println("Playlist tracks are as follows:");
           for(int i=0;i<utilisation;i++){
              System.out.printf("Track %d: %s\n",i+1, playlistTracks[i].getTrackName());
           }
           System.out.println();
           return true;
       }else{
            System.out.println("The playlist is empty.\n");
            return false;
       } 
    }
    
    //PlayAll function
    public void playAll(boolean random){
        if(utilisation!=0){
            if(random==true){
                System.out.println("Playing Playlist songs in shuffled order:");
                Track[] shuffledTracks = new Track[utilisation];
                Track[] dummyTracks = Arrays.copyOf(playlistTracks,utilisation+1);
                
                for(int i=0;i<utilisation;i++){
                   int songsLeft = utilisation-i;
                   int shuffledNum = (int) (Math.random()*(songsLeft)); //shuffledNum will be an array position
                   shuffledTracks[i]=dummyTracks[shuffledNum];
                    
                   for(int j=shuffledNum;j<songsLeft;j++){
                          dummyTracks[j] = dummyTracks[j+1];
                   }
                }
                
                for(int i=0;i<utilisation;i++){
                    System.out.println("Currently Playing: ("+(i+1)+"/"+utilisation+") "+shuffledTracks[i].trackToStringReturn()); 
                }
                System.out.println();
            }else{
                System.out.println("Playing Playlist songs in order:");
                for(int i=0;i<utilisation;i++){
                    System.out.println("Currently Playing: ("+(i+1)+"/"+utilisation+") "+playlistTracks[i].trackToStringReturn()); 
                }
                System.out.println();
            }
        }else{
            System.out.println("The playlist is empty.\n");
        } 
    }
    
    //Artist playIf function
    public void playIf(String artist){
        Track[] artistTracks = new Track[0];
        int numArtistTracks = 0;
        
        for(int i=0;i<utilisation;i++){
            String trackArtist = playlistTracks[i].getTrackArtist();
            trackArtist = trackArtist.toLowerCase();
            String artistLower = artist.toLowerCase();
            boolean features = trackArtist.contains(artistLower);
            if(features==true){
                numArtistTracks++;
                artistTracks = Arrays.copyOf(artistTracks,numArtistTracks);
                artistTracks[numArtistTracks-1]=playlistTracks[i];
            }
        }
            
        if(numArtistTracks != 0){
            System.out.println("Tracks from "+artist+":");
            for(int i=0;i<numArtistTracks;i++){
                System.out.println("("+(i+1)+"/"+numArtistTracks+") "+artistTracks[i].trackToStringReturn());
            }
            System.out.println();
        }else{
            System.out.println("The artist "+artist+" is not in the playlist.\n");
        }
    }
    
    //Year playIf function
    public void playIf(int year){
        Track[] yearTracks = new Track[0];
        int numYearTracks = 0;
        
        for(int i=0;i<utilisation;i++){
            int trackYear = playlistTracks[i].getTrackYear();
            if(trackYear == year){
                numYearTracks++;
                yearTracks = Arrays.copyOf(yearTracks,numYearTracks);
                yearTracks[numYearTracks-1]=playlistTracks[i];
            }
        }
        
        if(numYearTracks != 0){
            System.out.println("Tracks from the year "+year+":");
            for(int i=0;i<numYearTracks;i++){
                System.out.println("("+(i+1)+"/"+numYearTracks+") "+yearTracks[i].trackToStringReturn());
            }
            System.out.println();
        }else{
            System.out.println("Tracks from the year "+year+" are not in the playlist.\n");
        }
    } 
}
