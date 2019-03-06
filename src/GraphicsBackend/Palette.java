package GraphicsBackend;

import javafx.scene.paint.Color;

public class Palette {

    private Color[] myColorPalette;

    public Palette(){
        myColorPalette = new Color[256];
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
