public abstract class Artist implements Comparable<Artist> {

    private static int numArtists = 0;
    private String name;
    private String style;
    private int monthsExperience;
    private boolean booked;

    Artist(String name, String style, int monthsExperience) {
        this.name = name;
        this.style = style;
        this.monthsExperience = monthsExperience;
        booked = false;

        Artist.numArtists++;
    }

    public static int getNumberOfArtists() {
        return Artist.numArtists;
    }

    public String book() {

        if (booked) {
            return "The Artist known as " + this.name + " was already booked.";
        } else {
            booked=true;
            return "The Artist known as " + this.name + " has now been booked.";
        }
    }

    /* removed for m5

    void cancelArtist() {
        System.out.println("The booking for Artists known as " + this.name + " is now cancelled.");
    }

    void pairWith(Artist _artist) {
        System.out.println("The Artist known as " + this.name + "is now working with " + _artist.getName());
    }

    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getMonthsExperience() {
        return monthsExperience;
    }

    public void setMonthsExperience(int monthsExperience) {
        this.monthsExperience = monthsExperience;
    }

    @Override
    public String toString() {
        return "name: " + name + '\t' +
                "style: " + style + '\t' +
                "monthsExperience: " + monthsExperience;
    }


    @Override
    public int compareTo(Artist o) {
        return Integer.compare(this.monthsExperience, o.monthsExperience);
    }
}
