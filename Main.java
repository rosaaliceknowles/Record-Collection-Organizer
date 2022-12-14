import java.util.*;
import java.io.*;

class Main {


  
  public static ArrayList<Record> readFile(String fileName){ //function used to read a file and gather vinyl data from it
    String genre,year,album,artist,temp;
    artist = genre = year = album = temp = "";
    ArrayList<Record> tempList = new ArrayList<Record>();
    
    try{
      FileInputStream fis = new FileInputStream(fileName);
      Scanner reader = new Scanner(fis);

      while(reader.hasNextLine()){
        temp = reader.nextLine().toString();
        boolean tempFind = temp.contains("  ");
        boolean isEnd = temp.contains("END.");
        if (tempFind == false && isEnd == false){//assigns an artist
          int semiColon = temp.indexOf(";");
          int colon = temp.indexOf(":");
          artist = temp.substring(0,semiColon);
          genre = temp.substring(semiColon+1,colon);
        } else if (tempFind == true && isEnd == false){//creates a listing for the record in the list "records"
          int semiColon = temp.indexOf(";");
          album = temp.substring(2,semiColon);
          year = temp.substring(semiColon+1);
          tempList.add(new Record(album,artist,genre,year));
        }else{
          break;//should break if the line is "END."
        }
      }

      reader.close();
    }    
    catch(IOException e){
      e.printStackTrace();
      tempList.add(new Record());
    }
    return tempList;
  }

  public static String getDefine(int lineNum){
    String define = "";

    try {
      FileInputStream fis = new FileInputStream("defines.txt");
      Scanner reader = new Scanner(fis);

      int count = 0;
      while (reader.hasNextLine()){
        String temp = reader.nextLine().toString();
        
        if (count == lineNum){
          int quoteMark = temp.indexOf("\"");
          define = temp.substring(quoteMark+1,temp.length()-1);
        }
        count++;
      }
      
      reader.close();
    } catch (IOException e){
      e.printStackTrace();
    }

    return define;
  }




  
  
  public static void main(String[] args) {
    
    ArrayList<Record> records = new ArrayList<Record>(); //used to store all records (sans singles) owned
    ArrayList<Record> singles = new ArrayList<Record>(); //used to store all singles owned

    //the following arraylists are used to store the genres
    ArrayList<String> country = new ArrayList<String>();
    ArrayList<String> electronic = new ArrayList<String>();
    ArrayList<String> folk = new ArrayList<String>();
    ArrayList<String> hiphop = new ArrayList<String>();
    ArrayList<String> jazz = new ArrayList<String>();
    ArrayList<String> metal = new ArrayList<String>();
    ArrayList<String> orchestral = new ArrayList<String>();
    ArrayList<String> ost = new ArrayList<String>(); //ost = soundtracks
    ArrayList<String> pop = new ArrayList<String>();
    ArrayList<String> punk = new ArrayList<String>();
    ArrayList<String> rb = new ArrayList<String>(); //rb = r&b
    ArrayList<String> rock = new ArrayList<String>();
    ArrayList<String> single = new ArrayList<String>();
    
    String output = "";
    String genre = "";

    String albumFileName = getDefine(0);
    String singlesFileName = getDefine(1);

    records = readFile(albumFileName); //stores the albums defined in albums.txt to the records arraylist
    singles = readFile(singlesFileName); //stores the singles defined in singles.txt to the singles arraylist. If you don't have any singles, comment out this line

    for(int i = 0;i<records.size();i++){ //sorts the albums by genre by checking the genre of each record object in the records list
      genre = records.get(i).genre();
      switch(genre){
        case "Country":
          country.add(records.get(i).toStringSansGenre());
          break;
        case "Electronic":
          electronic.add(records.get(i).toStringSansGenre());
          break;
        case "Folk":
          folk.add(records.get(i).toStringSansGenre());
          break;
        case "Hip-Hop":
          hiphop.add(records.get(i).toStringSansGenre());
          break;
        case "jazz":
          jazz.add(records.get(i).toStringSansGenre());
          break;
        case "Metal":
          metal.add(records.get(i).toStringSansGenre());
          break;
        case "Orchestral":
          orchestral.add(records.get(i).toStringSansGenre());
          break;
        case "OST":
          ost.add(records.get(i).toStringSansGenre());
          break;
        case "Pop":
          pop.add(records.get(i).toStringSansGenre());
          break;
        case "Punk":
          punk.add(records.get(i).toStringSansGenre());
          break;
        case "R&B":
          rb.add(records.get(i).toStringSansGenre());
          break;
        case "Rock":
          rock.add(records.get(i).toStringSansGenre());
          break;
      }
    }

    for (int i = 0;i<singles.size();i++){ //puts the singles in a list that stores them as strings instead of record objects 
      single.add(singles.get(i).toStringSansGenre());
    }



    //outputs the sorted collection into the console and a text file
    System.out.println("\n");

    output += "---"+(records.size()+singles.size())+" Total Entries---\n\n"; //displays the total number of releases owned in the output

    output += "\n---Country---\n---"+country.size()+" Entries---\n\n";//diplays what genre for the section and the number of albums in that genre, functions the same for each time a line similar to this is called 
    Collections.sort(country,String::compareToIgnoreCase);//sorts the albums by artist, year, then album name. This line does the same thing for each time something similar to it is called 
    for (int i = 0;i<country.size();i++){//puts the albums stored in the arraylist into the output variable. functions the same for each time a line similar to this is called 
      output += country.get(i) + "\n";
    }
    output += "\n---Electronic---\n---"+electronic.size()+" Entries---\n\n";
    Collections.sort(electronic,String::compareToIgnoreCase);
    for (int i = 0;i<electronic.size();i++){
      output += electronic.get(i) + "\n";
    }
    output += "\n---Folk---\n---"+folk.size()+" Entries---\n\n";
    Collections.sort(folk,String::compareToIgnoreCase);
    for (int i = 0;i<folk.size();i++){
      output += folk.get(i) + "\n";
    }
    output += "\n---Hip-Hop---\n---"+hiphop.size()+" Entries---\n\n";
    Collections.sort(hiphop,String::compareToIgnoreCase);
    for (int i = 0;i<hiphop.size();i++){
      output += hiphop.get(i) + "\n";
    }
    output += "\n---Jazz---\n---"+jazz.size()+" Entries---\n\n";
    Collections.sort(jazz,String::compareToIgnoreCase);
    for (int i = 0;i<jazz.size();i++){
      output += jazz.get(i) + "\n";
    }
    output += "\n---Metal---\n---"+metal.size()+" Entries---\n\n";
    Collections.sort(metal,String::compareToIgnoreCase);
    for (int i = 0;i<metal.size();i++){
      output += metal.get(i) + "\n";
    }
    output += "\n--Orchestral---\n---"+orchestral.size()+" Entries---\n\n";
    Collections.sort(orchestral,String::compareToIgnoreCase);
    for (int i = 0;i<orchestral.size();i++){
      output += orchestral.get(i) + "\n";
    }
    output += "\n---OST---\n---"+ost.size()+" Entries---\n\n";
    Collections.sort(ost,String::compareToIgnoreCase);
    for (int i = 0;i<ost.size();i++){
      output += ost.get(i) + "\n";
    }
    output += "\n---Pop---\n---"+pop.size()+" Entries---\n\n";
    Collections.sort(pop,String::compareToIgnoreCase);
    for (int i = 0;i<pop.size();i++){
      output += pop.get(i) + "\n";
    }
    output += "\n---Punk---\n---"+punk.size()+" Entries---\n\n";
    Collections.sort(punk,String::compareToIgnoreCase);
    for (int i = 0;i<punk.size();i++){
      output += punk.get(i) + "\n";
    }
    output += "\n--R&B---\n---"+rb.size()+" Entries---\n\n";
    Collections.sort(rb,String::compareToIgnoreCase);
    for (int i = 0;i<rb.size();i++){
      output += rb.get(i) + "\n";
    }
    output += "\n---Rock---\n---"+rock.size()+" Entries---\n\n";
    Collections.sort(rock,String::compareToIgnoreCase);
    for (int i = 0;i<rock.size();i++){
      output += rock.get(i) + "\n";
    }
    output += "\n---Singles---\n---"+single.size()+" Entries---\n\n";
    Collections.sort(single,String::compareToIgnoreCase);
    for (int i = 0;i<single.size();i++){
      output += single.get(i) + "\n";
    }

    System.out.println(output); //displays the output


    try{ //creates the file that the output will be stored in if it doesn't already exist
      File outputFile = new File(getDefine(2));
      if (outputFile.createNewFile()){
        System.out.println("\n\n\nFile Created Successfully.");
      }else{
        System.out.println("\n\n\nFile already exists.");
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }

    try{ //writes the output to the file. the previous output is cleared if it exists 
      FileWriter writer = new FileWriter(getDefine(2));
      writer.write(output);
      writer.close();
      System.out.println("File successfully updated.");
    }
    catch(IOException e){
      e.printStackTrace();
    }


    
  }
}