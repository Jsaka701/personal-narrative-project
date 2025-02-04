import org.code.theater.*;
import org.code.media.*;
public class ImageFilter extends ImagePlus {
  
public ImageFilter(String filename) {
    super(filename);
}

public void pixelate(int gridSize) {
    int numRows = getHeight();  
    int numCols = getWidth();   
    
    for (int rowStart = 0; rowStart < numRows; rowStart += gridSize) {
        for (int colStart = 0; colStart < numCols; colStart += gridSize) {
            int rowEnd = Math.min(rowStart + gridSize, numRows);
            int colEnd = Math.min(colStart + gridSize, numCols);
            
            int redSum = 0;
            int greenSum = 0; 
            int blueSum = 0;
            int pixelCount = 0;
          
            for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); 
                    redSum += pixel.getRed();
                    greenSum += pixel.getGreen();     
                    blueSum += pixel.getBlue();      
                    pixelCount++;
                }
            }
            
            int avgRed = redSum / pixelCount;
            int avgGreen = greenSum / pixelCount;
            int avgBlue = blueSum / pixelCount;
            
            for (int row = rowStart; row < rowEnd; row++) {
                for (int col = colStart; col < colEnd; col++) {
                    Pixel pixel = getPixel(row, col); 
                    pixel.setRed(avgRed);
                    pixel.setGreen(avgGreen);
                    pixel.setBlue(avgBlue);
                }
            }
        }
    }
}
  
public void adjustContrast(int multiplier) {

    // 2D Array Pixel
Pixel[][] pixels = getPixelsFromImage();

    // Travereses the 2D Array Pixel
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
      Pixel currentPixel = pixels[row][col];

        // RGB Pixel Values Time By Multiplier Value
        int red = multiplier * currentPixel.getRed();
        int green = multiplier * currentPixel.getGreen();
        int blue = multiplier * currentPixel.getBlue();

    // Sets the the RGB Pixel Values to the new values after being multiplied
    currentPixel.setColor(new Color(red, green, blue));

    
   } 
  }
 }
 public void makeNegative() {

 Pixel[][] pixels = getPixelsFromImage();

    //traverse the array of pixels
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
      Pixel currentPixel = pixels[row][col];

        // invert the color of the pixel
        int red = 255 - currentPixel.getRed();
        int green = 255 - currentPixel.getGreen();
        int blue = 255 - currentPixel.getBlue();
//set the new color 
        currentPixel.setColor(new Color(red, green, blue));
    }

}
 }
public void makeRed() {

    // 2D Array Pixel
Pixel[][] pixels = getPixelsFromImage();

    // Travereses the 2D Array Pixel
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
      Pixel currentPixel = pixels[row][col];

        // RGB Pixel Values Time By Multiplier Value
        int red = 4 * currentPixel.getRed();
        int green = 0 * currentPixel.getGreen();
        int blue = 0 * currentPixel.getBlue();

    // Sets the the RGB Pixel Values to the new values after being multiplied
    currentPixel.setColor(new Color(red, green, blue));

    
   } 
  }
 }

 }
