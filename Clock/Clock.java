/******************************************************************************
 *  Compilation:  javac Clock.java
 *  Execution:    java Clock
 *  Dependencies: none
 *
 *  Creates the data type Clock and tests it when executed.
 *
 *  java Clock
 *  Testing Borders
 *  Clock A 23:59
 *  Clock B 00:00
 *  Testing Time
 *  Clock C 15:12
 *  Testing isEarlierThan On A And B (Should Return False)
 *  false
 *  Testing tic On Clock A
 *  00:00
 *  Testing toc On Clock B (Adding 5 Minutes)
 *  00:05
 *  
 *  By Arib Chowdhury Pd.3 and Jason Chan Pd.8
 *
 ******************************************************************************/

public class Clock {

    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m){
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException("Hours should be between 0 and 23 and minutes should bebetween 0 and 59");
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s){
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException("Hours should be between 0 and 23 and minutes should bebetween 0 and 59");
        hours = h;
        minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){
        String h, m;
        if(hours < 10) h = "0" + hours;
        else h = hours + "";
        if(minutes < 10) m = "0" + minutes;
        else m = minutes + "";
        String time = h + ":" + m;
        return time;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that){
        return (hours * 60 + minutes < that.hours * 60 + that.minutes);
    }

    // Adds 1 minute to the time on this clock.
    public void tic(){
        if (minutes == 59) {
        minutes = 0;
        hours++;
        if (hours == 24) hours = 0;
        }
        else minutes++;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta){
        if (delta < 0) throw new IllegalArgumentException("Cannot add a negative number of minutes to the current time");
        hours += delta / 60;
        minutes += delta % 60;
        if (minutes > 59) {
            hours += minutes / 60;
            minutes %= 60;
        }
        hours %= 24;
    }

    // Test client (see below).
    public static void main(String[] args){
        Clock a = new Clock(23, 59);
        Clock b = new Clock(0, 0);
        System.out.println("Testing Borders");
        System.out.println("Clock A " + a);
        System.out.println("Clock B " + b);
        System.out.println("Testing Time");
        Clock c = new Clock(15, 12);
        System.out.println("Clock C " + c);
        System.out.println("Testing isEarlierThan On A And B (Should Return False)");
        System.out.println(a.isEarlierThan(b));
        System.out.println("Testing tic On Clock A");
        a.tic();
        System.out.println(a);
        System.out.println("Testing toc On Clock B (Adding 1700 Minutes)");
        b.toc(1700);
        System.out.println(b);
    }
}