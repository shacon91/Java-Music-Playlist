
/**
 * The Driver Class.
 * @author Shane Conway & Nathan Flanagan
 * @ID 17170451 & 0409715
 * @Date 29/11/2017
 */
public class Driver{
    public static void main(String[] args){
        //Track Test
        /*Track aTrack;
        aTrack = new Track("Slow Hands","Niall Horan",2017,188);
        aTrack.trackToString();
        aTrack.setTrackName("Fast Hands");
        aTrack.setTrackArtist("Java");
        aTrack.setTrackYear(1991);
        aTrack.setTrackDuration(200);
        aTrack.trackToString();*/
        
        //Playlist initial information
        Track aTrack = new Track("Slow Hands","Niall Horan",2017,188);
        Track[] tracks = {aTrack,new Track("Touch","Little Mix",2017,191)};
        
        //Playlist Constructer test
        Playlist bestOf2015 = new Playlist();
        Playlist bestOf2016 = new Playlist("bestOf2016");
        Playlist bestOf2017 = new Playlist("bestOf2017",tracks);
        //bestOf2015.playlistToString();
        //bestOf2016.playlistToString();
        //bestOf2017.playlistToString();
        
        //Testing add function
        bestOf2017.add(aTrack);
        bestOf2017.add(new Track("Back To You 5","Louis Tomlinson feat. Bebe Rexha & Digital Farm Animals",2017,183));
        bestOf2017.add("Back To You 1","Louis Tomlinson feat. Bebe Rexha & Digital Farm Animals",2017,183);
        bestOf2017.add("Back To You 2","Louis Tomlinson feat. Bebe Rexha & Digital Farm Animals",2018,183);
        bestOf2017.add(new Track("Touch","Little Mix",2017,191));
        bestOf2017.add(new Track("Shape Of You","Ed Sheeran",2017,202));
        bestOf2017.add(new Track("The Cure","Lady Gaga",2017,195));
        bestOf2017.add(new Track("Power","Little Mix feat. Stormzy",2017,185));
        bestOf2017.add(new Track("Dusk Till Dawn","ZAYN feat. Sia",2017,201));
        bestOf2017.add(new Track("There's Nothing Holdin' Me Back","Shawn Mendes",2017,207));
        bestOf2017.add("Back To You 3","Louis Tomlinson feat. Bebe Rexha & Digital Farm Animals",2017,183);
        bestOf2017.add(new Track("Back To You 4","Louis Tomlinson feat. Bebe Rexha & Digital Farm Animals",2017,183));
        bestOf2017.add("Sign Of The Times","Harry Styles",2017,175);
        bestOf2017.playlistToString();
        
        //Testing remove function
        bestOf2017.remove(1);
        bestOf2017.remove(3);
        bestOf2017.remove(10);
        bestOf2017.playlistToString();
        
        //Testing showList function
        bestOf2017.showList();
        
        //Testing playIf functions
        bestOf2017.playIf("LITTLE MIX"); //in playlist
        bestOf2017.playIf("LITTLE FIX"); //not in playlist
        bestOf2017.playIf("Niall Horan"); //in playlist
        bestOf2017.playIf("Sia"); //in playlist but as a featured artist
        bestOf2017.playIf(2017); //in playlist
        bestOf2017.playIf(2020); //not in playlist
        
        //Testing playAll function
        bestOf2017.playAll(false);
        bestOf2017.playAll(true);
        bestOf2017.playAll(true);
        bestOf2017.playAll(true);
        
        ////Testing with extra Playlist
        Playlist musicWithAMessage = new Playlist();
        musicWithAMessage.add(new Track("Desperado","The Eagles",1973,255));
        musicWithAMessage.add("Leningrad","Billy Joel",1989,213);
        musicWithAMessage.add(new Track("The Dance","Garth Brooks",1989,213));
        musicWithAMessage.add(new Track("The Living Years","Mike & The Mechanics",1988,213));
        musicWithAMessage.add(new Track("Imagine", "John Lennon",1987, 188));
        musicWithAMessage.add(new Track("The Times They are a Changin'","Bob Dylan",1964,179));
        musicWithAMessage.playIf("LITTLE MIX");  // Not an artist in the playlist
        musicWithAMessage.showList();
        musicWithAMessage.remove(27); // 27 doesn't exist
        musicWithAMessage.playAll(true);
        musicWithAMessage.playAll(false);
        musicWithAMessage.playIf(1989);
        
    }
}
