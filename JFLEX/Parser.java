import java.io.*;
import java.util.*;

public class Parser {
	public static String addNewline(String print) {
		Scanner scanner = new Scanner(print);
		String build = "";
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			build += "\t" + line + "\n";
		}
		scanner.close();
		return build;
	}

	public static void main (String[] args) throws IOException {
		HelloLexer l = new HelloLexer(new FileReader("input"));
		l.yylex();

		l.stack.pop();
		//System.out.println(l.stack.pop().show());
		PrintWriter writer = new PrintWriter("arbore", "UTF-8");
		PrintWriter writer1 = new PrintWriter("output", "UTF-8");
		String parsat = l.stack.peek().show().replaceAll("[^\\x00-\\x7F]", "");
		writer.print(parsat);
		writer.close();
		UndeclaredVariablesList.getInstance().execute();
		l.stack.peek().interpret(0);

		String buffer = "";
		for (Map.Entry<String, Integer> entry : VarList.getInstance(null).variables.entrySet()) {
			if(entry.getValue() == Integer.MAX_VALUE)
    			buffer += entry.getKey()+ "=" + "null" + "\n";
			else
				buffer += entry.getKey()+ "=" +entry.getValue() + "\n";
		}

		writer1.print(buffer);
		writer1.close();
	}
}
