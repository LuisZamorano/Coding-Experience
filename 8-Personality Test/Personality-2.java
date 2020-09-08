
/**
 * CS312 Assignment 8.
 * 
 * On my honor, Luis Zamorano, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to read a file with raw data from a Keirsey personality test
 * and print out the results.
 *
 *  email address:cyclazluis@gmail.com
 *  UTEID:ljz238
 *  Number of slip days used on this assignment:0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Personality {

	// process the data from the personality tests
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); // do not make any other
		// Scanners connected to
		// System.in
		Scanner fileScanner = getFileScanner(keyboard);

		// CS312 students - your code and methods calls go here
		readPersonality(fileScanner);
		fileScanner.close();
		keyboard.close();
	}

	// scans the entire file and creates the result of the personality test
	public static void readPersonality(Scanner fileScanner) {
		fileScanner.nextLine();
		while (fileScanner.hasNextLine()) {
			String perName = fileScanner.nextLine();
			String recResponse = fileScanner.nextLine();
			String begSpace = startSpacing(perName);
			double extroIntro = extInt(recResponse);
			double sensingIntuitive = senIntu(recResponse);
			double thinkingFeel = thinkFeel(recResponse);
			double judgePerceive = judgePerc(recResponse);
			String extIntLetter = lettExIn(extroIntro);
			String senIntuitiveLetter = lettSeIn(sensingIntuitive);
			String thinkFeelLetter = lettTkFe(thinkingFeel);
			String judPerceiveLetter = lettJuPe(judgePerceive);
			String result = extIntLetter + senIntuitiveLetter + thinkFeelLetter + judPerceiveLetter;
			double[] ExInCount = ExIn(recResponse);
			double[] SeInCount = SeIn(recResponse);
			double[] ThFeCount = ThFe(recResponse);
			double[] JuPeCount = JuPe(recResponse);
			System.out.print(begSpace + perName + ":");
			responseSpacing(extroIntro, ExInCount);
			responseSpacing(sensingIntuitive, SeInCount);
			responseSpacing(thinkingFeel, ThFeCount);
			responseSpacing(judgePerceive, JuPeCount);
			System.out.println(" = " + result);
		}

	}

	// creates the spacing at the beginning of the file
	public static String startSpacing(String perName) {
		int spaceL = 28;
		String spacing = "";
		for (int i = perName.length(); i < spaceL; i++) {
			spacing += " ";

		}
		return spacing;

	}

	// calculates percentage for the extrovert and introvert part of the project
	public static double extInt(String recResponse) {
		double num = 0;
		double bNum = 0;

		for (int i = 0; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num++;
			} else if (letResp == 'B' || letResp == 'b') {
				bNum++;
			}
		}

		double percentB = (bNum / (bNum + num) * 100) + (0.5);
		return percentB;
	}

	// calculates percentage for sensing or intuitive part of the responses
	public static double senIntu(String recResponse) {
		double num = 0;
		double bNum = 0;

		for (int i = 1; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num++;
			} else if (letResp == 'B' || letResp == 'b') {
				bNum++;
			}
		}
		for (int secQ = 2; secQ < recResponse.length(); secQ += 7) {
			char letRespSec = recResponse.charAt(secQ);
			if (letRespSec == 'A' || letRespSec == 'a') {
				num++;
			} else if (letRespSec == 'B' || letRespSec == 'b') {
				bNum++;
			}
		}

		double percent = (bNum / (bNum + num) * 100) + (0.5);
		return percent;
	}

	// calculates percentage for the thinking or feeling responses
	public static double thinkFeel(String recResponse) {
		double num = 0;
		double bNum = 0;

		for (int i = 3; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num++;
			} else if (letResp == 'B' || letResp == 'b') {
				bNum++;
			}
		}
		for (int secQ = 4; secQ < recResponse.length(); secQ += 7) {
			char letRespSec = recResponse.charAt(secQ);
			if (letRespSec == 'A' || letRespSec == 'a') {
				num++;
			} else if (letRespSec == 'B' || letRespSec == 'b') {
				bNum++;
			}
		}

		double percentB = (bNum / (bNum + num) * 100) + (0.5);
		return percentB;
	}

	// calculates percentage for the judging and perceiving responses
	public static double judgePerc(String recResponse) {
		double num = 0;
		double bNum = 0;

		for (int i = 5; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num++;
			} else if (letResp == 'B' || letResp == 'b') {
				bNum++;
			}
		}
		for (int secQ = 6; secQ < recResponse.length(); secQ += 7) {
			char letRespSec = recResponse.charAt(secQ);
			if (letRespSec == 'A' || letRespSec == 'a') {
				num++;
			} else if (letRespSec == 'B' || letRespSec == 'b') {
				bNum++;
			}
		}

		double percentB = (bNum / (bNum + num) * 100) + (0.5);
		return percentB;
	}

	// counts the # of letters in extrovert and introvert
	public static double[] ExIn(String recResponse) {
		double[] num = new double[2];

		for (int i = 0; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num[0]++;
			}
		}
		for (int j = 0; j < recResponse.length(); j += 7) {
			char letResp2 = recResponse.charAt(j);
			if (letResp2 == 'B' || letResp2 == 'b') {
				num[1]++;
			}

		}
		return num;
	}

	// counts the # of letters for sense and intuitive
	public static double[] SeIn(String recResponse) {
		double[] num = new double[2];
		for (int i = 1; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num[0]++;
			}
		}
		for (int secQ = 2; secQ < recResponse.length(); secQ += 7) {
			char letRespSec = recResponse.charAt(secQ);
			if (letRespSec == 'A' || letRespSec == 'a') {
				num[0]++;
			}
		}

		for (int j = 1; j < recResponse.length(); j += 7) {
			char letResp2 = recResponse.charAt(j);
			if (letResp2 == 'B' || letResp2 == 'b') {
				num[1]++;
			}
		}
		for (int secQ2 = 2; secQ2 < recResponse.length(); secQ2 += 7) {
			char letRespSec2 = recResponse.charAt(secQ2);
			if (letRespSec2 == 'B' || letRespSec2 == 'b') {
				num[1]++;
			}
		}
		return num;
	}

	// counts the # of letters for thinking and feeling
	public static double[] ThFe(String recResponse) {
		double[] num = new double[2];
		for (int i = 3; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num[0]++;
			}
		}
		for (int secQ = 4; secQ < recResponse.length(); secQ += 7) {
			char letRespSec = recResponse.charAt(secQ);
			if (letRespSec == 'A' || letRespSec == 'a') {
				num[0]++;
			}
		}

		for (int j = 3; j < recResponse.length(); j += 7) {
			char letResp2 = recResponse.charAt(j);
			if (letResp2 == 'B' || letResp2 == 'b') {
				num[1]++;
			}
		}
		for (int secQ2 = 4; secQ2 < recResponse.length(); secQ2 += 7) {
			char letRespSec2 = recResponse.charAt(secQ2);
			if (letRespSec2 == 'B' || letRespSec2 == 'b') {
				num[1]++;
			}
		}

		return num;
	}

	// counts the # of letters for judging and perceiving
	public static double[] JuPe(String recResponse) {
		double[] num = new double[2];
		for (int i = 5; i < recResponse.length(); i += 7) {
			char letResp = recResponse.charAt(i);
			if (letResp == 'A' || letResp == 'a') {
				num[0]++;
			}
		}
		for (int secQ = 6; secQ < recResponse.length(); secQ += 7) {
			char letRespSec = recResponse.charAt(secQ);
			if (letRespSec == 'A' || letRespSec == 'a') {
				num[0]++;
			}
		}

		for (int j = 5; j < recResponse.length(); j += 7) {
			char letResp2 = recResponse.charAt(j);
			if (letResp2 == 'B' || letResp2 == 'b') {
				num[1]++;
			}
		}
		for (int secQ2 = 6; secQ2 < recResponse.length(); secQ2 += 7) {
			char letRespSec2 = recResponse.charAt(secQ2);
			if (letRespSec2 == 'B' || letRespSec2 == 'b') {
				num[1]++;
			}
		}

		return num;
	}

	// creates the letter based on the percentages for intro and extrovert
	public static String lettExIn(double extroIntro) {
		int extroIntrov = (int) extroIntro;
		String letterPrint = "";
		if (extroIntrov > 50) {
			letterPrint += "I";
		} else if (extroIntrov < 50 && extroIntro > 0) {
			letterPrint += "E";
		} else if (extroIntrov == 50) {
			letterPrint += "X";
		} else if (extroIntrov == 0) {
			letterPrint += "-";
		}
		return letterPrint;
	}

	// creates the letter based on the percentages for Sensing and intuitive
	public static String lettSeIn(double sensingIntuitive) {
		int sensingIntuitiven = (int) sensingIntuitive;
		String letterPrint = "";
		if (sensingIntuitiven > 50) {
			letterPrint += "N";
		} else if (sensingIntuitiven < 50 && sensingIntuitive > 0) {
			letterPrint += "S";
		} else if (sensingIntuitiven == 50) {
			letterPrint += "X";
		} else if (sensingIntuitiven == 0) {
			letterPrint += "-";
		}
		return letterPrint;
	}

	// creates the letter based on the percentages for thinking and feeling
	public static String lettTkFe(double thinkingFeel) {
		int thinkingFeeli = (int) thinkingFeel;
		String letterPrint = "";
		if (thinkingFeeli > 50) {
			letterPrint += "F";
		} else if (thinkingFeeli < 50 && thinkingFeel > 0) {
			letterPrint += "T";
		} else if (thinkingFeeli == 50) {
			letterPrint += "X";
		} else if (thinkingFeeli == 0) {
			letterPrint += "-";
		}
		return letterPrint;
	}

	// creates the letter based on the percentages for judging and perceiving
	public static String lettJuPe(double judgePerceive) {
		int judgePerceivi = (int) judgePerceive;
		String letterPrint = "";
		if (judgePerceivi > 50) {
			letterPrint += "P";
		} else if (judgePerceivi < 50 && judgePerceive > 0) {
			letterPrint += "J";
		} else if (judgePerceivi == 50) {
			letterPrint += "X";
		} else if (judgePerceivi == 0) {
			letterPrint += "-";
		}
		return letterPrint;
	}

	// makes the spacing for in between responses
	public static void responseSpacing(double percentage, double[] num) {
		if (num[0] == 0 && num[1] == 0) {
			System.out.print(" NO ANSWERS");
		} else {
			int percentages = (int) percentage;
			String percentLen = Integer.toString(percentages);
			int spaceL = 11 - percentLen.length();
			for (int i = 0; i < spaceL; i++) {
				System.out.print(" ");

			}
			System.out.print(percentages);
		}

	}

	private static String chartAt(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	// Method to choose a file.
	// Asks user for name of file.
	// If file not found create a Scanner hooked up to a dummy set of data
	// Example use:
	public static Scanner getFileScanner(Scanner keyboard) {
		Scanner result = null;
		try {
			System.out.print("Enter the name of the file with the personality data: ");
			String fileName = keyboard.nextLine().trim();
			System.out.println();
			result = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Problem creating Scanner: " + e);
			System.out.println("Creating Scanner hooked up to default data " + e);
			String defaultData = "1\nDEFAULT DATA\n" + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
					+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
			result = new Scanner(defaultData);
		}
		return result;
	}

}
