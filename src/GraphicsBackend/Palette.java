package GraphicsBackend;

import javafx.scene.paint.Color;

import java.util.Collection;

public class Palette {

    private Color[] myColorPalette;

    public Palette(){
        myColorPalette = new Color[256];
        myColorPalette[0] = Color.BLACK;
        myColorPalette[1] = Color.WHITE;
        myColorPalette[2] = Color.RED;
        myColorPalette[3] = Color.BLUE;
        myColorPalette[4] = Color.GREEN;
    }

    public Color[] getColorPalette(){
        return myColorPalette;
    }

    public Color getColor(int index){
        return myColorPalette[index];
    }

    public void setMyColorPalette(int index, Color color){
        myColorPalette[index] = color;
    }

    public int getColorIndex(Color color){
        for(int a=0; a<myColorPalette.length; a++){
            if (myColorPalette[a] == color){
                return a;

            }
        }
        return 0;
    }
}
