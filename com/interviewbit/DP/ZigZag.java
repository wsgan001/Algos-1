package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
    
A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.

For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.

 
Definition
        
Class:  ZigZag
Method: longestZigZag
Parameters: int[]
Returns:    int
Method signature:   int longestZigZag(int[] sequence)
(be sure your method is public)
    
 
Constraints
-   sequence contains between 1 and 50 elements, inclusive.
-   Each element of sequence is between 1 and 1000, inclusive.
 
Examples
0)  
        
{ 1, 7, 4, 9, 2, 5 }
Returns: 6
The entire sequence is a zig-zag sequence.
1)  
        
{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }
Returns: 7
There are several subsequences that achieve this length. One is 1,17,10,13,10,16,8.
2)  
        
{ 44 }
Returns: 1
3)  
        
{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }
Returns: 2
4)  
        
{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }
Returns: 8
5)  
        
{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }
Returns: 36
 */
public class ZigZag
{
    public int longestZigZag(int[] sequence )
    {
        if( sequence == null || sequence.length == 0 )
        {
            return 0;
        }
        int n = sequence.length;
        
        if( n == 1 ) return 1;
        
        int[] T = new int[n];
        
        for( int i =0;i < n; i++ )
        {
            T[i] = 1;
        }
        
        int i = 1;
        int j = 0;
        int max = 1;
        while( i < n )
        {
            boolean flipper = true;
            while( j < i-1 )
            {
                if( flipper )
                {
                    if( sequence[j+1] - sequence[j] >= 0 )
                    {
                        T[i] = Math.max( T[i], T[j]+2 );
                        max = Math.max( max, T[i]);
                    }
                }
                else
                {
                    if( sequence[j+1] - sequence[j] < 0 )
                    {
                        T[i] = Math.max( T[i], T[j]+2 );
                        max = Math.max( max, T[i]);
                    }
                }
                
                j++;
                flipper = !flipper;
            }
            j =0;
            i++;
        }
        
        return max;
    }
    
    
    public static void main( String[] args )
    {
        ZigZag hp = new ZigZag();
        
        int[] nums ={1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        System.out.println( " Longest ZigZag = " + hp.longestZigZag( nums ) );
    }
}
