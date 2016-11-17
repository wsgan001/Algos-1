package com.interviewbit.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 *
 */

public class TextJust
{
    public List<String> fullJustify( ArrayList<String> words, int L )
    {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while ( index < words.size() )
        {
            int count = words.get( index ).length();
            int last = index + 1;
            while ( last < words.size() )
            {
                if ( words.get( last ).length() + count + 1 > L )
                    break;
                count += words.get( last ).length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if ( last == words.size() || diff == 0 )
            {
                for ( int i = index; i < last; i++ )
                {
                    builder.append( words.get( i ) + " " );
                }
                builder.deleteCharAt( builder.length() - 1 );
                for ( int i = builder.length(); i < L; i++ )
                {
                    builder.append( " " );
                }
            }
            else
            {
                // middle justified
                int spaces = ( L - count ) / diff;
                int r = ( L - count ) % diff;
                for ( int i = index; i < last; i++ )
                {
                    builder.append( words.get( i ) );
                    if ( i < last - 1 )
                    {
                        for ( int j = 0; j <= ( spaces + ( ( i - index ) < r ? 1 : 0 ) ); j++ )
                        {
                            builder.append( " " );
                        }
                    }
                }
            }
            lines.add( builder.toString() );
            index = last;
        }

        return lines;
    }
    
    public static void main(String[] args )
    {
        TextJust p = new TextJust();
        //System.out.println("Version Comparisons = " + p.compareVersion( "444444444444444444444444",  "4444444444444444444444444" ) );
    }
}
