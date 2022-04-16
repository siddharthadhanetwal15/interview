package com.StringAlgorithms;

public class BruteForce {

    public int matchStringUsingBruteForce(char T[], int n, char P[], int m) {
        for (int i = 0; i <= n - m; i++) {    //n-m = to iterate only till n-m length.. because further check will be done by j loop
            int j = 0;
            while (j < m && P[j] == T[i + j]) {
                j = j + 1;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        char T[] = {'s', 'i', 'd', 'd', 'h', 'a'};
        char P[] = {'i', 'd'};
        System.out.println(bruteForce.matchStringUsingBruteForce(T, T.length, P, P.length));
    }
}
