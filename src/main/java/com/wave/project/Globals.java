/**
 * 
 */
package com.wave.project;

/**
 * @author gbuah
 *
 */
public class Globals {

	private static char winner = 'o';
	private static String sentString = "";
	private static int stageCounter = 1;

	public static char getWinner() {
		return winner;
	}

	public static void setWinner(char winner) {
		Globals.winner = winner;
	}

	public static String getSentString() {
		return sentString;
	}

	public static void setSentString(String sentString) {
		Globals.sentString = sentString;
	}

	public static int getStageCounter() {
		return stageCounter;
	}

	public static void setStageCounter(int stageCounter) {
		Globals.stageCounter = stageCounter;
	}
}

