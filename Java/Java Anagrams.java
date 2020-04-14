

    static boolean isAnagram(String a, String b) {
        if(a == null || b == null || (a.length() != b.length()) ){
            return false;
        }

        char[] firstArray = a.toLowerCase().toCharArray();
        char[] secondArray = b.toLowerCase().toCharArray();

        int[] counts = new int[26];
        
        for(int i=0; i<a.length(); i++){
           counts[firstArray[i] - 97]++;
           counts[secondArray[i] - 97]--;
        }

        for(int i=0; i<26; i++){
            if(counts[i] != 0){
                return false;
            }
        }

        return true;
    }

