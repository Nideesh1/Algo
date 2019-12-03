class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] DaysByMonthMod7 = {0,3,2,5,0,3,5,1,4,6,2,4}; // Jan: 0, Feb: 31%7=3, Mar: 58%7=2, Apr: 89%7=5, etc
        if(month < 3) year -= 1; // 3
        return daysInWeek[((year + (year/4 - year/100 + year/400) + DaysByMonthMod7[month-1] + day)) % 7]; // (year*365)%7 = year. Add the leap year days. Add extra month days. Add day.
    }
}

//https://leetcode.com/problems/day-of-the-week/
