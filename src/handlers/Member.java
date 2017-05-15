/*******************************************************************************
 * Member.java
 * Clara Durling
 * 
 * This class contains methods to be able to work with the information of a
 * single member of the text program.
 ******************************************************************************/
package handlers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Member extends Handlers{
    
    private final String phoneNumber;
    private String birthday;
    private int visits;
    private List<Reward> rewards;
    private int dayLast;
    private int yearLast;
    
    //**************************************************************************
    
    public Member(String phoneNumber, String birthday){
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.visits = 0;
        this.rewards = new ArrayList();
    }
    
    //**************************************************************************
    
    public Boolean checkedInToday(int dayNew, int yearNew) {
        return ((this.dayLast == dayNew) && (this.yearLast == yearNew));  
    }
    
    //**************************************************************************
    
    public String getBirthday(){
        return this.birthday;
    }
    
    //**************************************************************************
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    //**************************************************************************
    
    public String visitsMessage(){ 
        String message;
        
        this.visits++;
        
        if(this.visits == 5 || this.visits == 10){
            if(this.visits == 10){
                message = "Congrats! You've earned a free buffet!";
                this.visits = 0;
                this.earnedNewReward("Free Buffet");
            }else{
                message = "Congrats! You've earned a free drink!";
                this.earnedNewReward("Free Drink");
            }
        }else{
            int checkInShow;
            int checkInsLeft = 10 - this.visits;
            if(checkInsLeft > 5){
                checkInShow = checkInsLeft - 5;
            }else{
                checkInShow = checkInsLeft;
            }
            
            if(checkInShow == 1){
                message = "You have 1 visit remaining.";
            }else{
                message = "You have " + checkInShow + " visits remaining.";
            }
        }
        
        return message;
    }
    
    //**************************************************************************
    
    public List<Reward> getRewards(){
        return this.rewards;
    }
    
    //**************************************************************************
    
    public void earnedNewReward(String deal){
        int month = CALENDAR.get(Calendar.MONTH) + 1;
        int day = CALENDAR.get(Calendar.DAY_OF_MONTH);
        String dateEarned = month + "/" + day;
        
        Reward reward = new Reward(dateEarned, deal);
        rewards.add(reward);
    }
    
    //**************************************************************************
    
    public void redeemReward(Reward reward){
        rewards.remove(reward);
    }
    
    //**************************************************************************
    
    public Boolean hasRewards(){
        return this.rewards.isEmpty();
    }
    
    //**************************************************************************
    
    public Boolean isBirthday(){
        String[] splitBirthday = this.birthday.split("/");
        
        int monthSaved = Integer.parseInt(splitBirthday[0].trim());
        int daySaved = Integer.parseInt(splitBirthday[1].trim());
        int month = CALENDAR.get(Calendar.MONTH) + 1;
        int day = CALENDAR.get(Calendar.DAY_OF_MONTH);
        
        return daySaved == day && monthSaved == month;
    }
    
    //**************************************************************************
    
    public void setLastCheckIn(int day, int year){
        this.dayLast = day;
        this.yearLast = year;
    }
    
    //**************************************************************************

    @Override
    public String toString() {
        return "Member: " + "Phone number: " + phoneNumber + ", birthday: " + 
                birthday  + ", last check-in: day " + dayLast + " of the year " 
                + yearLast;
    }
    
} // End class Member
