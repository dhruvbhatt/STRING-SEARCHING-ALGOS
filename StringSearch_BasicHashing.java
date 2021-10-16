package algo.DataStructures.HashMaps;

import java.util.Arrays;
import java.util.Timer;

public class StringSearch_BasicHashing {
    public static void main(String[] args) {


        String txt = "Generating realistic,branch-covering string inputs is a challenging problem, due to the diverse and complex types of real-world data that are naturally " +
                "encodable as strings, for example resource locators, dates of different localised formats, international banking codes, and national identity numbers. " +
                "This paper presents an approach in which examples of inputs are sought from the Internet by reformulating program identifiers into web queries. " +
                "The resultant URLs are downloaded, split into tokens, and used to augment and seed a search-based test data generation technique. The use of the Internet as " +
                "part of test input generation has two key advantages. Firstly, web pages are a rich source of valid inputs for various types of string data that may be used to improve " +
                "test coverage. Secondly, the web pages tend to contain realistic, human-readable values, which are invaluable when test cases need manual confirmation due to the lack of " +
                "an automated oracle. An empirical evaluation of the approach is presented, involving string input validation code from 10 open source projects. Well-formed, valid string " +
                "inputs were retrieved from the web for 96% of the different string types analysed. Using the approach, coverage was improved for 75% of the Java classes studied by an " +
                "average increase of 14%.";
        String pattern = "increase";
        long startTime = System.nanoTime();
        int j=pattern.length()-1;
        //METHOD 2
        boolean flag=false;
        for(int i=0;i<txt.length()-pattern.length()+1;i++)
        {
            if(pattern.hashCode()==txt.substring(i,j+1).hashCode())
            {
                if (pattern.equalsIgnoreCase(txt.substring(i,j+1)))
                {
                    flag=true;
                    break;
                }
            }
            j++;
        }
        if(flag)
            System.out.println("it exists");
        else
            System.out.println("not there");
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
