package dat.carport.model.services;

public class SVG
{
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" "+
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String lineTemplate = "<line x1= \"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"#000000\" stroke-width=\"2\" />";

    public SVG(int x, int y, String viewBox, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y ));
    }

    private final String textTemplate = "<text transform=\"translate(%d,%d) rotate(%d)\">%s</text>";

    public void addText(int x, int y, int r, String text){
        svg.append(String.format(textTemplate, x, y, r, text));
    }
    public void addRect(int x, int y, double height, double width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width).replaceAll(",","."));
    }

    public void addLine(int x1, int y1, int x2, int y2 )
    {
        svg.append(String.format(lineTemplate, x1, y1, x2, y2).replaceAll(",","."));
    }

    @Override
    public String toString()
    {
        return svg.toString() + "</svg>" ;
    }
}
