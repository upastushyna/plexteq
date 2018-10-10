package ua.danit.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {
  private static final char DEFAULT_SEPARATOR = ';';

  public static void writeLine(Writer w, List values) throws IOException {
    writeLine(w, values, DEFAULT_SEPARATOR, ' ');
  }

  public static void writeLine(Writer w, List values, char separators) throws IOException {
    writeLine(w, values, separators, ' ');
  }

  //https://tools.ietf.org/html/rfc4180
  private static String followCVSformat(String value) {

    String result = value;
    if (result.contains("\"")) {
      result = result.replace("\"", "\"\"");
    }
    return result;

  }

  public static void writeLine(Writer w, List values, char separators, char customQuote) throws IOException {

    boolean first = true;

    //default customQuote is empty

    if (separators == ' ') {
      separators = DEFAULT_SEPARATOR;
    }

    StringBuilder sb = new StringBuilder();
    for (Object value : values) {
      if (!first) {
        sb.append(separators);
      }
      if (customQuote == ' ') {
        sb.append(followCVSformat((String) value));
      } else {
        sb.append(customQuote)
            .append(followCVSformat((String) value))
            .append(customQuote);
      }

      first = false;
    }
    sb.append("\n");
    w.append(sb.toString());

  }
}