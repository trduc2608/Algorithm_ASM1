public class Student {
    private String ID;
    private String name;
    private double mark;
    private String rank;

    public Student(String ID, String name, double mark) {
        this.ID = ID;
        this.name = name;
        this.mark = mark;
        this.rank = findRanking();
    }

    private String findRanking() {
        if(mark <= 5.0){
            return "Fail";
        } else if(mark <= 6.5){
            return "Medium";
        } else if(mark <= 7.5){
            return "Good";
        } else if(mark <= 9.0){
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
        this.rank = findRanking();
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Student ID: " + ID + ", Name: " + name + ", Mark: " + mark + ", Rank: " + rank;
    }
}

