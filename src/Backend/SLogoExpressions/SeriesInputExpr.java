package Backend.SLogoExpressions;

public abstract class SeriesInputExpr extends Expression{

    private String expressionType;
    private String seriesInput;

    public SeriesInputExpr(String input, String type){
        super(input);
        expressionType = type;
        //TODO: add logic to determine what is the series of input in the list or group
    }

    public String getSeriesInput(){
        return seriesInput;
    }
}
