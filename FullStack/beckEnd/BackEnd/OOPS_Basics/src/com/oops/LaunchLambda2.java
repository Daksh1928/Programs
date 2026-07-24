package com.oops;

interface FI {
    int lengthOfWord(String name);
}

class FIimpl implements FI {
    public int lengthOfWord(String name) {
        return name.length();
    }
}

public class LaunchLambda2 {
    public static void main(String[] args) {
        FI fi1 = new FIimpl();
        System.out.println(fi1.lengthOfWord("DEvasnhu Rana"));

        FI fil2 = new FI() {
            public int lengthOfWord(String name) {
                return name.length();
            }
        };
        System.out.println(fil2.lengthOfWord("Yashika Dhaliya"));
        FI f = (String name) -> {
            return name.length();
        };
        System.out.println(f.lengthOfWord("Aditya Rana"));
    }
}

// in lambda when we are returning something we can't write it in one line 
// Like  FI f = (String name) ->  return name.length(); { NOT ACCPETABLE }
// Lambda expression is just like arrow function in js 