package algo.DataStructures.HashMaps;

public class RabinKarp {
    /**
     * @param THIS_CODE_MANTAINS_ROLLING_HASH_TO_ENSURE_THAT_THE_RUNTIME_IS_CONSTANT
     **/
    public static void main(String[] args) {

        int k=113;
        int a = (int) ((2147483649.0) % k);//results in 9. Used for values exceeding INT range

        String txt = "Generating realistic,branch-covering string inputs is a challenging problem, due to the diverse and complex types of real-world data that are naturally " +
                "encodable as strings, for example resource locators, dates of different localised formats, international banking codes, and national identity numbers. " +
                "This paper presents an approach in which examples of inputs are sought from the Internet by reformulating program identifiers into web queries. " +
                "The resultant URLs are downloaded, split into tokens, and used to augment and seed a search-based test data generation technique. The use of the Internet as " +
                "part of test input generation has two key advantages. Firstly, web pages are a rich source of valid inputs for various types of string data that may be used to improve " +
                "test coverage. Secondly, the web pages tend to contain realistic, human-readable values, which are invaluable when test cases need manual confirmation due to the lack of " +
                "an automated oracle. An empirical evaluation of the approach is presented, involving string input validation code from q open source projects. Well-formed, valid string " +
                "inputs were retrieved from the web for 96% of the different string types analysed. Using the approach, coverage was improved for 75% of the Java classes studied by an " +
                "average increase of 14%.";
        String pattern = "increase";
        long startTime = System.nanoTime();
        int patternHash = 0;
        int ogHash = 0;
        int mod=2281;
        int q=10;
        for (int i = 0; i < pattern.length(); i++) {
            patternHash = (patternHash * q + pattern.charAt(i))%mod;
            ogHash = (ogHash * q + txt.charAt(i))%mod;
}
//        System.out.println(pattern+":"+patternHash);
        boolean flag = false;
        for (int i = 0; i < txt.length() - pattern.length(); i++) {

//            System.out.println(txt.substring(i, i + pattern.length())+":"+ogHash);
            if (patternHash == ogHash) {
                if (pattern.equalsIgnoreCase(txt.substring(i, i + pattern.length()))) {
                    flag = true;
                    break;
                }
            }
            //s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
            // h = 31 * h + getChar(value, i);
            ogHash = ((ogHash - (txt.charAt(i) * ((int) ((Math.pow(q, pattern.length() - 1))%mod)))) * q + txt.charAt(i + pattern.length()))%mod;
            if(ogHash<0)
                ogHash=ogHash+mod;//since -negative numbers result in negative mod values
 }
        if (flag)
            System.out.println("found");
        else
            System.out.println("not found");
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
