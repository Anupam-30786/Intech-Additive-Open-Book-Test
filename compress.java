
class compress {
    static int k = 0;

    // Driver code
    public static void main(String[] args) {
        String inputString = "aaabbbccdde"; // User given string

        String firstRoundCompression = StringCopression(inputString);
        System.out.println(firstRoundCompression);
        String secondRoundCompressedString = SecondRoundCompression(firstRoundCompression);
        System.out.println(secondRoundCompressedString);
        System.out.println(deCompress(secondRoundCompressedString));
    }

    // Perform first level string compression on any given string
    public static String StringCopression(String UnCompressedString) {
        String CompressedString = "";
        int i = 1;
        int count = 1;
        while (i < UnCompressedString.length()) {
            if (UnCompressedString.charAt(i) == UnCompressedString.charAt(i - 1)) {
                // increment counter if sunsequent characters are same
                count++;
            } else {
                /*
                 * On getting non-matching sunsequent character, update our compressed
                 * string with the character and it's count
                 */
                CompressedString = CompressedString + UnCompressedString.charAt(i - 1) + String.valueOf(count);
                count = 1;
            }
            i++;
        }

        // Add last character occurences which always get left on loop break
        CompressedString = CompressedString + UnCompressedString.charAt(i - 1) + String.valueOf(count);

        return CompressedString;
    }

    public static int CountNumber(char[] chr, int i) {
        String numberString = "";
        k = i;
        while (k < chr.length) {
            if (Character.isDigit(chr[k])) {
                numberString = numberString + chr[k];
                k++;
                continue;
            }
            break;
        }

        return Integer.parseInt(numberString);
    }

    // Perform second level of compression on given string
    public static String SecondRoundCompression(String str) {
        String ans = "";
        char ch[] = str.toCharArray();
        char currentChar = '\0';
        char lastChar = ch[0];
        int lastCount = CountNumber(ch, 1);
        for (int i = k; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                int count = CountNumber(ch, i);
                i = k - 1;
                if (count == lastCount) {
                    ans = ans + (lastChar);
                } else {
                    ans = ans + lastChar + Integer.toString(lastCount);
                }
                lastCount = count;
                lastChar = currentChar;
            } else {
                currentChar = ch[i];
            }
        }
        ans = ans + lastChar + lastCount;

        return ans;
    }

    // De-Compress given second round compressed string to original string
    public static String deCompress(String compressedString) {
        String deCompressedStr = "";
        int startScannedCharIndex = 0;
        int endScannedCharIndex = 0;
        char ch[] = compressedString.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                endScannedCharIndex = i - 1;
                int Number = CountNumber(ch, i);
                for (int start = startScannedCharIndex; start <= endScannedCharIndex; start++) {
                    int count = Number;
                    while (count > 0) {
                        deCompressedStr = deCompressedStr + ch[start];
                        count--;
                    }
                }
                i = k - 1;
                startScannedCharIndex = k;
            }
        }

        return deCompressedStr;
    }
}
