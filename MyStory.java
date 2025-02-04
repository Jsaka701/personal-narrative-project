import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

//Instantiates all images used as an ImageFilter Varaible to be able to use filters
ImageFilter logo = new ImageFilter("valorant.png");
ImageFilter logo2 = new ImageFilter("valorantlogo.png");
ImageFilter roles = new ImageFilter("Roles.png");
ImageFilter duelists = new ImageFilter("Duelists.png");
ImageFilter initiators = new ImageFilter("Initiators.png");
ImageFilter sentinels = new ImageFilter("Sentinels.png");
ImageFilter controllers = new ImageFilter("Controllers.png");
ImageFilter topfive = new ImageFilter("topfive.png");
ImageFilter wow = new ImageFilter("wow.png");




//2D Array of All the valorant Characters Separated by row based off their roles
String[][] valCharacters = {
            {"Chamber", "Cypher", "Deadlock", "Killjoy", "Sage", "Vyse"}, // All Sentinels
            {"Astra", "Brimstone", "Clove", "Harbor", "Viper"}, // All Controllers
            {"Iso", "Jett", "Neon", "Phoenix", "Raze", "Reyna", "Yoru"}, // All Duelists
            {"Breach", "Fade", "Gekko", "Kay/o", "Skye", "Sova", "Tejo"} // All Intiators
        };

// 2D array of Top Five Players in Valorant each column being different (Kills/Death, Dmg/Round, Headshot %)
double[][] topFive = {
            {1.47, 192.3, 11.1}, // #1 Player Articuno
            {1.45, 181.1, 21.1}, // #2 Player Zeldris
            {1.21, 151.8, 11.7}, // #3 Player Mad Max
            {1.23, 167.7, 11.5}, // #4 Player Curry
            {1.71, 200.8, 9.3}, // #5 Player iii
        };
  

//Creates method of intro which outputs the intro scene 
public void intro(){
  clear("white");
  setTextHeight(30);
  drawText("Today We'll Talk About...", 31, 160);
  pause(3.0);
  clear("white");
  logo.pixelate(7);
  drawImage(logo, 0, 0, 400);
  pause(2.0);
  drawImage(logo2, 0, 0, 400);
  playSound("music.wav");
  pause(3.0);
}
  
//Creates method of character which outputs the character scene to introduce all the different characters
public void characters(){
  clear("white");
  setTextHeight(20);
  drawText("There are four roles you can choose from", 20, 160);
  pause(3.0);
  drawImage(roles, 0, 0, 415);
  pause(3.0);
  roles.makeNegative();
  drawImage(roles, 0, 0, 415);
  pause(2.0);
  clear("white");
  setTextHeight(40);
  drawText("Meet The Duelists", 50, 170);
  pause(3.0);
  playSound("Phoenix-Ultimate---Come-on-Let's-go-(Valorant-Sound-Effect).wav");
  drawImage(duelists, 0, 10, 400);
  pause(2.0);
  duelists.adjustContrast(3);
  drawImage(duelists, 0, 10, 400);
  pause(3.0);
  clear("white");
  drawText("Next The Initiators", 50, 170);
  pause(3.0);
  drawImage(initiators, 0, 10, 400);
  pause(2.0);
  initiators.makeRed();
  drawImage(initiators, 0, 10, 400);
  pause(3.0);
  clear("white");
  drawText("Now The Sentinels", 45, 170);
  pause(3.0);
  drawImage(sentinels, 0, 10, 400);
  pause(5.0);
  clear("white");
  drawText("Last The Controllers", 40, 170);
  pause(3.0);
  drawImage(controllers, 0, 10, 400);
  pause(5.0);
  
}

//Creates method random Agent which outputs a randiom agent from the 2D array for the Agent of the day and also displays this in the theatre
public void randomAgent() {
        int row = (int) (Math.random() * valCharacters.length);  
        int col = (int) (Math.random() * valCharacters[0].length);
  
  clear("white");
  setTextHeight(20);
  drawText("The Valorant Character of The Day is:", 20, 120);
  pause(2.0);
  setTextHeight(40);
  drawText(valCharacters[row][col], 135, 200);
  pause(2.0);
  }
  
//Creates a method named funFact which shows Top Five valorant characters and uses averageHS to calculate the Average Headshot % of the Top Five Players
public void funFact(){
  clear("white");
setTextHeight(30);
drawText("Take a Look at the", 75, 160);
drawText("Top 5 Valorant Players", 50, 200);
pause(3.0);
drawImage(topfive, 0, 0, 400);
pause(3.0);
topfive.adjustContrast(10); //Adjust the contrast by increasing it 10x the value of what it was
drawImage(topfive, 0, 0, 400);
pause(2.0);
clear("white");
drawText("Fun Fact:", 150, 160);
pause(3.0);
clear("white");
drawText("The Average of", 90, 160);
drawText("their HeadShot % is", 60, 200);
pause(2.0);

}
public static double averageHS(double[][] topFive) {
        double sum = 0;

        for (int i = 0; i < topFive.length; i++) {
            sum += topFive[i][2]; 
        }

        return sum / topFive.length; 
    }
  
public void displayAverageHS() {
    clear("white");
    drawText("%: " + averageHS(topFive), 20, 200);
    drawImage(wow, 100, 10, 200);
    playSound("Anime-WOW---Sound-Effect-(HD).wav");
    pause(3.0);
    wow.adjustContrast(100);
}
}

