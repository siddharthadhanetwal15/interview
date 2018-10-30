package com.skillenza;

import java.util.Scanner;

public class Tournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTeams = scanner.nextInt(); // 2M
        int noOfGamesPlayedInTournament = noOfTeams / 2;

        int tempNoOfGames = noOfGamesPlayedInTournament;

        int[][] resultArr = new int[noOfGamesPlayedInTournament][2];

        int gameNo = 0;
        int one=1;
        if(noOfGamesPlayedInTournament > one && noOfGamesPlayedInTournament < 1000)
        {
            while(gameNo != tempNoOfGames){
                int noOfGamesBetweenEachTeam = scanner.nextInt();
                if(noOfGamesBetweenEachTeam >one && noOfGamesBetweenEachTeam < 1000) {
                    int team1Scores[] = new int[noOfGamesBetweenEachTeam];
                    int i = 0;
                    while (scanner.hasNextInt()) {
                        team1Scores[i] = scanner.nextInt();
                        if(team1Scores[i] <= one || team1Scores[i] > 100){
                            System.out.println("team member1 score value entered is either less than 1 or greater than 100");
                            System.exit(0);
                        }
                        i++;
                        if (noOfGamesBetweenEachTeam == i) {
                            break;
                        }
                    }
                    int team2Scores[] = new int[noOfGamesBetweenEachTeam];
                    int j = 0;
                    while (scanner.hasNextInt()) {
                        team2Scores[j] = scanner.nextInt();
                        if(team2Scores[j] <= one || team2Scores[j] > 100){
                            System.out.println("team member2 score value entered is either less than 1 or greater than 100");
                            System.exit(0);
                        }
                        j++;
                        if (noOfGamesBetweenEachTeam == j) {
                            break;
                        }
                    }

                    int team1 = 0;
                    int team2 = 0;
                    for (int k = 0; k < noOfGamesBetweenEachTeam; k++) {
                        if (team1Scores[k] > team2Scores[k]) {
                            team1 = team1 + 1;
                        } else if (team1Scores[k] < team2Scores[k]) {
                            team2 = team2 + 1;
                        }
                    }
                    //
                    storeResults(team1, team2, noOfGamesPlayedInTournament, resultArr, gameNo);
                    gameNo++;
                }else{
                    System.out.println("Value of N(total number of players) is higher or lower then specified limits");
                    System.exit(0);
                    break;
                }
            }
            printResult(resultArr, noOfGamesPlayedInTournament);
        }else{
            System.out.println("Value of M(total number of games played) is higher or lower then specified limits");
            System.exit(0);
        }
    }

    static void storeResults(int team1, int team2, int noOfGamesPlayedInTournament, int[][] resultArr, int gameNo){
        for(int outer = gameNo; outer < noOfGamesPlayedInTournament; outer++){
            int inner = 0;
            resultArr[outer][inner] = team1;
            resultArr[outer][inner+1] = team2;
        }
    }

    static void printResult(int resultArr[][], int noOfGamesPlayedInTournament){
        for(int i = 0; i < noOfGamesPlayedInTournament; i++){
            StringBuilder result=new StringBuilder();
            for(int j = 0; j < 2; j++){
                result.append(resultArr[i][j] + " ");
                if(j==1){
                    result.deleteCharAt(result.length());
                }
                System.out.print(result.toString());
            }
            System.out.println();
        }
    }
}
