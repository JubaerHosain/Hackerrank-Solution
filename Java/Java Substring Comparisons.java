

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=0; i <= s.length() - k; i++){
            String current = s.substring(i, i+k);
            if(smallest.compareTo(current) > 0 ){
                smallest = current;
            }

            if(largest.compareTo(current) < 0 ){
                largest = current;
            }
        }

        
        return smallest + "\n" + largest;
    }

