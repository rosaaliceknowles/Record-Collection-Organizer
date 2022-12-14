public class Record{

  String album;
  String artist;
  String genre;
  String year;
  
  public Record(String album, String artist, String genre, String year){ //constructor with parameters

    this.album = album;
    this.artist = artist;
    this.genre = genre;
    this.year = year;
  }

  public Record(){ //constructor without parameters
    this.album = "null";
    this.artist = "null";
    this.genre = "null";
    this.year = "null";
  }

  public void display(){ //prints the record object
    System.out.println(artist + ", " + year + ", "+ album + ", "+ genre);
  }

  public String toString(){ //returns a string with the same stuff that the display function prints
    return (artist + ", " + year + ", " + album + ", " + genre);
  }

  public String toStringSansGenre(){ //returns a string without the genre, used when creating the genre lists in Main.java
    return (artist + ", " + year + ", " + album);
  }

  public void artist(String artist){ //changes the artist to the parameter
    this.artist = artist;
  }

  public void album(String album){ //changes the album to the parameter
    this.album = album;
  }

  public void genre(String genre){ //changes the genre to the parameter
    this.genre = genre;
  }

  public void year(String year){ //changes the year to the parameter. the year is a string 
    this.year = year;
  }

  public String genre(){ //returns the genre, used to check the genre in Main.java
    return this.genre;
  }

  public String year(){ //returns the year AS A STRING
    return this.year;
  }

  public String album(){ //returns the album
    return this.album;
  }

  public String artist(){ //returns the artist 
    return this.artist;
  }

  
}