public class Tournament {
    private final int participants;
    private final String section;
    private final int year;
    private final String country;
    private final String title;
    private final String subsection;

    public Tournament(int participants, String section, int year, String country, String title, String subsection) {
        this.participants = participants;
        this.section = section;
        this.year = year;
        this.country = country;
        this.title = title;
        this.subsection = subsection;
    }

    public int getParticipants() {
        return participants;
    }

    public String getSection() {
        return section;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTitle() {
        return title;
    }

    public String getSubsection() {
        return subsection;
    }
}
