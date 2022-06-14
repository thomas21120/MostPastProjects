/**
 * Thomas Lindley, CMSC 451
 * 15/NOV/2021
 * Reporter.java - takes benchmarking results from text file and displays them 
 * recursive quick sort algorithm implementation adapted from: https://www.geeksforgeeks.org/quick-sort/
 * iterative quick sort adapted from amit's comment: https://stackoverflow.com/questions/12553238/quicksort-iterative-or-recursive 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Reporter extends JPanel{
  static int[][] allData = new int[10][101];
  static double[] meanC = new double[10];
  static double[] standDC = new double[10];
  static double[] meanT = new double[10];
  static double[] standDT = new double[10];
  static String[][] jTableData = new String[10][5];
  static JFrame frame;
  static JTable table;
  static DecimalFormat df = new DecimalFormat("##.##%");
  static String[] columnNames = {"Size", " Avg Count", "Coef Count", "Avg Time", "Coef Time"};

  public static void getData(){
    JFileChooser jfc = new JFileChooser();
    FileNameExtensionFilter f = new FileNameExtensionFilter("Text Files", "txt");
    jfc.setFileFilter(f);
    int returnVal = jfc.showOpenDialog(null);
    BufferedReader br;
    String[][] thisLineString = new String[10][101];
    int count = 0;
    
    if (returnVal == JFileChooser.APPROVE_OPTION){
      try {
        br = new BufferedReader(new FileReader(jfc.getSelectedFile()));
        while(count < 10){
          thisLineString[count] = br.readLine().split(" ");
          for (int i = 0; i < thisLineString[count].length; i++) {
            allData[count][i] = Integer.valueOf(thisLineString[count][i]);
          }
          count++;
        }
      } catch (IOException e) {
        System.out.println("can not read selected file.");
      }
    }
  }

  public static void getSizeColumn(){
    for (int i = 0; i < 10; i++) {
      jTableData[i][0] = String.valueOf(allData[i][0]);
    }
  }

  public static void getAvgCount(){
    long sum;
    for (int i = 0; i < 10; i++) {
      sum = 0;
      for (int j = 1; j < 51; j++) {
        sum += allData[i][j];
      }
      jTableData[i][1] = String.valueOf(sum/50);
    }
  }

  public static void getMean(){
    int sum1, sum2;
    for (int i = 0; i < 10; i++) {
      sum1 = 0;
      sum2 = 0;
      for (int j = 1; j < 51; j++) {
        sum1 = sum1 + allData[i][j];
      }
      for (int x = 50; x < 101; x++) {
        sum2 = sum2 + allData[i][x];
      }
      meanC[i] = sum1/50;
      meanT[i] = sum2/50;
    }
  }

  public static void getStandardDeviation(){
    double sum1, sum2;
    for (int i = 0; i < 10; i++) {
      sum1 = 0;
      sum2 = 0;
      for (int j = 1; j < 51; j++) {
        sum1 = sum1 + (allData[i][j] - meanC[i])*(allData[i][j] - meanC[i]);
      }
      standDC[i] = Math.sqrt(sum1/50);
      for (int x = 50; x < 101; x++) {
        sum2 = sum2 + (allData[i][x] - meanT[i])*(allData[i][x] - meanT[i]);
      }
      standDT[i] = Math.sqrt(sum2/50);
    }
  }

  public static void getCoef(){
    for (int index = 0; index < 10; index++) {
      jTableData[index][2] = String.valueOf(df.format((standDC[index]/meanC[index])));
      jTableData[index][4]= String.valueOf(df.format((standDT[index]/meanT[index])));
    }
  }


  public static void getAvgTime(){
    long sum;
    for (int i = 0; i < 10; i++) {
      sum = 0;
      for (int j = 51; j < 101; j++) {
        sum += allData[i][j];
      }
      jTableData[i][3] = String.valueOf(sum/50);
    }
  }

  public static void jTableShow(){
    frame = new JFrame();
    frame.setSize(800,600);
    frame.setTitle("Benchmark Report");
    
    table = new JTable(jTableData, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main(String[] args) {
    getData();
    getSizeColumn();
    getAvgCount();
    
    getAvgTime();
    getMean();
    getStandardDeviation();
    getCoef();
    jTableShow();
    
  }
}
