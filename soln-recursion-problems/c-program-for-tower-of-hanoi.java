/*
https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    static void towerOfHanoi(int N, int fromTower, int toTower, int helperTower){
        if(N==1){
            System.out.println("Move disk 1 from rod "+ fromTower+" to rod "+toTower); 
            return; 
        } 

        towerOfHanoi(N-1,fromTower,helperTower,toTower);
        System.out.println("Move disk "+ N + " from rod " + fromTower +" to rod " + toTower );
        towerOfHanoi(N-1,helperTower,toTower,fromTower);
    }
}