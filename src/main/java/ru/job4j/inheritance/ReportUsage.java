package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JsonReport report1 = new JsonReport();
        String text1 = report1.generate("Json name", "Json Body");
        System.out.println(text1);
    }
}
